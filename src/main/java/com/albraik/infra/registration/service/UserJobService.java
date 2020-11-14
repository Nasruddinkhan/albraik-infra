package com.albraik.infra.registration.service;

import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;
import com.albraik.infra.registration.model.UserJobEntity;

public interface UserJobService {
	
	UserJobEntity getUserJobByUserId(Integer userId);

}
