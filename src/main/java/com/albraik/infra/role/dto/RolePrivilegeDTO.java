package com.albraik.infra.role.dto;

import java.util.List;

import com.albraik.infra.privilege.model.PrivilegeEntity;

public final class RolePrivilegeDTO {
	private Integer id;
	private String name;
	private Integer companyId;
	private Long createdTime;
	private Long updatedTime;
	private Integer createdBy;
	private List<PrivilegeEntity> privilegeList;

	public RolePrivilegeDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	public List<PrivilegeEntity> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<PrivilegeEntity> privilegeList) {
		this.privilegeList = privilegeList;
	}

}
