package com.albraik.infra.department.dto;

public final class DepartmentResDTO {
	private Integer id;
	private String name;
	private Integer companyId;
	private Long createdTime;
	private Long updatedTime;
	private Integer createdBy;
	
	
	public DepartmentResDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentResDTO(Integer id, String name, Integer companyId, Long createdTime, Long updatedTime,
			Integer createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.companyId = companyId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
