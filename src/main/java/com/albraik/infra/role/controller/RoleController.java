package com.albraik.infra.role.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RolePrivilegeDTO;
import com.albraik.infra.role.dto.RolePrivilegeIdDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@PostMapping("/save/roles")
	public ResponseEntity<List<RoleResDTO>> createDepartment(@RequestBody RoleDTO roleDto) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.createRole(roleDto), HttpStatus.CREATED);
	}

	@GetMapping("/get/{userId}/roles")
	public ResponseEntity<List<RoleResDTO>> findAll(@PathVariable Integer userId) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.findAll(userId), HttpStatus.OK);
	}

	@GetMapping("/get/{companyId}/companyroles")
	public ResponseEntity<List<RoleResDTO>> findByCompanyID(@PathVariable Integer companyId) {
		return new ResponseEntity<List<RoleResDTO>>(roleService.findByCompanyID(companyId), HttpStatus.OK);
	}

	@PostMapping("/role")
	public ResponseEntity<RolePrivilegeDTO> createRole(@RequestBody RolePrivilegeIdDTO rolePrivilegeIdDTO,
			Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		RolePrivilegeDTO rolePrivilegeDTO = roleService.createRoleWithPrivilege(userEntity, rolePrivilegeIdDTO);
		return ResponseEntity.ok(rolePrivilegeDTO);
	}
	
	@PutMapping("/role/{roleId}")
	public ResponseEntity<RolePrivilegeDTO> updateRole(@RequestBody RolePrivilegeIdDTO rolePrivilegeIdDTO, @PathVariable Integer roleId, Principal principal)
	{
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		RolePrivilegeDTO rolePrivilegeDTO = roleService.updateRoleWithPrivilege(userEntity, roleId, rolePrivilegeIdDTO);
		return ResponseEntity.ok(rolePrivilegeDTO);
	}
}
