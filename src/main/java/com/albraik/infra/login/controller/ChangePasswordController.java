package com.albraik.infra.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.albraik.infra.registration.dto.ChangePasswordRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordResponseDTO;
import com.albraik.infra.registration.dto.MasterResponseDTO;
import com.albraik.infra.registration.service.AWSS3Service;
import com.albraik.infra.registration.service.AdminRegistrationService;

@RestController
@RequestMapping("/api")
public class ChangePasswordController {

	@Value("${aws.s3.bucket}")
	private String bucketName;

	@Value("${aws.s3.endpointUrl}")
	private String endPointURL;

	private AdminRegistrationService adminRegService;
	private AWSS3Service awsS3service;

	@Autowired
	public ChangePasswordController(final AdminRegistrationService adminRegService, final AWSS3Service awsS3service) {
		super();
		this.adminRegService = adminRegService;
		this.awsS3service = awsS3service;
	}

	@PostMapping("/changepassword")
	public ResponseEntity<ChangePasswordResponseDTO> changePassword(
			@RequestBody ChangePasswordRequestDTO passwordRequestDTO) {
		System.out.println("ChangePasswordController.changePassword()" + passwordRequestDTO);
		return new ResponseEntity<ChangePasswordResponseDTO>(adminRegService.changePassword(passwordRequestDTO),
				HttpStatus.OK);
	}

	@GetMapping("/master/{userrole}/role")
	public ResponseEntity<List<MasterResponseDTO>> getMasterPageData(@PathVariable("userrole") String role) {
		return new ResponseEntity<List<MasterResponseDTO>>(adminRegService.getMasterPageData(role), HttpStatus.OK);
	}

	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
		return new ResponseEntity<String>(awsS3service.uploadFile(file, bucketName, endPointURL), HttpStatus.OK);
	}

}
