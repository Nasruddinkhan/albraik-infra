package com.albraik.infra.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.privilege.model.PrivilegeEntity;
import com.albraik.infra.privilege.service.PrivilegeService;

@RestController
@RequestMapping("/api/role/privilege")
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService;

	@GetMapping
	public ResponseEntity<List<PrivilegeEntity>> getAllPrivileges() {
		List<PrivilegeEntity> privileges = privilegeService.getAllPrivileges();
		if (privileges.isEmpty())
			return new ResponseEntity<>(privileges, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(privileges);
	}

}
