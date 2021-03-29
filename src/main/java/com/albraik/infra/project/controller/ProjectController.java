package com.albraik.infra.project.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.project.dto.ProjectCaseDto;
import com.albraik.infra.project.dto.ProjectCompanyEstiblishmentDto;
import com.albraik.infra.project.dto.ProjectDeedCase;
import com.albraik.infra.project.dto.ProjectDto;
import com.albraik.infra.project.dto.ProjectInheritanceDto;
import com.albraik.infra.project.dto.ProjectVerdictDto;
import com.albraik.infra.project.model.ProjectEntity;
import com.albraik.infra.project.repository.ProjectRepo;
import com.albraik.infra.project.service.ProjectTypeService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	private ProjectTypeService projectService;
	private ProjectRepo projectRepo;

	public ProjectController(final ProjectTypeService projectService, final ProjectRepo projectRepo) {
		super();
		this.projectService = projectService;
		this.projectRepo = projectRepo;
	}

	@PostMapping("/create/task")
	public ResponseEntity<ProjectDto> addProjectTask(@RequestBody ProjectDto projectDto) {
		System.out.println(projectDto);
		return new ResponseEntity<ProjectDto>(projectService.addProjectTask(projectDto), HttpStatus.CREATED);
	}

	@GetMapping("task/{userId}/{pageNo}/allrecord")
	public Page<ProjectEntity> findAllTask(@PathVariable Integer userId, @PathVariable Integer pageNo) {
		Pageable firstPageWithTwoElements = PageRequest.of(pageNo - 1, 10, Sort.by("projectId").descending());
		return projectRepo.findBycreatedByAndIsActiveTrue(userId, firstPageWithTwoElements);
	}

	@PostMapping("/create/case")
	public ResponseEntity<ProjectCaseDto> addProjectCase(@RequestBody ProjectCaseDto projectCaseDto) {
		System.out.println(projectCaseDto);
		return new ResponseEntity<ProjectCaseDto>(projectService.addProjectTask(projectCaseDto), HttpStatus.CREATED);
	}

	@PostMapping("/create/estiblismentcase")
	public ResponseEntity<ProjectCompanyEstiblishmentDto> addEstiblishmentCompanyCase(
			@RequestBody ProjectCompanyEstiblishmentDto companyEstiblishmentDto) {
		return new ResponseEntity<ProjectCompanyEstiblishmentDto>(
				projectService.addEstiblishmentCompanyCase(companyEstiblishmentDto), HttpStatus.CREATED);
	}

	@PostMapping("/create/deedcase")
	public ResponseEntity<ProjectDeedCase> addDeedCase(
			@RequestBody ProjectDeedCase projectDeedCase) {
		return new ResponseEntity<ProjectDeedCase>(
				projectService.addDeedCase(projectDeedCase), HttpStatus.CREATED);
	}
	@PostMapping("/create/inheritcase")
	public ResponseEntity<ProjectInheritanceDto> addInheritanceCase(
			@RequestBody ProjectInheritanceDto inheritanceDto) {
		return new ResponseEntity<ProjectInheritanceDto>(
				projectService.addInheritanceCase(inheritanceDto), HttpStatus.CREATED);
	}
	@PostMapping("/create/verditcase")
	public ResponseEntity<ProjectVerdictDto> addVerditCase(
			@RequestBody ProjectVerdictDto projectVerdictDto) {
		return new ResponseEntity<ProjectVerdictDto>(
				projectService.addVerditCase(projectVerdictDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{projectType}/{companyId}/allcases")
	public ResponseEntity<List<ProjectDto>> getAllCase(@PathVariable Integer companyId, 
			@PathVariable String projectType ) {
		return new ResponseEntity<List<ProjectDto>>(
				projectService.getAllCase(projectType, companyId), HttpStatus.OK);
	}
}
