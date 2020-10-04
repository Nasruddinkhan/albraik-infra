package com.albraik.infra.project.service;

import java.util.List;

import com.albraik.infra.project.dto.ProjectCaseDto;
import com.albraik.infra.project.dto.ProjectCompanyEstiblishmentDto;
import com.albraik.infra.project.dto.ProjectDeedCase;
import com.albraik.infra.project.dto.ProjectDto;
import com.albraik.infra.project.dto.ProjectInheritanceDto;
import com.albraik.infra.project.dto.ProjectVerdictDto;
import com.albraik.infra.project.model.ProjectTypeEntity;

public interface ProjectTypeService {
	
	List<ProjectTypeEntity> getAllProjectType();
	ProjectDto addProjectTask(ProjectDto projectDto);
	ProjectCaseDto addProjectTask(ProjectCaseDto projectCaseDto);
	ProjectCompanyEstiblishmentDto addEstiblishmentCompanyCase(ProjectCompanyEstiblishmentDto companyEstiblishmentDto);
	ProjectDeedCase addDeedCase(ProjectDeedCase projectDeedCase);
	ProjectInheritanceDto addInheritanceCase(ProjectInheritanceDto inheritanceDto);
	ProjectVerdictDto addVerditCase(ProjectVerdictDto projectVerdictDto);
	
}
