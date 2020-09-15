package com.albraik.infra.user.service;

import java.util.List;

import com.albraik.infra.registration.model.UserEntity;

public interface UserDetailService {
	
	List<UserEntity> getUsers(Integer companyId, String role);

}
