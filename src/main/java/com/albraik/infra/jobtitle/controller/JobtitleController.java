package com.albraik.infra.jobtitle.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.jobtitle.dto.JobTitleDTO;
import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.jobtitle.service.JobTitleService;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;

@RestController
@RequestMapping("/api")
public class JobtitleController {

	private JobTitleService jobTitleService;

	
	@Autowired
	private UserService userService;

	@Autowired
	public JobtitleController(final JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/save/jobtitles")
	public ResponseEntity<List<JobTitleResDTO>> createJobTitle(@RequestBody JobTitleReqDTO jobTitleReqDTO) {
		return new ResponseEntity<List<JobTitleResDTO>>(jobTitleService.createJobTitle(jobTitleReqDTO),
				HttpStatus.CREATED);
	}

	@GetMapping("/get/{userId}/jobtitles")
	public ResponseEntity<List<JobTitleResDTO>> findAll(@PathVariable Integer userId) {
		return new ResponseEntity<List<JobTitleResDTO>>(jobTitleService.findAll(userId), HttpStatus.OK);
	}

	@PutMapping("/jobtitle/{jobTitleId}")
	public ResponseEntity<JobTitleResDTO> updateJobTitle(@PathVariable Integer jobTitleId,
			@RequestBody JobTitleDTO jobTitleDTO, Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		JobTitleResDTO jobTitleResDTO = jobTitleService.updateJobTitle(jobTitleId, jobTitleDTO, userEntity);
		return ResponseEntity.ok(jobTitleResDTO);
	}

	@DeleteMapping("/jobtitle")
	public ResponseEntity<List<JobTitleResDTO>> deleteMultipleJobTitle(@RequestParam("id") List<Integer> jobTitleIdList,
			Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<JobTitleResDTO> jobTitleResDtoList = jobTitleService.deleteJobTitle(jobTitleIdList, userEntity);
		return ResponseEntity.ok(jobTitleResDtoList);
	}
	@GetMapping("/get/{companyID}/jobtitle")
	public ResponseEntity<List<JobTitleResDTO>> findAllJobtitle(@PathVariable Integer companyID) {
		return new ResponseEntity<List<JobTitleResDTO>>(jobTitleService.findAllJobtitle(companyID), HttpStatus.OK);
	}
}
