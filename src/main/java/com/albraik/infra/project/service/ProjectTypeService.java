package com.albraik.infra.project.service;

import java.util.List;

import com.albraik.infra.project.dto.ProjectDto;
import com.albraik.infra.project.model.ProjectTypeEntity;

public interface ProjectTypeService {
	
	List<ProjectTypeEntity> getAllProjectType();

	ProjectDto addProjectTask(ProjectDto projectDto);
	
}
