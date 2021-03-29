package com.albraik.infra.project.dto;

import java.sql.Date;

public final class ProjectDeedCase {
	private ProjectDto project;
    private String dooOfficeReference;
    private String dooCourtId;
    private String dooCaseObserverName;
    private String dooCaseNumber;
    private Date dooReferentDate;
    private Integer projectDetailsId;
    
	public ProjectDeedCase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectDeedCase(ProjectDto project, String dooOfficeReference, String dooCourtId, String dooCaseObserverName,
			String dooCaseNumber, Date dooReferentDate, Integer projectDetailsId) {
		super();
		this.project = project;
		this.dooOfficeReference = dooOfficeReference;
		this.dooCourtId = dooCourtId;
		this.dooCaseObserverName = dooCaseObserverName;
		this.dooCaseNumber = dooCaseNumber;
		this.dooReferentDate = dooReferentDate;
		this.projectDetailsId = projectDetailsId;
	}
	public ProjectDto getProject() {
		return project;
	}
	public void setProject(ProjectDto project) {
		this.project = project;
	}
	public String getDooOfficeReference() {
		return dooOfficeReference;
	}
	public void setDooOfficeReference(String dooOfficeReference) {
		this.dooOfficeReference = dooOfficeReference;
	}
	public String getDooCourtId() {
		return dooCourtId;
	}
	public void setDooCourtId(String dooCourtId) {
		this.dooCourtId = dooCourtId;
	}
	public String getDooCaseObserverName() {
		return dooCaseObserverName;
	}
	public void setDooCaseObserverName(String dooCaseObserverName) {
		this.dooCaseObserverName = dooCaseObserverName;
	}
	public String getDooCaseNumber() {
		return dooCaseNumber;
	}
	public void setDooCaseNumber(String dooCaseNumber) {
		this.dooCaseNumber = dooCaseNumber;
	}
	public Date getDooReferentDate() {
		return dooReferentDate;
	}
	public void setDooReferentDate(Date dooReferentDate) {
		this.dooReferentDate = dooReferentDate;
	}
	public Integer getProjectDetailsId() {
		return projectDetailsId;
	}
	public void setProjectDetailsId(Integer projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}
    
	
	@Override
	public String toString() {
		return "ProjectDeedCase [project=" + project + ", dooOfficeReference=" + dooOfficeReference + ", dooCourtId="
				+ dooCourtId + ", dooCaseObserverName=" + dooCaseObserverName + ", dooCaseNumber=" + dooCaseNumber
				+ ", dooReferentDate=" + dooReferentDate + ", projectDetailsId=" + projectDetailsId + "]";
	}
}
