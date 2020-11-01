package com.albraik.infra.role.service;

import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.exception.BadRequestException;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.privilege.model.PrivilegeEntity;
import com.albraik.infra.privilege.repository.PrivilegeRepo;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RolePrivilegeDTO;
import com.albraik.infra.role.dto.RolePrivilegeIdDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.model.RoleEntity;
import com.albraik.infra.role.model.RolePrivilegeEntity;
import com.albraik.infra.role.repository.RolePrivilegeRepo;
import com.albraik.infra.role.repository.RoleRepo;
import com.albraik.infra.util.ObjectUtilMapper;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private PrivilegeRepo privilegeRepo;

	@Autowired
	private RolePrivilegeRepo rolePrivilegeRepo;

	@Override
	public List<RoleResDTO> createRole(RoleDTO roleDto) {
		List<RoleEntity> roleEntities = roleRepo
				.saveAll(roleDto.getName().stream().map((Function<? super String, ? extends RoleEntity>) obj -> {
					RoleEntity role = new RoleEntity();
					role.setCompanyId(roleDto.getCompanyId());
					role.setCreatedBy(roleDto.getCreatedBy());
					role.setCreatedTime(roleDto.getCreatedTime());
					role.setUpdatedTime(roleDto.getUpdatedTime());
					role.setName(obj);
					return role;
				}).collect(Collectors.toList()));
		if (roleEntities.isEmpty())
			throw new RuntimeException("Internal server error");
		return mapAll(roleEntities, RoleResDTO.class);
	}

	@Override
	public RolePrivilegeDTO createRoleWithPrivilege(UserEntity userEntity, RolePrivilegeIdDTO rolePrivilegeIdDTO) {
		if (rolePrivilegeIdDTO.getName() == null || "".equals(rolePrivilegeIdDTO.getName().trim())) {
			throw new BadRequestException("Role name cannot be blank");
		}
		if (rolePrivilegeIdDTO.getPrivilegeIdList().isEmpty()) {
			throw new BadRequestException("At least one privilege is required");
		}
		List<PrivilegeEntity> privilegeList = privilegeRepo.findAllById(rolePrivilegeIdDTO.getPrivilegeIdList());
		if (privilegeList.isEmpty()) {
			throw new BadRequestException("Invalid privilege id");
		}
		// save role details
		long currentTime = System.currentTimeMillis();
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setCompanyId(userEntity.getCompanyId());
		roleEntity.setCreatedBy(userEntity.getId());
		roleEntity.setName(rolePrivilegeIdDTO.getName());
		roleEntity.setCreatedTime(currentTime);
		roleEntity.setUpdatedTime(currentTime);
		roleEntity = roleRepo.save(roleEntity);

		List<RolePrivilegeEntity> rolePrivilegeList = new ArrayList<>();
		RolePrivilegeEntity rolePrivilegeEntity = null;
		for (PrivilegeEntity privilegeEntity : privilegeList) {
			rolePrivilegeEntity = new RolePrivilegeEntity();
			rolePrivilegeEntity.setRoleId(roleEntity.getId());
			rolePrivilegeEntity.setPrivilegeId(privilegeEntity.getId());
			rolePrivilegeEntity.setCreatedTime(currentTime);
			rolePrivilegeEntity.setUpdatedTime(currentTime);
			rolePrivilegeEntity.setIsDeleted(false);
			rolePrivilegeList.add(rolePrivilegeEntity);
		}
		rolePrivilegeList = rolePrivilegeRepo.saveAll(rolePrivilegeList);
		RolePrivilegeDTO rolePrivilegeDTO = new RolePrivilegeDTO();
		ObjectUtilMapper.map(roleEntity, rolePrivilegeDTO);
		rolePrivilegeDTO.setPrivilegeList(privilegeList);

		return rolePrivilegeDTO;
	}

	@Override
	public RolePrivilegeDTO updateRoleWithPrivilege(UserEntity userEntity, Integer roleId,
			RolePrivilegeIdDTO rolePrivilegeIdDTO) {
		RoleEntity roleEntity = roleRepo.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
		if (!roleEntity.getCreatedBy().equals(userEntity.getId())) {
			throw new UnauthorizedAccessException("You don't have access to update this role");
		}
		if (rolePrivilegeIdDTO.getName() == null || "".equals(rolePrivilegeIdDTO.getName().trim())) {
			throw new BadRequestException("Role name cannot be blank");
		}
		if (rolePrivilegeIdDTO.getPrivilegeIdList().isEmpty()) {
			throw new BadRequestException("At least one privilege is required");
		}
		List<String> newPrivilegeIdList = rolePrivilegeIdDTO.getPrivilegeIdList();
		List<PrivilegeEntity> newPrivilegeList = privilegeRepo.findAllById(newPrivilegeIdList);
		if (newPrivilegeList.isEmpty()) {
			throw new BadRequestException("Invalid privilege id");
		}
		newPrivilegeIdList.clear();
		for (PrivilegeEntity privilegeEntity : newPrivilegeList) {
			newPrivilegeIdList.add(privilegeEntity.getId());
		}

		// update role details
		long currentTime = System.currentTimeMillis();
		roleEntity.setName(rolePrivilegeIdDTO.getName());
		roleEntity.setUpdatedTime(currentTime);
		roleEntity = roleRepo.save(roleEntity);

		// update existing role-privilege mapping
		List<RolePrivilegeEntity> newRolePrivilegeList = new ArrayList<>();
		List<RolePrivilegeEntity> currentRolePrivilegeList = rolePrivilegeRepo.findByRoleId(roleEntity.getId());
		List<String> currentPrivilegeIdList = new ArrayList<>();
		for (RolePrivilegeEntity rolePrivilegeEntity : currentRolePrivilegeList) {
			currentPrivilegeIdList.add(rolePrivilegeEntity.getPrivilegeId());
			if (newPrivilegeIdList.contains(rolePrivilegeEntity.getPrivilegeId())) {
				rolePrivilegeEntity.setIsDeleted(false);
			} else {
				rolePrivilegeEntity.setIsDeleted(true);
			}
			rolePrivilegeEntity.setUpdatedTime(currentTime);
			newRolePrivilegeList.add(rolePrivilegeEntity);
		}

		// remove existing role-privilege from new role-privilege list
		newPrivilegeIdList.removeAll(currentPrivilegeIdList);

		// create role-privilege for new mappings
		for (String privilegeId : newPrivilegeIdList) {
			RolePrivilegeEntity rolePrivilegeEntity = new RolePrivilegeEntity();
			rolePrivilegeEntity.setRoleId(roleEntity.getId());
			rolePrivilegeEntity.setPrivilegeId(privilegeId);
			rolePrivilegeEntity.setCreatedTime(currentTime);
			rolePrivilegeEntity.setUpdatedTime(currentTime);
			rolePrivilegeEntity.setIsDeleted(false);
			newRolePrivilegeList.add(rolePrivilegeEntity);
		}

		// save all role-privilege mappings
		newRolePrivilegeList = rolePrivilegeRepo.saveAll(newRolePrivilegeList);

		// create dto for response
		RolePrivilegeDTO rolePrivilegeDTO = new RolePrivilegeDTO();
		ObjectUtilMapper.map(roleEntity, rolePrivilegeDTO);
		rolePrivilegeDTO.setPrivilegeList(newPrivilegeList);

		return rolePrivilegeDTO;
	}

	@Override
	public List<RoleResDTO> findAll(Integer userId) {
		List<RoleEntity> roles = roleRepo.findByCreatedBy(userId);
		if (roles.isEmpty())
			throw new ResourceNotFoundException("no role found");
		return mapAll(roles, RoleResDTO.class);
	}

	@Override
	public List<RoleResDTO> findByCompanyID(Integer companyId) {
		// TODO Auto-generated method stub
		List<RoleEntity> roles = roleRepo.findByCompanyId(companyId);
		if (roles.isEmpty())
			throw new ResourceNotFoundException("no role found");
		return mapAll(roles, RoleResDTO.class);
	}
}
