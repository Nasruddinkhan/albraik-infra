package com.albraik.infra.department.service;

import static com.albraik.infra.util.ObjectUtilMapper.map;
import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.department.dto.DepartmentDTO;
import com.albraik.infra.department.dto.DepartmentReqDTO;
import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.department.model.DepartmentEntity;
import com.albraik.infra.department.repository.DepartmentRepo;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.registration.model.UserEntity;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo departmentRepo;

	@Autowired
	public DepartmentServiceImpl(final DepartmentRepo departmentRepo) {
		super();
		this.departmentRepo = departmentRepo;
	}

	@Override
	public List<DepartmentResDTO> createDepartment(DepartmentDTO departmentNames) {
		// TODO Auto-generated method stub
		List<DepartmentEntity> depEntities = departmentRepo.saveAll(
				departmentNames.getName().stream().map((Function<? super String, ? extends DepartmentEntity>) obj -> {
					DepartmentEntity dept = new DepartmentEntity();
					dept.setCompanyId(departmentNames.getCompanyId());
					dept.setCreatedBy(departmentNames.getCreatedBy());
					dept.setCreatedTime(departmentNames.getCreatedTime());
					dept.setUpdatedTime(departmentNames.getUpdatedTime());
					dept.setIsActive(true);
					dept.setIsDeleted(false);
					dept.setName(obj);
					return dept;
				}).collect(Collectors.toList()));
		if (depEntities.isEmpty())
			throw new RuntimeException("Internal server error");
		return mapAll(depEntities, DepartmentResDTO.class);
	}

	@Override
	public List<DepartmentResDTO> findAll(Integer userId) {
		// TODO Auto-generated method stub
		List<DepartmentEntity> departments = departmentRepo.findByCreatedByAndIsActiveTrueAndIsDeletedFalse(userId);
		if (departments.isEmpty())
			throw new ResourceNotFoundException("no department found");
		return mapAll(departments, DepartmentResDTO.class);
	}

	@Override
	public DepartmentResDTO checkDepartment(Integer userId, Integer companyId, String name) {
		// TODO Auto-generated method stub
		DepartmentEntity departmentEntity = departmentRepo.findByCreatedByAndCompanyIdAndNameAndIsActiveTrueAndIsDeletedFalse(userId, companyId, name );
		if(departmentEntity!=null)
			throw new RuntimeException(name +" already is present");
		return map(departmentEntity, DepartmentResDTO.class);
	}
	
	@Override
	public DepartmentResDTO updateDepartment(Integer departmentId, DepartmentReqDTO departmentReqDTO, UserEntity userEntity) {
		DepartmentEntity departmentEntity = departmentRepo.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
		Integer createdBy = departmentEntity.getCreatedBy();
		if(createdBy != userEntity.getId())
			throw new UnauthorizedAccessException("you don't have access to modify the department");
		departmentEntity.setName(departmentReqDTO.getName());
		departmentEntity.setUpdatedTime(System.currentTimeMillis());
		departmentRepo.save(departmentEntity);
		return map(departmentEntity, DepartmentResDTO.class);
	}
	
	@Override
	public List<DepartmentResDTO> deleteDepartment(List<Integer> departmentIds, UserEntity userEntity) {
		List<DepartmentEntity> departmentList = departmentRepo.findAllById(departmentIds);
		if(departmentList.isEmpty())
			throw new ResourceNotFoundException("No department found");
		departmentList.forEach(department -> {
			if(userEntity.getId() != department.getCreatedBy())
				throw new UnauthorizedAccessException("You don't have access to delete the department");
			department.setIsDeleted(true);
			department.setIsActive(false);
			department.setUpdatedTime(System.currentTimeMillis());
		});
		return mapAll(departmentRepo.saveAll(departmentList), DepartmentResDTO.class);
	}
	

	@Override
	public List<DepartmentResDTO> findByCompanyId(Integer companyID) {
		// TODO Auto-generated method stub
		List<DepartmentEntity> depEntities = departmentRepo.findByCompanyId(companyID);
		if (depEntities.isEmpty())
			throw new RuntimeException("Internal server error");
		return mapAll(depEntities, DepartmentResDTO.class);
	}
}
