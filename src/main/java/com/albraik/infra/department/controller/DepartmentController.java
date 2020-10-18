package com.albraik.infra.department.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.department.dto.DepartmentDTO;
import com.albraik.infra.department.dto.DepartmentReqDTO;
import com.albraik.infra.department.dto.DepartmentResDTO;
import com.albraik.infra.department.service.DepartmentService;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	private DepartmentService departmentService;
	
	@Autowired
	private UserService userService;

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

	@GetMapping("/get/{companyID}/depts")
	public ResponseEntity<List<DepartmentResDTO>> findByCompanyId(@PathVariable Integer companyID) {
		return new ResponseEntity<List<DepartmentResDTO>>(departmentService.findByCompanyId(companyID), HttpStatus.OK);
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
	
	@PutMapping("/department/{departmentId}")
	public ResponseEntity<DepartmentResDTO> updateDepartment(@PathVariable Integer departmentId, @RequestBody DepartmentReqDTO departmentReqDTO, Principal principal)
	{
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		DepartmentResDTO departmentResDTO = departmentService.updateDepartment(departmentId, departmentReqDTO, userEntity);
		return ResponseEntity.ok(departmentResDTO);
	}
	
	@DeleteMapping("/department")
	public ResponseEntity<List<DepartmentResDTO>> deleteMultipleDepartment(@RequestParam("id") List<Integer> departmentIdList, Principal principal)
	{
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<DepartmentResDTO> departmentList = departmentService.deleteDepartment(departmentIdList, userEntity);
		return ResponseEntity.ok(departmentList);
	}
}
