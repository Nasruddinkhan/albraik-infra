package com.albraik.infra.project.model;

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
@Table(name = "project_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id") 
	int id;
	
	@JsonProperty("name") 
	String name;
	
	@JsonProperty("project_type_id") 
	int projectTypeId;
	
	@JsonProperty("objective") 
	String objective;
	
	@JsonProperty("start_date") 
	String startDate;
	
	@JsonProperty("priority") 
	String priority;
	
	@JsonProperty("manager_id") 
	int managerId;
	
	@JsonProperty("drawer_number") 
	String drawerNumber;
	
	@JsonProperty("is_hidden") 
	boolean isHidden;
	
	@JsonProperty("comments") 
	String comments;
	
	@JsonProperty("created_by") 
	int createdBy;
	
	@JsonProperty("is_active") 
	boolean isActive;
	
	@JsonProperty("is_deleted") 
	boolean isDeleted;
	
	@JsonProperty("created_time") 
	long createdTime;
	
	@JsonProperty("updated_time") 
	long updatedTime;
	
	
	@JsonProperty("id") 
    public int getId() { 
		 return this.id; 
	} 
	
	@JsonProperty("id") 
    public void setId(int id) { 
		 this.id = id; 
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
    public int getProjectTypeId() { 
		 return this.projectTypeId; 
	} 
    
    @JsonProperty("project_type_id") 
    public void setProjectTypeId(int projectTypeId) { 
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
    public int getManagerId() { 
		 return this.managerId; 
	} 
    
    @JsonProperty("manager_id") 
    public void setManagerId(int managerId) { 
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
    
    @JsonProperty("is_hidden") 
    public boolean getIsHidden() { 
		 return this.isHidden; 
	} 
    
    @JsonProperty("is_hidden") 
    public void setIsHidden(boolean isHidden) { 
		 this.isHidden = isHidden; 
	} 
    
    @JsonProperty("comments") 
    public String getComments() { 
		 return this.comments; 
	} 
    
    @JsonProperty("comments") 
    public void setComments(String comments) { 
		 this.comments = comments; 
	} 
    
    @JsonProperty("created_by") 
    public int getCreatedBy() { 
		 return this.createdBy; 
	} 
    
    @JsonProperty("created_by") 
    public void setCreatedBy(int createdBy) { 
		 this.createdBy = createdBy; 
	} 
    
    @JsonProperty("is_active") 
    public boolean getIsActive() { 
		 return this.isActive; 
	} 
    
    @JsonProperty("is_active") 
    public void setIsActive(boolean isActive) { 
		 this.isActive = isActive; 
	} 
    
    @JsonProperty("is_deleted") 
    public boolean getIsDeleted() { 
		 return this.isDeleted; 
	} 
    
    @JsonProperty("is_deleted") 
    public void setIsDeleted(boolean isDeleted) { 
		 this.isDeleted = isDeleted; 
	} 
    
    @JsonProperty("created_time") 
    public long getCreatedTime() { 
		 return this.createdTime; 
	} 
    
    @JsonProperty("created_time") 
    public void setCreatedTime(long createdTime) { 
		 this.createdTime = createdTime; 
	} 
    
    @JsonProperty("updated_time") 
    public long getUpdatedTime() { 
		 return this.updatedTime; 
	} 
    
    @JsonProperty("updated_time") 
    public void setUpdatedTime(long updatedTime) { 
		 this.updatedTime = updatedTime; 
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
        hash = 13 * hash + Objects.hashCode(this.projectTypeId);
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
		final ProjectEntity projectObj = (ProjectEntity) obj;
		return projectObj.id == this.id;
	}
	

}
