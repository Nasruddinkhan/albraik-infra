package com.albraik.infra.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserEntity getUserDetailsByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
}
