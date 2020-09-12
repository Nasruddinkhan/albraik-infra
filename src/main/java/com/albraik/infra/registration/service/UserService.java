package com.albraik.infra.registration.service;

import com.albraik.infra.registration.model.UserEntity;

public interface UserService {

	public UserEntity getUserDetailsByEmail(String email);
	
}
