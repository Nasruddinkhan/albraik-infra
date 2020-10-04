package com.albraik.infra.court.dto;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CourtDTO {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
