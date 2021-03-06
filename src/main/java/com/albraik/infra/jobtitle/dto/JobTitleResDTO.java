package com.albraik.infra.jobtitle.dto;

public final class JobTitleResDTO {

	private Integer id;
	private String name;
	private Integer companyId;
	private Long createdTime;
	private Long updatedTime;
	private Integer createdBy;
	private Boolean isActive;
	private Boolean isDeleted;
	
	
	public JobTitleResDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobTitleResDTO(Integer id, String name, Integer companyId, Long createdTime, Long updatedTime,
			Integer createdBy, Boolean isActive, Boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.companyId = companyId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
