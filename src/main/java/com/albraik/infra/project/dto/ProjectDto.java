package com.albraik.infra.project.dto;

import java.sql.Date;

public final class ProjectDto {

	private Integer projectId;
	private String projectTypeId;
	private String name;
	private Date startDate;
	private String priority;
	private String drawerNumber;
	private String objective;
	private String comment;
	private Boolean hiddinProject;
	private Integer managerId;
	private Long createdTime;
	private Long updatedTime;
	private Integer createdBy;
	private Boolean isActive;
	private String caseLogo;
	private Integer companyId;
	public ProjectDto() {
		super();
		this.createdTime = System.currentTimeMillis();
		this.updatedTime = System.currentTimeMillis();
		this.isActive = true;
	}

	public ProjectDto(Integer projectId, String projectTypeId, String name, Date startDate, String priority,
			String drawerNumber, String objective, String comment, Boolean hiddinProject, Integer managerId, Integer companyId) {
		super();
		this.projectId = projectId;
		this.projectTypeId = projectTypeId;
		this.name = name;
		this.startDate = startDate;
		this.priority = priority;
		this.drawerNumber = drawerNumber;
		this.objective = objective;
		this.comment = comment;
		this.hiddinProject = hiddinProject;
		this.managerId = managerId;
		this.createdTime = System.currentTimeMillis();
		this.updatedTime = System.currentTimeMillis();
		this.isActive = true;
		this.companyId = companyId;
	}
	
	public String getCaseLogo() {
		return caseLogo;
	}

	public void setCaseLogo(String caseLogo) {
		this.caseLogo = caseLogo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDrawerNumber() {
		return drawerNumber;
	}

	public void setDrawerNumber(String drawerNumber) {
		this.drawerNumber = drawerNumber;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getHiddinProject() {
		return hiddinProject;
	}

	public void setHiddinProject(Boolean hiddinProject) {
		this.hiddinProject = hiddinProject;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public Long getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "ProjectDto [projectId=" + projectId + ", projectTypeId=" + projectTypeId + ", name=" + name
				+ ", startDate=" + startDate + ", priority=" + priority + ", drawerNumber=" + drawerNumber
				+ ", objective=" + objective + ", comment=" + comment + ", hiddinProject=" + hiddinProject
				+ ", managerId=" + managerId + "]";
	}

}
