package com.albraik.infra.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.albraik.infra.mail.service.MailSenderService;
import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.service.AdminRegistrationService;

@RestController
@RequestMapping("/register")
public class AdminRegistrationController {

	private AdminRegistrationService adminRegService;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	public AdminRegistrationController(final AdminRegistrationService adminRegService) {
		super();
		this.adminRegService = adminRegService;
	}

	@PostMapping("/admin")
	public ResponseEntity<Object> addAdmin(@RequestBody  AdminRegisterRequestDTO adRegisterRequestDTO) {
		System.out.println(adRegisterRequestDTO);
		String password = adRegisterRequestDTO.getPassword();
		adRegisterRequestDTO = adminRegService.save(adRegisterRequestDTO);
		//send email
		mailSenderService.sendAdminRegisterMail(adRegisterRequestDTO, password);
		return ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequest().path("/{emailId}")
				.buildAndExpand(adRegisterRequestDTO.getEmail()).toUri()).build();
	}
}
