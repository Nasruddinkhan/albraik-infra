package com.albraik.infra.project.dto;

import java.sql.Date;

public final class ProjectCaseDto {
	private Integer projectDetailsId;
	private ProjectDto project;
	private String caseNumber;
	private Integer caseCourtId;
	private Integer caseJudgeId;
	private String caseOffice;
	private Date caseConsultantEngagementDate;
	private Integer caseClientId;
	private Integer caseOpposingId;
	private Integer caseOpposingRepresenterId;
	private String caseConsultantEngagementText;
	private Integer caseConsultantId;
	private String caseClientPosition;
	private String caseOpposingPosition;
	
	public ProjectCaseDto(ProjectDto project, String caseNumber, Integer caseCourtId, Integer caseJudgeId,
			String caseOffice, Date caseConsultantEngagementDate, Integer caseClientId, Integer caseOpposingId,
			Integer caseOpposingRepresenterId, String caseConsultantEngagementText, Integer caseConsultantId,
			String caseClientPosition, String caseOpposingPosition) {
		super();
		this.project = project;
		this.caseNumber = caseNumber;
		this.caseCourtId = caseCourtId;
		this.caseJudgeId = caseJudgeId;
		this.caseOffice = caseOffice;
		this.caseConsultantEngagementDate = caseConsultantEngagementDate;
		this.caseClientId = caseClientId;
		this.caseOpposingId = caseOpposingId;
		this.caseOpposingRepresenterId = caseOpposingRepresenterId;
		this.caseConsultantEngagementText = caseConsultantEngagementText;
		this.caseConsultantId = caseConsultantId;
		this.caseClientPosition = caseClientPosition;
		this.caseOpposingPosition = caseOpposingPosition;
	}
	
	public Integer getProjectDetailsId() {
		return projectDetailsId;
	}

	public void setProjectDetailsId(Integer projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}

	public ProjectCaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectDto getProject() {
		return project;
	}
	public void setProject(ProjectDto project) {
		this.project = project;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public Integer getCaseCourtId() {
		return caseCourtId;
	}
	public void setCaseCourtId(Integer caseCourtId) {
		this.caseCourtId = caseCourtId;
	}
	public Integer getCaseJudgeId() {
		return caseJudgeId;
	}
	public void setCaseJudgeId(Integer caseJudgeId) {
		this.caseJudgeId = caseJudgeId;
	}
	public String getCaseOffice() {
		return caseOffice;
	}
	public void setCaseOffice(String caseOffice) {
		this.caseOffice = caseOffice;
	}
	public Date getCaseConsultantEngagementDate() {
		return caseConsultantEngagementDate;
	}
	public void setCaseConsultantEngagementDate(Date caseConsultantEngagementDate) {
		this.caseConsultantEngagementDate = caseConsultantEngagementDate;
	}
	public Integer getCaseClientId() {
		return caseClientId;
	}
	public void setCaseClientId(Integer caseClientId) {
		this.caseClientId = caseClientId;
	}

	
	public Integer getCaseOpposingId() {
		return caseOpposingId;
	}

	public void setCaseOpposingId(Integer caseOpposingId) {
		this.caseOpposingId = caseOpposingId;
	}

	public Integer getCaseOpposingRepresenterId() {
		return caseOpposingRepresenterId;
	}
	public void setCaseOpposingRepresenterId(Integer caseOpposingRepresenterId) {
		this.caseOpposingRepresenterId = caseOpposingRepresenterId;
	}
	public String getCaseConsultantEngagementText() {
		return caseConsultantEngagementText;
	}
	public void setCaseConsultantEngagementText(String caseConsultantEngagementText) {
		this.caseConsultantEngagementText = caseConsultantEngagementText;
	}
	public Integer getCaseConsultantId() {
		return caseConsultantId;
	}
	public void setCaseConsultantId(Integer caseConsultantId) {
		this.caseConsultantId = caseConsultantId;
	}
	public String getCaseClientPosition() {
		return caseClientPosition;
	}
	public void setCaseClientPosition(String caseClientPosition) {
		this.caseClientPosition = caseClientPosition;
	}
	public String getCaseOpposingPosition() {
		return caseOpposingPosition;
	}
	public void setCaseOpposingPosition(String caseOpposingPosition) {
		this.caseOpposingPosition = caseOpposingPosition;
	}

	@Override
	public String toString() {
		return "ProjectCaseDto [projectDetailsId=" + projectDetailsId + ", project=" + project + ", caseNumber="
				+ caseNumber + ", caseCourtId=" + caseCourtId + ", caseJudgeId=" + caseJudgeId + ", caseOffice="
				+ caseOffice + ", caseConsultantEngagementDate=" + caseConsultantEngagementDate + ", caseClientId="
				+ caseClientId + ", caseOpposing=" + caseOpposingId + ", caseOpposingRepresenterId="
				+ caseOpposingRepresenterId + ", caseConsultantEngagementText=" + caseConsultantEngagementText
				+ ", caseConsultantId=" + caseConsultantId + ", caseClientPosition=" + caseClientPosition
				+ ", caseOpposingPosition=" + caseOpposingPosition + "]";
	}
	

}
