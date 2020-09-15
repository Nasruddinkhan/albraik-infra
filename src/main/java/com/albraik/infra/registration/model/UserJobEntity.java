package com.albraik.infra.registration.model;

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
@Table(name = "user_job")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserJobEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("user_id")
	private Integer userId;

	@JsonProperty("department_id")
	private Integer departmentId;

	@JsonProperty("job_title_id")
	private Integer jobTitleId;
	
	@JsonProperty("joining_date")
	private String joiningDate;

	@JsonProperty("role_id")
	private Integer roleId;

	public UserJobEntity( Integer userId, Integer departmentId, Integer jobTitleId, String joiningDate,
			Integer roleId) {
		super();
		this.userId = userId;
		this.departmentId = departmentId;
		this.jobTitleId = jobTitleId;
		this.joiningDate = joiningDate;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(Integer jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
        hash = 13 * hash + Objects.hashCode(this.userId);
        hash = 13 * hash + Objects.hashCode(this.departmentId);
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
		final UserJobEntity userObj = (UserJobEntity) obj;
		return userObj.id == this.id;
	}

	
}
