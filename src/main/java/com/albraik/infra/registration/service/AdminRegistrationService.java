package com.albraik.infra.registration.service;

import java.util.List;

import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordResponseDTO;
import com.albraik.infra.registration.dto.MasterResponseDTO;

public interface AdminRegistrationService {
	AdminRegisterRequestDTO save(AdminRegisterRequestDTO adRegisterRequestDTO);
	ChangePasswordResponseDTO changePassword(ChangePasswordRequestDTO passwordRequestDTO);
	List<MasterResponseDTO> getMasterPageData(String role);

}
