package com.albraik.infra.registration.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.albraik.infra.mail.service.MailSenderService;
import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;
import com.albraik.infra.registration.service.AdminRegistrationService;
import com.albraik.infra.registration.service.UserRegistrationService;

@RestController
@RequestMapping("/register")
public class UserRegistrationController {

	private UserRegistrationService userRegistrationService;

	@Autowired
	private MailSenderService mailSenderService;

	@Autowired
	public UserRegistrationController(final UserRegistrationService userRegistrationService) {
		super();
		this.userRegistrationService = userRegistrationService;
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserRegisterRequestDTO> createUser(@RequestBody  UserRegisterRequestDTO userRegistrationRequestDTO) {
		String password = UUID.randomUUID().toString();
		userRegistrationRequestDTO = userRegistrationService.createUser(userRegistrationRequestDTO, password);
		//send email
		mailSenderService.sendUserRegisterMail(userRegistrationRequestDTO, password);
		return ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequest().path("/{emailId}")
				.buildAndExpand(userRegistrationRequestDTO.getEmail()).toUri()).build();
	}
}
