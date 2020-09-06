package com.albraik.infra.registration.dto;

public final class ChangePasswordRequestDTO {
	private Integer id;
	private String password;
	private String confpassword;
	private Long updatedTime;
	private Boolean isFtl;
	
	public ChangePasswordRequestDTO() {
		super();
		this.updatedTime = System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}
	public ChangePasswordRequestDTO(Integer id, String password, String confpassword, Long updatedTime, Boolean isFtl) {
		super();
		this.id = id;
		this.password = password;
		this.confpassword = confpassword;
		this.updatedTime = updatedTime;
		this.isFtl = isFtl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Long getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Boolean getIsFtl() {
		return isFtl;
	}
	public void setIsFtl(Boolean isFtl) {
		this.isFtl = isFtl;
	}
	
	
	
}
