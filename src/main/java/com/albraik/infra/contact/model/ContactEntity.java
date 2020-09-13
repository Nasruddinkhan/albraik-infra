package com.albraik.infra.contact.model;

import java.io.IOException;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "contact_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("contact_type_id")
	private Integer contactTypeId;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("email")
	private String email;

	@JsonProperty("fax_number")
	private String faxNumber;

	@JsonProperty("address")
	private String address;

	@JsonProperty("comment")
	private String comment;

	@JsonProperty("created_by")
	private Integer createdBy;

	@JsonProperty("created_time")
	private Long createdTime;

	@JsonProperty("updated_time")
	private Long updatedTime;

	@JsonProperty("company_id")
	private Integer companyId;

	@JsonProperty("is_deleted")
	private Boolean isDeleted;
	
	
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

	@JsonProperty("contact_type_id")
	public Integer getContactTypeId() {
		return contactTypeId;
	}

	@JsonProperty("contact_type_id")
	public void setContactTypeId(Integer contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("mobile_number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	@JsonProperty("mobile_number")
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("fax_number")
	public String getFaxNumber() {
		return faxNumber;
	}

	@JsonProperty("fax_number")
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
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

	@JsonProperty("company_id")
	public Integer getCompanyId() {
		return companyId;
	}

	@JsonProperty("company_id")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@JsonProperty("is_deleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	@JsonProperty("is_deleted")
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
	public String toString() {
		ObjectMapper Obj = new ObjectMapper();
		try {
			// return JSON String
			return Obj.writeValueAsString(this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return this.getClass().getName();
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.createdBy);
        return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass()) {
            return false;
        }
		final ContactEntity contactObj = (ContactEntity) obj;
		return contactObj.id == this.id;
	}

}
