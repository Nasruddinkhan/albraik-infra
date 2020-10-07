package com.albraik.infra.user.service;

import java.util.List;

import com.albraik.infra.user.dto.UserDTO;

public interface UserDetailService {
	
	List<UserDTO> getUsers(Integer companyId, String role);


	List<UserDTO> getUserJobtitle(Integer companyId, String name, String roleUser);


}
