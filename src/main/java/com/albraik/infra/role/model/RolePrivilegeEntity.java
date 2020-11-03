package com.albraik.infra.role.model;

import java.io.IOException;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.privilege.model.PrivilegeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "role_privilege")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePrivilegeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	@JsonProperty("role")
	private RoleEntity role;

	@ManyToOne
	@JoinColumn(name = "privilege_id", referencedColumnName = "id")
	@JsonProperty("privilege")
	private PrivilegeEntity privilege;

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

	@JsonProperty("role")
	public RoleEntity getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@JsonProperty("privilege")
	public PrivilegeEntity getPrivilege() {
		return privilege;
	}

	@JsonProperty("privilege")
	public void setPrivilege(PrivilegeEntity privilege) {
		this.privilege = privilege;
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
        hash = 13 * hash + Objects.hashCode(this.role);
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
		final RolePrivilegeEntity rolePrivilegeEntity = (RolePrivilegeEntity) obj;
		return rolePrivilegeEntity.id == this.id;
	}

}
