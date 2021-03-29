package com.albraik.infra.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "master_pages")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MasterEntity {
	@Id
	@JsonProperty("master_id")
	private String masterId;

	@JsonProperty("master_description")
	private String masterDescription;
	

	@JsonProperty("role")
	private String role;
	
	@JsonProperty("is_active")
	private Boolean isActive;

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getMasterDescription() {
		return masterDescription;
	}

	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
