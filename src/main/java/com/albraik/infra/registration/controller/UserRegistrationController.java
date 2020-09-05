package com.albraik.infra.registration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

	@GetMapping("/register")
	public String sayHello() {
		return "jwt token required";
	}
}
