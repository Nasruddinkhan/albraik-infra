package com.albraik.infra.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<UserEntity> getUsers(Integer companyId, String role) {
		
		return userRepo.findAllByCompanyIdAndRoleAndIsActiveIsTrue(companyId, role);
	}

}
