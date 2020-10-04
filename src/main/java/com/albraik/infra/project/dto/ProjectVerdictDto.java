package com.albraik.infra.project.dto;

import java.sql.Date;

public final class ProjectVerdictDto {
	private Integer verdictExecutedCaseId;
	private String verdictNumber;
	private Date verdictDate;
	private String verdictSource;
	private String verdictType;
	private Date verdictDecisionDate;
	private Integer projectDetailsId;
	private ProjectDto project;
	
	public ProjectVerdictDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectVerdictDto(Integer verdictExecutedCaseId, String verdictNumber, Date verdictDate,
			String verdictSource, String verdictType, Date verdictDecisionDate, Integer projectDetailsId,
			ProjectDto project) {
		super();
		this.verdictExecutedCaseId = verdictExecutedCaseId;
		this.verdictNumber = verdictNumber;
		this.verdictDate = verdictDate;
		this.verdictSource = verdictSource;
		this.verdictType = verdictType;
		this.verdictDecisionDate = verdictDecisionDate;
		this.projectDetailsId = projectDetailsId;
		this.project = project;
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
	public Integer getVerdictExecutedCaseId() {
		return verdictExecutedCaseId;
	}
	public void setVerdictExecutedCaseId(Integer verdictExecutedCaseId) {
		this.verdictExecutedCaseId = verdictExecutedCaseId;
	}
	public String getVerdictNumber() {
		return verdictNumber;
	}
	public void setVerdictNumber(String verdictNumber) {
		this.verdictNumber = verdictNumber;
	}
	public Date getVerdictDate() {
		return verdictDate;
	}
	public void setVerdictDate(Date verdictDate) {
		this.verdictDate = verdictDate;
	}
	public String getVerdictSource() {
		return verdictSource;
	}
	public void setVerdictSource(String verdictSource) {
		this.verdictSource = verdictSource;
	}
	public String getVerdictType() {
		return verdictType;
	}
	public void setVerdictType(String verdictType) {
		this.verdictType = verdictType;
	}
	public Date getVerdictDecisionDate() {
		return verdictDecisionDate;
	}
	public void setVerdictDecisionDate(Date verdictDecisionDate) {
		this.verdictDecisionDate = verdictDecisionDate;
	}
	
}
