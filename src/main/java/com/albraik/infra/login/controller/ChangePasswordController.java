package com.albraik.infra.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.registration.dto.ChangePasswordRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordResponseDTO;
import com.albraik.infra.registration.service.AdminRegistrationService;

@RestController
@RequestMapping("/api")
public class ChangePasswordController {
private AdminRegistrationService adminRegService;
	
	@Autowired
	public ChangePasswordController(final AdminRegistrationService adminRegService) {
		super();
		this.adminRegService = adminRegService;
	}
	@PostMapping("/changepassword")
	public ResponseEntity<ChangePasswordResponseDTO> changePassword(@RequestBody ChangePasswordRequestDTO passwordRequestDTO) {
		System.out.println("ChangePasswordController.changePassword()" + passwordRequestDTO);
		return new ResponseEntity<ChangePasswordResponseDTO>
		 							( adminRegService.changePassword(passwordRequestDTO), HttpStatus.OK) ;
	}
}
