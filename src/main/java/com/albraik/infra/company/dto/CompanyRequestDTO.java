package com.albraik.infra.company.dto;

import org.springframework.web.multipart.MultipartFile;

public final class CompanyRequestDTO {
	private Integer id;
	private MultipartFile  file;
	private  String phoneNumber;
	private  String faxNumber;
	private  String address;
	private String companyLogo;
	private Long createdTime;
	private Long updatedTime;
	private  Integer createdBy;
	private String name;
	public CompanyRequestDTO() {
		super();
		this.createdTime = System.currentTimeMillis();
		this.updatedTime =  System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}
	public CompanyRequestDTO(MultipartFile file, String phoneNumber, String faxNumber, String address, Integer createdBy, String name) {
		super();
		this.file = file;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.address = address;
		this.createdBy = createdBy;
		this.name = name;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
