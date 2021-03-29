package com.albraik.infra.user.dto;

import java.util.Date;

public class UserDTO {
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	private Date joiningDate;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Integer id, String name, String email, Date joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.joiningDate = joiningDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	

}
