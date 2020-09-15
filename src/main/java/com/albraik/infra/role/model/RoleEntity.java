package com.albraik.infra.role.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleEntity {

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
