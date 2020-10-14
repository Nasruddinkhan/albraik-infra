package com.albraik.infra.jobtitle.dto;

public final class JobTitleDTO {

	private Integer id;
	private String name;
	
	public JobTitleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobTitleDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
