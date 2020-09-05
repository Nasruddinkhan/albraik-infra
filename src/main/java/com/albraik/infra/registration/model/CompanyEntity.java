package com.albraik.infra.registration.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "company_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("fax_number")
	private String faxNumber;
	
	@JsonProperty("company_logo")
	private String companyLogo;
	
	@JsonProperty("color_scheme_primary")
	private String colorSchemePrimary;
	
	@JsonProperty("color_scheme_secondary")
	private String colorSchemeSecondary;
	
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

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("fax_number")
	public String getFaxNumber() {
		return faxNumber;
	}

	@JsonProperty("fax_number")
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	@JsonProperty("company_logo")
	public String getCompanyLogo() {
		return companyLogo;
	}

	@JsonProperty("company_logo")
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	@JsonProperty("color_scheme_primary")
	public String getColorSchemePrimary() {
		return colorSchemePrimary;
	}

	@JsonProperty("color_scheme_primary")
	public void setColorSchemePrimary(String colorSchemePrimary) {
		this.colorSchemePrimary = colorSchemePrimary;
	}

	@JsonProperty("color_scheme_secondary")
	public String getColorSchemeSecondary() {
		return colorSchemeSecondary;
	}

	@JsonProperty("color_scheme_secondary")
	public void setColorSchemeSecondary(String colorSchemeSecondary) {
		this.colorSchemeSecondary = colorSchemeSecondary;
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

	@JsonProperty("created_by")
	public Integer getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
		return "";
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
		final CompanyEntity companyObj = (CompanyEntity) obj;
		return companyObj.id == this.id;
	}

}
