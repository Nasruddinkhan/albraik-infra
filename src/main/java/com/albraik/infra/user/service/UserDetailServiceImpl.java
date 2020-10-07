package com.albraik.infra.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.user.dto.UserDTO;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	
	private UserRepo userRepo;
	
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
	public List<UserDTO> getUsers(Integer companyId, String role) {
		return userRepo.findAllByCompanyIdAndRole(companyId, role);
	}

	@Override
	public List<UserDTO> getUserJobtitle(Integer companyId, String name, String roleUser) {
		// TODO Auto-generated method stub
		return userRepo.getUserJobtitle(companyId, name, roleUser);
	}

}
