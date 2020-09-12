package com.albraik.infra.registration.dto;

public final class MasterResponseDTO {
	private String masterId;
	private String masterDescription;
	public MasterResponseDTO(String masterId, String masterDescription) {
		super();
		this.masterId = masterId;
		this.masterDescription = masterDescription;
	}
	public MasterResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
}
