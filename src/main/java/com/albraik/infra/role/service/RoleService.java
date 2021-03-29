package com.albraik.infra.role.service;

import java.util.List;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RolePrivilegeDTO;
import com.albraik.infra.role.dto.RolePrivilegeIdDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.model.RoleEntity;

public interface RoleService {

	List<RolePrivilegeDTO> findAll(Integer userId);

	List<RoleResDTO> createRole(RoleDTO roleDto);

	List<RolePrivilegeDTO> findByCompanyID(Integer companyId);

	RolePrivilegeDTO createRoleWithPrivilege(UserEntity userEntity, RolePrivilegeIdDTO rolePrivilegeIdDTO);

	RolePrivilegeDTO updateRoleWithPrivilege(UserEntity userEntity, Integer roleId, RolePrivilegeIdDTO rolePrivilegeIdDTO);
	
	RolePrivilegeDTO getRoleWithPrivilegeByRoleId(Integer roleId);
	
}
