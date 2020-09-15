package com.albraik.infra.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.albraik.infra.company.dto.CompanyRequestDTO;
import com.albraik.infra.company.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {
	private CompanyService comapnyService;

	@Autowired
	public CompanyController(CompanyService comapnyService) {
		super();
		this.comapnyService = comapnyService;
	}

	@PostMapping("/create/upload/{userID}/comapnay")
	public ResponseEntity<CompanyRequestDTO> createCompany(@RequestParam("file") MultipartFile file,
			@RequestParam("phoneNumber") String phoneNo, @RequestParam("faxNumber") String faxNumber,
			@RequestParam("address") String address, @RequestParam("name") String name, @PathVariable Integer userID) {
		return new ResponseEntity<CompanyRequestDTO>(
				comapnyService.createCompany(new CompanyRequestDTO(file, phoneNo, faxNumber, address, userID, name)),
				HttpStatus.OK);
	}
	
	@GetMapping("/get/{companyID}/comapnay")
	public ResponseEntity<CompanyRequestDTO> findByCompany(@PathVariable  Integer companyID ) {
		return new ResponseEntity<CompanyRequestDTO>(
				comapnyService.findByCompany(companyID),
				HttpStatus.OK);
	}
}
