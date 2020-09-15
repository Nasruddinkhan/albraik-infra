package com.albraik.infra.registration.service;

import com.albraik.infra.registration.dto.UserRegisterRequestDTO;

public interface UserRegistrationService {
	
	UserRegisterRequestDTO createUser(UserRegisterRequestDTO adRegisterRequestDTO, String plainPassword);

}
