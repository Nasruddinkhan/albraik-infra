package com.albraik.infra.registration.dto;

import java.sql.Date;

public class UserRegisterRequestDTO {

	private String email;
	
	private String phoneNumber;
	
	private Integer departmentId;
	
	private Integer roleId;
	
	private Integer jobTitleId;
	
	private Integer companyId;
	
	private String role;
	
	private Boolean isActive;
	
	private Boolean isFtl;
	
	private Date joiningDate;
	
	private Integer createdBy;
	
	private Long createdTime;
	
	private Long updatedTime;

	public UserRegisterRequestDTO() {
		this.createdTime = System.currentTimeMillis();
		this.updatedTime = System.currentTimeMillis();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(Integer jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsFtl() {
		return isFtl;
	}

	public void setIsFtl(Boolean isFtl) {
		this.isFtl = isFtl;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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

	@Override
	public String toString() {
		return "UserRegisterRequestDTO [email=" + email + ", phoneNumber=" + phoneNumber + ", departmentId="
				+ departmentId + ", roleId=" + roleId + ", jobTitleId=" + jobTitleId + ", companyId=" + companyId
				+ ", role=" + role + ", isActive=" + isActive + ", isFtl=" + isFtl + ", joiningDate=" + joiningDate
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}

}
