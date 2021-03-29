package com.albraik.infra.user.service;

import java.util.List;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.user.dto.UserDTO;
import com.albraik.infra.user.dto.UserJobDTO;

public interface UserDetailService {


	List<UserJobDTO> getUserDetails(Integer companyId, String role);

	List<UserDTO> getUserJobtitle(Integer companyId, String name, String roleUser);
	
	UserJobDTO getUserJobFromUserEntity(UserEntity userEntity);

}
