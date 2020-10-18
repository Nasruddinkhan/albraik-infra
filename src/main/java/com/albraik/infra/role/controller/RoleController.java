package com.albraik.infra.role.controller;

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
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	private RoleService roleService;

	@Autowired
	public RoleController(final RoleService roleService) {
		super();
		this.roleService = roleService;
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/save/roles")
	public ResponseEntity<List<RoleResDTO>> createDepartment(@RequestBody RoleDTO roleDto) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.createRole(roleDto),
				HttpStatus.CREATED);
	}
	@GetMapping("/get/{userId}/roles")
	public ResponseEntity<List<RoleResDTO>> findAll(@PathVariable Integer userId) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.findAll(userId), HttpStatus.OK);
	}
	
	@GetMapping("/get/{companyId}/companyroles")
	public ResponseEntity<List<RoleResDTO>> findByCompanyID(@PathVariable Integer companyId) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.findByCompanyID(companyId), HttpStatus.OK);
	}
}
