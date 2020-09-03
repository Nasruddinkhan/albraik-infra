package com.albraik.infra.registration.dto;

public final class AdminRegisterRequestDTO {
	private String email;
	private String phoneNumber;
	private String password;
	private String confpassword;
	private Boolean isActive;
	private String role;
	private Long createdTime;
	private Long updatedTime;
	private Boolean isFtl;
	public AdminRegisterRequestDTO() {
		super();
		this.createdTime = System.currentTimeMillis();
		this.updatedTime =  System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}
	public AdminRegisterRequestDTO(String email, String phoneNumber, String password,
			String confpassword, Boolean isActive,  Boolean isFtl,
			String role) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confpassword = confpassword;
		this.role =  role;
		this.isActive = isActive;
		this.isFtl = isFtl;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfpassword() {
		return confpassword;
	}
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	@Override
	public String toString() {
		return "AdminRegisterRequestDTO [email=" + email + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", confpassword=" + confpassword + ", isActive=" + isActive + ", role=" + role + ", createdTime="
				+ createdTime + ", updatedTime=" + updatedTime + "]";
	}
	
}
