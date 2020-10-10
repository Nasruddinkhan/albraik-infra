package com.albraik.infra.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.department.dto.DepartmentDTO;
import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.department.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(final DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/save/departments")
	public ResponseEntity<List<DepartmentResDTO>> createDepartment(@RequestBody DepartmentDTO departmentNames) {
		return new ResponseEntity<List<DepartmentResDTO>>(departmentService.createDepartment(departmentNames),
				HttpStatus.CREATED);
	}

	@GetMapping("/get/{userId}/departments")
	public ResponseEntity<List<DepartmentResDTO>> findAll(@PathVariable Integer userId) {
		return new ResponseEntity<List<DepartmentResDTO>>(departmentService.findAll(userId), HttpStatus.OK);
	}
	
	@GetMapping("/get/{userId}/{companyId}/{name}/name")
	public ResponseEntity<DepartmentResDTO> checkDepartment(@PathVariable Integer userId,
			@PathVariable String name,
			@PathVariable Integer companyId) {
		return new ResponseEntity<DepartmentResDTO>(departmentService.checkDepartment(userId, companyId, name ), HttpStatus.OK);
	}
}
