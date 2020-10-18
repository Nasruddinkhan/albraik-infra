package com.albraik.infra.role.service;

import java.util.List;

import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RoleResDTO;

public interface RoleService {

	List<RoleResDTO> findAll(Integer userId);
	List<RoleResDTO> createRole(RoleDTO roleDto);
	List<RoleResDTO> findByCompanyID(Integer companyId);
}
