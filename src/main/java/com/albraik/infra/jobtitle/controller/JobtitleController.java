package com.albraik.infra.jobtitle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.jobtitle.service.JobTitleService;
@RestController
@RequestMapping("/api")
public class JobtitleController {


	private JobTitleService jobTitleService;

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

}
