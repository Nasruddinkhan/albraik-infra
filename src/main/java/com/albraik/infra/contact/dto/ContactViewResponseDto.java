package com.albraik.infra.contact.dto;

import static com.albraik.infra.util.CommonUtils.checkNull;

public final class ContactViewResponseDto {
	 ContactResponseDto contactResponseDto;
	private String firstName;
	private String email;
	public ContactViewResponseDto(Object[] obj){
		contactResponseDto = new ContactResponseDto(obj);
		this.firstName =  checkNull(obj[8]);
		this.email =  checkNull(obj[9]);
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public ContactResponseDto getContactResponseDto() {
		return contactResponseDto;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getEmail() {
		return email;
	}
	
}
