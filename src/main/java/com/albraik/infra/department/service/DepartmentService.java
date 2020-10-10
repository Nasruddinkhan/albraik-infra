package com.albraik.infra.department.service;

import java.util.List;

import com.albraik.infra.department.dto.DepartmentDTO;
import com.albraik.infra.department.dto.DepartmentResDTO;

public interface DepartmentService {

	List<DepartmentResDTO> createDepartment(DepartmentDTO departmentNames);

	List<DepartmentResDTO> findAll(Integer userId);


	DepartmentResDTO checkDepartment(Integer userId, Integer companyId, String name);

}
