package com.albraik.infra.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "project_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("project_id") 
	private Integer projectId;
	
	@JsonProperty("name") 
	private String name;
	
	@JsonProperty("case_logo")
	private String caseLogo;
	
	@JsonProperty("project_type_id") 
	private String projectTypeId;
	
	@JsonProperty("objective") 
	private String objective;
	
	@JsonProperty("start_date") 
	private String startDate;
	
	@JsonProperty("priority") 
	private String priority;
	
	@JsonProperty("manager_id") 
	private Integer managerId;
	
	@JsonProperty("drawer_number") 
	private String drawerNumber;
	
	@JsonProperty("is_hidden") 
	private Boolean hiddinProject;
	
	@JsonProperty("comment") 
	private String comment;
	
	@JsonProperty("created_by") 
	private Integer createdBy;
	
	@JsonProperty("is_active") 
	private Boolean isActive;
	
	@JsonProperty("created_time") 
	private Long createdTime;
	
	@JsonProperty("updated_time") 
	private Long updatedTime;

	@JsonProperty("case_logo")
	public String getCaseLogo() {
		return caseLogo;
	}
	@JsonProperty("case_logo")
	public void setCaseLogo(String caseLogo) {
		this.caseLogo = caseLogo;
	}
	@JsonProperty("id") 
    public Integer getProjectId() {
		return projectId;
	}
	@JsonProperty("id") 
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("name") 
    public String getName() { 
		 return this.name; 
	} 
    
    @JsonProperty("name") 
    public void setName(String name) { 
		 this.name = name; 
	} 
    
    @JsonProperty("project_type_id") 
    public String getProjectTypeId() { 
		 return this.projectTypeId; 
	} 
    
    @JsonProperty("project_type_id") 
    public void setProjectTypeId(String projectTypeId) { 
		 this.projectTypeId = projectTypeId; 
	} 
    
    @JsonProperty("objective") 
    public String getObjective() { 
		 return this.objective; 
	} 
    
    @JsonProperty("objective") 
    public void setObjective(String objective) { 
		 this.objective = objective; 
	} 
    
    @JsonProperty("start_date") 
    public String getStartDate() { 
		 return this.startDate; 
	} 
    
    @JsonProperty("start_date") 
    public void setStartDate(String startDate) { 
		 this.startDate = startDate; 
	} 
    
    @JsonProperty("priority") 
    public String getPriority() { 
		 return this.priority; 
	} 
    
    @JsonProperty("priority") 
    public void setPriority(String priority) { 
		 this.priority = priority; 
	} 
    
    @JsonProperty("manager_id") 
    public Integer getManagerId() { 
		 return this.managerId; 
	} 
    
    @JsonProperty("manager_id") 
    public void setManagerId(Integer managerId) { 
		 this.managerId = managerId; 
	} 
    
    @JsonProperty("drawer_number") 
    public String getDrawerNumber() { 
		 return this.drawerNumber; 
	} 
    
    @JsonProperty("drawer_number")
    public void setDrawerNumber(String drawerNumber) { 
		 this.drawerNumber = drawerNumber; 
	} 
    
    @JsonProperty("comment") 
    public String getComment() { 
		 return this.comment; 
	} 
    @JsonProperty("hiddin_project") 
    public Boolean getHiddinProject() {
		return hiddinProject;
	}
    @JsonProperty("hiddin_project") 
	public void setHiddinProject(Boolean hiddinProject) {
		this.hiddinProject = hiddinProject;
	}
	@JsonProperty("comment") 
    public void setComment(String comment) { 
		 this.comment = comment; 
	} 
    
    @JsonProperty("created_by") 
    public Integer getCreatedBy() { 
		 return this.createdBy; 
	} 
    
    @JsonProperty("created_by") 
    public void setCreatedBy(Integer createdBy) { 
		 this.createdBy = createdBy; 
	} 
    
    @JsonProperty("is_active") 
    public Boolean getIsActive() { 
		 return this.isActive; 
	} 
    
    @JsonProperty("is_active") 
    public void setIsActive(Boolean isActive) { 
		 this.isActive = isActive; 
	} 
    
    @JsonProperty("created_time") 
    public Long getCreatedTime() { 
		 return this.createdTime; 
	} 
    
    @JsonProperty("created_time") 
    public void setCreatedTime(Long createdTime) { 
		 this.createdTime = createdTime; 
	} 
    
    @JsonProperty("updated_time") 
    public Long getUpdatedTime() { 
		 return this.updatedTime; 
	} 
    
    @JsonProperty("updated_time") 
    public void setUpdatedTime(Long updatedTime) { 
		 this.updatedTime = updatedTime; 
	} 

}
