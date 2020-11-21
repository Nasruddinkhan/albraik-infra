package com.albraik.infra.registration.model;

import java.io.IOException;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.albraik.infra.department.model.DepartmentEntity;
import com.albraik.infra.jobtitle.model.JobTitleEntity;
import com.albraik.infra.role.model.RoleEntity;
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

	@OneToOne
	@JoinColumn(name = "user_id")
	@JsonProperty("user")
	private UserEntity user;

	@ManyToOne(optional = true)
	@JoinColumn(name = "department_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty("department")
	private DepartmentEntity department;

	@ManyToOne(optional = true)
	@JoinColumn(name = "job_title_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty("job_title")
	private JobTitleEntity jobTitle;

	@JsonProperty("joining_date")
	private Date joiningDate;

	@ManyToOne(optional = true)
	@JoinColumn(name = "role_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty("role")
	private RoleEntity role;

	public UserJobEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public JobTitleEntity getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitleEntity jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@Override
	public String toString() {
		ObjectMapper Obj = new ObjectMapper();
		try {
			// return JSON String
			return Obj.writeValueAsString(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.getClass().getName();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 13 * hash + Objects.hashCode(this.id);
		hash = 13 * hash + Objects.hashCode(this.user.getId());
		hash = 13 * hash + Objects.hashCode(this.department.getId());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UserJobEntity userObj = (UserJobEntity) obj;
		return userObj.id == this.id;
	}

}
