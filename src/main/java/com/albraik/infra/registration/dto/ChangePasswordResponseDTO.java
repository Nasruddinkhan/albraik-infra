package com.albraik.infra.registration.dto;

public final class ChangePasswordResponseDTO {
	private Integer id;
	private String email;
	private Integer companyId;
	private Boolean isFtl;
	public ChangePasswordResponseDTO(Integer id, String email, Integer companyId, Boolean isFtl) {
		super();
		this.id = id;
		this.email = email;
		this.companyId = companyId;
		this.isFtl = isFtl;
	}
	public ChangePasswordResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
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
