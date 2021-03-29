package com.albraik.infra.contact.dto;

import static com.albraik.infra.util.CommonUtils.checkNull;

public final class ContactResponseDto {
	private String phoneNumber;
	private String faxNumber;
	private String email;
	private String address;
	private String comment;
	private String categoryName;
	private String id;
	private String name;
	public ContactResponseDto(Object[] obj) {
		this.id =  checkNull(obj[0]);
		this.name = checkNull(obj[1]);
		this.phoneNumber =  checkNull(obj[2]);
		this.faxNumber =  checkNull(obj[3]);
		this.email =  checkNull(obj[4]);
		this.address =  checkNull(obj[5]);
		this.comment = checkNull(obj[6]);
		this.categoryName = checkNull(obj[7]);
		// TODO Auto-generated constructor stub
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getComment() {
		return comment;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	
}
