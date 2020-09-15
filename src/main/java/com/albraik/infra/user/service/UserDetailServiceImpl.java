package com.albraik.infra.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.user.dto.UserDTO;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<UserDTO> getUsers(Integer companyId, String role) {
		
		return userRepo.findAllByCompanyIdAndRole(companyId, role);
	}

}
