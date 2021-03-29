package com.albraik.infra.role.dto;

import java.util.List;

public final class RoleDTO {

	private Integer id;
	private List<String> name;
	private Integer companyId;
	private Integer createdBy;
	private Long createdTime;
	private Long updatedTime;
	
	public RoleDTO() {
		super();
		this.createdTime = System.currentTimeMillis();
		this.updatedTime =  System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}
	public RoleDTO(Integer id, List<String> name, Integer companyId, Integer createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.companyId = companyId;
		this.createdBy = createdBy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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
	
	
}
