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
import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.department.model.DepartmentEntity;
import com.albraik.infra.department.repository.DepartmentRepo;
import com.albraik.infra.exception.ResourceNotFoundException;

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
	
	
}
