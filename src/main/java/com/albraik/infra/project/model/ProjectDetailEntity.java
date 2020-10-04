package com.albraik.infra.project.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "project_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("project_details_id")
	private Integer projectDetailsId;

	@JsonProperty("project_id")
	private Integer projectId;

	@JsonProperty("case_number")
	private String caseNumber;

	@JsonProperty("case_court_id")
	private Integer caseCourtId;

	@JsonProperty("case_judge_id")
	private Integer caseJudgeId;

	@JsonProperty("case_office")
	private String caseOffice;

	@JsonProperty("case_consultant_id")
	private Integer caseConsultantId;

	@JsonProperty("case_consultant_engagement_date")
	private Date caseConsultantEngagementDate;

	@JsonProperty("case_client_id")
	private Integer caseClientId;

	@JsonProperty("case_client_position")
	private String caseClientPosition;

	@JsonProperty("case_opposing_id")
	private Integer caseOpposingId;

	@JsonProperty("case_opposing_position")
	private String caseOpposingPosition;

	@JsonProperty("case_opposing_representer_id")
	private Integer caseOpposingRepresenterId;

	@JsonProperty("case_consultant_engagement_text")
	private String caseConsultantEngagementText;

	@JsonProperty("company_name")
	private String companyName;

	@JsonProperty("verdict_executed_case_id")
	private Integer verdictExecutedCaseId;

	@JsonProperty("verdict_number")
	private String verdictNumber;

	@JsonProperty("verdict_date")
	private Date verdictDate;

	@JsonProperty("verdict_source")
	private String verdictSource;

	@JsonProperty("verdict_type")
	private String verdictType;

	@JsonProperty("verdict_decision_date")
	private Date verdictDecisionDate;

	@JsonProperty("inheritance_owner_id")
	private Integer inheritanceOwnerId;

	@JsonProperty("doo_office_reference")
	private String dooOfficeReference;

	@JsonProperty("doo_court_id")
	private Integer dooCourtId;

	@JsonProperty("doo_case_observer_name")
	private String dooCaseObserverName;

	@JsonProperty("doo_case_number")
	private String dooCaseNumber;

	@JsonProperty("doo_referent_date")
	private Date dooReferentDate;


	@JsonProperty("project_details_id")
	public Integer getProjectDetailsId() {
		return projectDetailsId;
	}
	@JsonProperty("project_details_id")
	public void setProjectDetailsId(Integer projectDetailsId) {
		this.projectDetailsId = projectDetailsId;
	}

	

	@JsonProperty("project_id")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("project_id")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("case_number")
	public String getCaseNumber() {
		return caseNumber;
	}

	@JsonProperty("case_number")
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	@JsonProperty("case_court_id")
	public Integer getCaseCourtId() {
		return caseCourtId;
	}

	@JsonProperty("case_court_id")
	public void setCaseCourtId(Integer caseCourtId) {
		this.caseCourtId = caseCourtId;
	}

	@JsonProperty("case_judge_id")
	public Integer getCaseJudgeId() {
		return caseJudgeId;
	}

	@JsonProperty("case_judge_id")
	public void setCaseJudgeId(Integer caseJudgeId) {
		this.caseJudgeId = caseJudgeId;
	}

	@JsonProperty("case_office")
	public String getCaseOffice() {
		return caseOffice;
	}

	@JsonProperty("case_office")
	public void setCaseOffice(String caseOffice) {
		this.caseOffice = caseOffice;
	}

	@JsonProperty("case_consultant_id")
	public Integer getCaseConsultantId() {
		return caseConsultantId;
	}

	@JsonProperty("case_consultant_id")
	public void setCaseConsultantId(Integer caseConsultantId) {
		this.caseConsultantId = caseConsultantId;
	}

	@JsonProperty("case_consultant_engagement_date")
	public Date getCaseConsultantEngagementDate() {
		return caseConsultantEngagementDate;
	}

	@JsonProperty("case_consultant_engagement_date")
	public void setCaseConsultantEngagementDate(Date caseConsultantEngagementDate) {
		this.caseConsultantEngagementDate = caseConsultantEngagementDate;
	}

	@JsonProperty("case_client_id")
	public Integer getCaseClientId() {
		return caseClientId;
	}

	@JsonProperty("case_client_id")
	public void setCaseClientId(Integer caseClientId) {
		this.caseClientId = caseClientId;
	}

	@JsonProperty("case_client_position")
	public String getCaseClientPosition() {
		return caseClientPosition;
	}

	@JsonProperty("case_client_position")
	public void setCaseClientPosition(String caseClientPosition) {
		this.caseClientPosition = caseClientPosition;
	}

	@JsonProperty("case_opposing_id")
	public Integer getCaseOpposingId() {
		return caseOpposingId;
	}

	@JsonProperty("case_opposing_id")
	public void setCaseOpposingId(Integer caseOpposingId) {
		this.caseOpposingId = caseOpposingId;
	}

	@JsonProperty("case_opposing_position")
	public String getCaseOpposingPosition() {
		return caseOpposingPosition;
	}

	@JsonProperty("case_opposing_position")
	public void setCaseOpposingPosition(String caseOpposingPosition) {
		this.caseOpposingPosition = caseOpposingPosition;
	}

	@JsonProperty("case_opposing_representer_id")
	public Integer getCaseOpposingRepresenterId() {
		return caseOpposingRepresenterId;
	}

	@JsonProperty("case_opposing_representer_id")
	public void setCaseOpposingRepresenterId(Integer caseOpposingRepresenterId) {
		this.caseOpposingRepresenterId = caseOpposingRepresenterId;
	}

	@JsonProperty("case_consultant_engagement_text")
	public String getCaseConsultantEngagementText() {
		return caseConsultantEngagementText;
	}

	@JsonProperty("case_consultant_engagement_text")
	public void setCaseConsultantEngagementText(String caseConsultantEngagementText) {
		this.caseConsultantEngagementText = caseConsultantEngagementText;
	}

	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("company_name")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("verdict_executed_case_id")
	public Integer getVerdictExecutedCaseId() {
		return verdictExecutedCaseId;
	}

	@JsonProperty("verdict_executed_case_id")
	public void setVerdictExecutedCaseId(Integer verdictExecutedCaseId) {
		this.verdictExecutedCaseId = verdictExecutedCaseId;
	}

	@JsonProperty("verdict_number")
	public String getVerdictNumber() {
		return verdictNumber;
	}

	@JsonProperty("verdict_number")
	public void setVerdictNumber(String verdictNumber) {
		this.verdictNumber = verdictNumber;
	}

	@JsonProperty("verdict_date")
	public Date getVerdictDate() {
		return verdictDate;
	}

	@JsonProperty("verdict_date")
	public void setVerdictDate(Date verdictDate) {
		this.verdictDate = verdictDate;
	}

	@JsonProperty("verdict_source")
	public String getVerdictSource() {
		return verdictSource;
	}

	@JsonProperty("verdict_source")
	public void setVerdictSource(String verdictSource) {
		this.verdictSource = verdictSource;
	}

	@JsonProperty("verdict_type")
	public String getVerdictType() {
		return verdictType;
	}

	@JsonProperty("verdict_type")
	public void setVerdictType(String verdictType) {
		this.verdictType = verdictType;
	}

	@JsonProperty("verdict_decision_date")
	public Date getVerdictDecisionDate() {
		return verdictDecisionDate;
	}

	@JsonProperty("verdict_decision_date")
	public void setVerdictDecisionDate(Date verdictDecisionDate) {
		this.verdictDecisionDate = verdictDecisionDate;
	}

	@JsonProperty("inheritance_owner_id")
	public Integer getInheritanceOwnerId() {
		return inheritanceOwnerId;
	}

	@JsonProperty("inheritance_owner_id")
	public void setInheritanceOwnerId(Integer inheritanceOwnerId) {
		this.inheritanceOwnerId = inheritanceOwnerId;
	}

	@JsonProperty("doo_office_reference")
	public String getDooOfficeReference() {
		return dooOfficeReference;
	}

	@JsonProperty("doo_office_reference")
	public void setDooOfficeReference(String dooOfficeReference) {
		this.dooOfficeReference = dooOfficeReference;
	}

	@JsonProperty("doo_court_id")
	public Integer getDooCourtId() {
		return dooCourtId;
	}

	@JsonProperty("doo_court_id")
	public void setDooCourtId(Integer dooCourtId) {
		this.dooCourtId = dooCourtId;
	}

	@JsonProperty("doo_case_observer_name")
	public String getDooCaseObserverName() {
		return dooCaseObserverName;
	}

	@JsonProperty("doo_case_observer_name")
	public void setDooCaseObserverName(String dooCaseObserverName) {
		this.dooCaseObserverName = dooCaseObserverName;
	}

	@JsonProperty("doo_case_number")
	public String getDooCaseNumber() {
		return dooCaseNumber;
	}

	@JsonProperty("doo_case_number")
	public void setDooCaseNumber(String dooCaseNumber) {
		this.dooCaseNumber = dooCaseNumber;
	}

	@JsonProperty("doo_referent_date")
	public Date getDooReferentDate() {
		return dooReferentDate;
	}

	@JsonProperty("doo_referent_date")
	public void setDooReferentDate(Date dooReferentDate) {
		this.dooReferentDate = dooReferentDate;
	}



}
