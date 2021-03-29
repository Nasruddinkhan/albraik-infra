package com.albraik.infra.user.dto;

import java.util.Date;

import com.albraik.infra.department.model.DepartmentEntity;
import com.albraik.infra.jobtitle.model.JobTitleEntity;
import com.albraik.infra.role.dto.RolePrivilegeIdDTO;
import com.albraik.infra.role.model.RoleEntity;

public class UserJobDTO {

	private Integer id;

	private String firstName;

	private String fatherName;

	private String grandFatherName;

	private String familyName;

	private String email;

	private String phoneNumber;

	private Date dateOfBirth;

	private String profilePicture;

	private String mobileNumber;

	private Boolean isActive;

	private Boolean isFtl;

	private RolePrivilegeIdDTO role;

	private DepartmentEntity department;

	private JobTitleEntity jobTitle;

	private Date joiningDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGrandFatherName() {
		return grandFatherName;
	}

	public void setGrandFatherName(String grandFatherName) {
		this.grandFatherName = grandFatherName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public RolePrivilegeIdDTO getRole() {
		return role;
	}

	public void setRole(RolePrivilegeIdDTO role) {
		this.role = role;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public JobTitleEntity getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitleEntity jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

}
