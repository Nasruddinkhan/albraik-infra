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
		List<PrivilegeEntity> privilegeList = privilegeRepo.findAllById(rolePrivilegeIdDTO.getPrivilegeIdList());
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
