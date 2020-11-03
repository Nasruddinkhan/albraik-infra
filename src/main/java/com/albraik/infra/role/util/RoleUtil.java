package com.albraik.infra.role.util;

import java.util.ArrayList;
import java.util.List;

import com.albraik.infra.privilege.model.PrivilegeEntity;
import com.albraik.infra.role.dto.RolePrivilegeDTO;
import com.albraik.infra.role.model.RoleEntity;
import com.albraik.infra.role.model.RolePrivilegeEntity;

public class RoleUtil {

	public static List<RolePrivilegeDTO> getRolePrivilegeListByRoleList(List<RoleEntity> roleList)
	{
		List<RolePrivilegeDTO> rolePrivilegeList = new ArrayList<>();
		if(roleList == null || roleList.isEmpty())
			return rolePrivilegeList;
		for(RoleEntity roleEntity: roleList)
		{
			RolePrivilegeDTO rolePrivilegeDTO = getRolePrivilegeByRole(roleEntity);
			if(rolePrivilegeDTO == null)
				continue;
			rolePrivilegeList.add(rolePrivilegeDTO);
		}
		return rolePrivilegeList;
	}
	
	public static RolePrivilegeDTO getRolePrivilegeByRole(RoleEntity roleEntity)
	{
		RolePrivilegeDTO rolePrivilegeDTO = null;
		if(roleEntity == null)
			return rolePrivilegeDTO;
		rolePrivilegeDTO = new RolePrivilegeDTO();
		rolePrivilegeDTO.setId(roleEntity.getId());
		rolePrivilegeDTO.setName(roleEntity.getName());
		rolePrivilegeDTO.setCompanyId(roleEntity.getCompanyId());
		rolePrivilegeDTO.setCreatedBy(roleEntity.getCreatedBy());
		rolePrivilegeDTO.setCreatedTime(roleEntity.getCreatedTime());
		rolePrivilegeDTO.setUpdatedTime(roleEntity.getUpdatedTime());
		List<PrivilegeEntity> privilegeList = getPrivilegeListByRolePrivilegeList(roleEntity.getRolePrivilegeList());
		rolePrivilegeDTO.setPrivilegeList(privilegeList);
		return rolePrivilegeDTO;
	}
	
	public static List<PrivilegeEntity> getPrivilegeListByRolePrivilegeList(List<RolePrivilegeEntity> rolePrivilegeList)
	{
		List<PrivilegeEntity> privilegeList = new ArrayList<>();
		if (rolePrivilegeList == null || rolePrivilegeList.isEmpty())
			return privilegeList;
		rolePrivilegeList.forEach(rolePrivilege -> {
			//add only if active
			if(!rolePrivilege.getIsDeleted())
				privilegeList.add(rolePrivilege.getPrivilege());
		});
		return privilegeList;
	}

}
