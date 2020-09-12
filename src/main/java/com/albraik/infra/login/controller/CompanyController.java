package com.albraik.infra.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.albraik.infra.registration.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {
	private CompanyService comapnyService;

	@Autowired
	public CompanyController(CompanyService comapnyService) {
		super();
		this.comapnyService = comapnyService;
	}

	@PostMapping("/create/upload/comapnay")
	public ResponseEntity<Object> createCompany(@RequestParam("file") MultipartFile  file) {
		System.out.println(file);
		return null;
	}
}
