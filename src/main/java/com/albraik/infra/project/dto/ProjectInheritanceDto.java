package com.albraik.infra.project.dto;

public class ProjectInheritanceDto {
	private Integer projectDetailsId;
	private ProjectDto project;
	private Integer inheritanceOwnerId;
	
	public ProjectInheritanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectInheritanceDto(Integer projectDetailsId, ProjectDto project, Integer inheritanceOwnerId) {
		super();
		this.projectDetailsId = projectDetailsId;
		this.project = project;
		this.inheritanceOwnerId = inheritanceOwnerId;
	}
	public Integer getProjectDetailsId() {
		return projectDetailsId;
	}
	public void setProjectDetailsId(Integer projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}
	public ProjectDto getProject() {
		return project;
	}
	public void setProject(ProjectDto project) {
		this.project = project;
	}
	public Integer getInheritanceOwnerId() {
		return inheritanceOwnerId;
	}
	public void setInheritanceOwnerId(Integer inheritanceOwnerId) {
		this.inheritanceOwnerId = inheritanceOwnerId;
	}
	
}
