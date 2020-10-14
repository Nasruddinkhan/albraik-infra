package com.albraik.infra.department.service;

import java.util.List;

import com.albraik.infra.department.dto.DepartmentDTO;
import com.albraik.infra.department.dto.DepartmentReqDTO;
import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.registration.model.UserEntity;

public interface DepartmentService {

	List<DepartmentResDTO> createDepartment(DepartmentDTO departmentNames);

	List<DepartmentResDTO> findAll(Integer userId);

	DepartmentResDTO checkDepartment(Integer userId, Integer companyId, String name);
	
	DepartmentResDTO updateDepartment(Integer departmentId, DepartmentReqDTO departmentReqDTO, UserEntity userEntity);
	
	List<DepartmentResDTO> deleteDepartment(List<Integer> departmentIds, UserEntity userEntity);

}
