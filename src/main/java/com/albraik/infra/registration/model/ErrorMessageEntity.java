package com.albraik.infra.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "error_messages")
public class ErrorMessageEntity{
	@Id
	@JsonProperty("error_id")
	private String errorId;
	
	@JsonProperty("error_message")
	private String errorMessage;
	
	@JsonProperty("created_time")
	private Long createdTime;

	@JsonProperty("updated_time")
	private Long updatedTime;

	@JsonProperty("is_active")
	private Boolean isActive;

	public ErrorMessageEntity(String errorId, String errorMessage, Long createdTime, Long updatedTime, Boolean isActive) {
		super();
		this.errorId = errorId;
		this.errorMessage = errorMessage;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.isActive = isActive;
	}

	public ErrorMessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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

}
