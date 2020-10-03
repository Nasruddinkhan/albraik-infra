package com.albraik.infra.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.project.model.ProjectTypeEntity;
import com.albraik.infra.project.service.ProjectTypeService;

@RestController
@RequestMapping("/api")
public class ProjectTypeController {

	@Autowired
	private ProjectTypeService projectTypeService;


	@GetMapping("/project/type")
	public ResponseEntity<List<ProjectTypeEntity>> getAllProjectTypes() {
		List<ProjectTypeEntity> projectTypes = projectTypeService.getAllProjectType();
		if (projectTypes.isEmpty())
			throw new RuntimeException("No content found");
		return ResponseEntity.ok(projectTypes);
	}

}
