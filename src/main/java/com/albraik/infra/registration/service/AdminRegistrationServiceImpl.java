package com.albraik.infra.registration.service;

import static  com.albraik.infra.util.ObjectUtilMapper.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;

@Service("adminRegistrationService")
@Transactional                                                           
public class AdminRegistrationServiceImpl implements AdminRegistrationService {
	//private BCryptPasswordEncoder bcryptPasswordEncode;
	private UserRepo usrRepo;
	
	@Autowired
	public AdminRegistrationServiceImpl(UserRepo usrRepo) {
		super();
		this.usrRepo = usrRepo;
	}

	@Override
	public AdminRegisterRequestDTO save(AdminRegisterRequestDTO adRegisterRequestDTO) {
		UserEntity user = map(adRegisterRequestDTO, UserEntity.class);
		//user.setIsActive(true);
		user =  usrRepo.save(user);
		return map(user, AdminRegisterRequestDTO.class);
		// TODO Auto-generated method stub
	}
}
