package com.albraik.infra.project.dto;

public final class ProjectCompanyEstiblishmentDto {

	private Integer projectDetailsId;
	private ProjectDto project;
	public String companyName;
	
	public ProjectCompanyEstiblishmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectCompanyEstiblishmentDto(Integer projectDetailsId, ProjectDto project, String companyName) {
		super();
		this.projectDetailsId = projectDetailsId;
		this.project = project;
		this.companyName = companyName;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "ProjectCompanyEstiblishmentDto [projectDetailsId=" + projectDetailsId + ", project=" + project
				+ ", companyName=" + companyName + "]";
	}

}
