package com.albraik.infra.role.service;

import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.department.model.DepartmentEntity;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.model.RoleEntity;
import com.albraik.infra.role.repository.RoleRepo;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	private RoleRepo roleRepo;
	
	public RoleServiceImpl(final RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}

	@Override
	public List<RoleResDTO> createRole(RoleDTO roleDto) {
		List<RoleEntity> roleEntities = roleRepo.saveAll(
				roleDto.getName().stream().map((Function<? super String, ? extends RoleEntity>) obj -> {
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
	public List<RoleResDTO> findAll(Integer userId) {
		List<RoleEntity> roles = roleRepo.findByCreatedBy(userId);
		if (roles.isEmpty())
			throw new ResourceNotFoundException("no department found");
		return mapAll(roles, RoleResDTO.class);
	}
}
