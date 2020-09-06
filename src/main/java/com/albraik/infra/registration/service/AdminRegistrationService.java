package com.albraik.infra.registration.service;

import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordResponseDTO;

public interface AdminRegistrationService {
	AdminRegisterRequestDTO save(AdminRegisterRequestDTO adRegisterRequestDTO);
	ChangePasswordResponseDTO changePassword(ChangePasswordRequestDTO passwordRequestDTO);

}
