package com.albraik.infra.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.model.UserJobEntity;
import com.albraik.infra.registration.repository.UserJobRepo;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.role.util.RoleUtil;
import com.albraik.infra.user.dto.UserDTO;
import com.albraik.infra.user.dto.UserJobDTO;
import com.albraik.infra.util.ObjectUtilMapper;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	private UserRepo userRepo;
	private UserJobRepo userJobRepo;

	@Autowired
	public UserDetailServiceImpl(final UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public List<UserJobDTO> getUserDetails(Integer companyId, String role) {
		List<UserJobDTO> userJobList = new ArrayList<>();
		List<UserEntity> userList = userRepo.findAllByCompanyIdAndRole(companyId, role);
		userList.forEach(userEntity -> {
			UserJobDTO userJob = getUserJobFromUserEntity(userEntity);
			if (userJob == null)
				return;
			userJobList.add(userJob);
		});
		return userJobList;
	}

	@Override
	public UserJobDTO getUserJobFromUserEntity(UserEntity userEntity) {
		if (userEntity == null)
			return null;

		UserJobDTO userJob = ObjectUtilMapper.map(userEntity, UserJobDTO.class);
		UserJobEntity userJobEntity = userEntity.getUserJobEntity();
		if (userJobEntity == null) {
			return userJob;
		}
		userJob.setJoiningDate(userJobEntity.getJoiningDate());
		userJob.setDepartment(userJobEntity.getDepartment());
		userJob.setRole(RoleUtil.getRolePrivilegeIdByRole(userJobEntity.getRole()));
		userJob.setJobTitle(userJobEntity.getJobTitle());
		return userJob;
	}

	@Override
	public List<UserDTO> getUserJobtitle(Integer companyId, String name, String roleUser) {
		// TODO Auto-generated method stub
		return userRepo.getUserJobtitle(companyId, name, roleUser);
	}

}
