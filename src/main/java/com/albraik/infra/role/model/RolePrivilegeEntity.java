package com.albraik.infra.role.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "role_privilege")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePrivilegeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("role_id")
	private Integer roleId;

	@JsonProperty("privilege_id")
	private String privilegeId;

	@JsonProperty("created_time")
	private Long createdTime;

	@JsonProperty("updated_time")
	private Long updatedTime;

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

	@JsonProperty("role_id")
	public Integer getRoleId() {
		return roleId;
	}

	@JsonProperty("role_id")
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@JsonProperty("privilege_id")
	public String getPrivilegeId() {
		return privilegeId;
	}

	@JsonProperty("privilege_id")
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
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

	@JsonProperty("is_deleted")
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	@JsonProperty("is_deleted")
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
