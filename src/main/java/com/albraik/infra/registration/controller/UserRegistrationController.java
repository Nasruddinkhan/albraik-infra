package com.albraik.infra.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.albraik.infra.mail.service.MailSenderService;
import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;
import com.albraik.infra.registration.service.UserRegistrationService;
import com.albraik.infra.util.CommonUtils;

@RestController
@RequestMapping("/api")
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
		System.out.println(userRegistrationRequestDTO);
		String password = CommonUtils.generateRandomUserPassword();
		userRegistrationRequestDTO = userRegistrationService.createUser(userRegistrationRequestDTO, password);
		//send email
		mailSenderService.sendUserRegisterMail(userRegistrationRequestDTO, password);
		return ResponseEntity.created( ServletUriComponentsBuilder.fromCurrentRequest().path("/{emailId}")
				.buildAndExpand(userRegistrationRequestDTO.getEmail()).toUri()).build();
	}
	@GetMapping("/user/{userId}/profile")
	public ResponseEntity<LoginResponseDTO> getUserDetails(@PathVariable Integer userId){
		return new ResponseEntity<LoginResponseDTO>(userRegistrationService.getUserDetails(userId), HttpStatus.OK);
		
	}
	
	@PostMapping("/profile")
	public ResponseEntity<LoginResponseDTO> updateUser(@RequestBody  LoginResponseDTO logResponseDTO) {
		System.out.println(logResponseDTO);
		return new ResponseEntity<LoginResponseDTO>(userRegistrationService.updateUser(logResponseDTO), HttpStatus.OK);
	}
}
