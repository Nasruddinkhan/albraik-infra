package com.albraik.infra.court.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "court")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourtEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("company_id")
	private Integer companyId;
	
	@JsonProperty("created_time")
	private Long createdTime;
	
	@JsonProperty("updated_time")
	private Long updatedTime;
	
	@JsonProperty("created_by")
	private Integer createdBy;
	
	@JsonProperty("is_active")
	private Boolean isActive;
	
	@JsonProperty("is_deleted")
	private Boolean isDeleted;
	
	public CourtEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public CourtEntity(String name, Integer companyId, Long createdTime, Long updatedTime, Integer createdBy, Boolean isActive, Boolean isDeleted) {
		super();
		this.name = name;
		this.companyId = companyId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("company_id")
	public Integer getCompanyId() {
		return companyId;
	}
	
	@JsonProperty("company_id")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty("created_by")
	public Integer getCreatedBy() {
		return createdBy;
	}
	
	@JsonProperty("created_by")
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	@JsonProperty("is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	@JsonProperty("is_active")
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@JsonProperty("is_deleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	@JsonProperty("is_deleted")
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@JsonProperty("created_time")
	public Long getCreatedTime() {
		return createdTime;
	}
	@JsonProperty("created_time")
	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}
	
	@JsonProperty("updated_time")
	public Long getUpdatedTime() {
		return updatedTime;
	}
	
	@JsonProperty("updated_time")
	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	
	
}
