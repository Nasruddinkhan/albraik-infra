package com.albraik.infra.registration.dto;

public final class LoginResponseDTO {
	private String token;
	private Integer id;
	private String email;
	private String role;
	private Integer companyId;
	private Boolean isFtl;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsFtl() {
		return isFtl;
	}

	public void setIsFtl(Boolean isFtl) {
		this.isFtl = isFtl;
	}
	
}