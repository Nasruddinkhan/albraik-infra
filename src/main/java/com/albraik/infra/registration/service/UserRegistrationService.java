package com.albraik.infra.registration.service;

import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;

public interface UserRegistrationService {
	
	UserRegisterRequestDTO createUser(UserRegisterRequestDTO adRegisterRequestDTO, String plainPassword);
	LoginResponseDTO getUserDetails(Integer userId);
	LoginResponseDTO updateUser(LoginResponseDTO logResponseDTO);
	UserRegisterRequestDTO updateUser(UserRegisterRequestDTO userRegistrationRequestDTO);
	LoginResponseDTO deleteUser(Integer userId);

}
