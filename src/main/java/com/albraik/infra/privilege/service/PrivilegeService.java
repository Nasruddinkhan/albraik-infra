package com.albraik.infra.privilege.service;

import java.util.List;

import com.albraik.infra.privilege.model.PrivilegeEntity;

public interface PrivilegeService {
	List<PrivilegeEntity> getAllPrivileges();
}
