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
@Table(name = "user_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("father_name")
	private String fatherName;

	@JsonProperty("grand_father_name")
	private String grandFatherName;

	@JsonProperty("family_name")
	private String familyName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@JsonProperty("address")
	private String address;

	@JsonProperty("role")
	private String role;

	@JsonProperty("date_of_birth")
	private Long dateOfBirth;

	@JsonProperty("place_of_birth")
	private String placeOfBirth;

	@JsonProperty("education")
	private String education;

	@JsonProperty("experience")
	private String experience;

	@JsonProperty("skills")
	private String skills;

	@JsonProperty("nationality")
	private String nationality;

	@JsonProperty("profile_picture")
	private String profilePicture;

	@JsonProperty("company_id")
	private Integer companyId;

	@JsonProperty("created_time")
	private Long createdTime;

	@JsonProperty("updated_time")
	private Long updatedTime;

	@JsonProperty("is_active")
	private Boolean isActive;

	@JsonProperty("is_deleted")
	private Boolean isDeleted;

	@JsonProperty("is_company_created")
	private Boolean isCompanyCreated;

	@JsonProperty("is_ftl")
	private Boolean isFtl;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("father_name")
	public String getFatherName() {
		return fatherName;
	}

	@JsonProperty("father_name")
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@JsonProperty("grand_father_name")
	public String getGrandFatherName() {
		return grandFatherName;
	}

	@JsonProperty("grand_father_name")
	public void setGrandFatherName(String grandFatherName) {
		this.grandFatherName = grandFatherName;
	}

	@JsonProperty("family_name")
	public String getFamilyName() {
		return familyName;
	}

	@JsonProperty("family_name")
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("role")
	public String getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(String role) {
		this.role = role;
	}

	@JsonProperty("date_of_birth")
	public Long getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("date_of_birth")
	public void setDateOfBirth(Long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@JsonProperty("place_of_birth")
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	@JsonProperty("place_of_birth")
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@JsonProperty("education")
	public String getEducation() {
		return education;
	}

	@JsonProperty("education")
	public void setEducation(String education) {
		this.education = education;
	}

	@JsonProperty("experience")
	public String getExperience() {
		return experience;
	}

	@JsonProperty("experience")
	public void setExperience(String experience) {
		this.experience = experience;
	}

	@JsonProperty("skills")
	public String getSkills() {
		return skills;
	}

	@JsonProperty("skills")
	public void setSkills(String skills) {
		this.skills = skills;
	}

	@JsonProperty("nationality")
	public String getNationality() {
		return nationality;
	}

	@JsonProperty("nationality")
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@JsonProperty("profile_picture")
	public String getProfilePicture() {
		return profilePicture;
	}

	@JsonProperty("profile_picture")
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	@JsonProperty("company_id")
	public Integer getCompanyId() {
		return companyId;
	}

	@JsonProperty("company_id")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	@JsonProperty("is_company_created")
	public Boolean getIsCompanyCreated() {
		return isCompanyCreated;
	}

	@JsonProperty("is_company_created")
	public void setIsCompanyCreated(Boolean isCompanyCreated) {
		this.isCompanyCreated = isCompanyCreated;
	}

	@JsonProperty("is_ftl")
	public Boolean getIsFtl() {
		return isFtl;
	}

	@JsonProperty("is_ftl")
	public void setIsFtl(Boolean isFtl) {
		this.isFtl = isFtl;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
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
        hash = 13 * hash + Objects.hashCode(this.companyId);
        return hash;
	}

}