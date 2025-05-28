package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MembersItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("experience")
	private int experience;

	public String getName(){
		return name;
	}

	public int getExperience(){
		return experience;
	}
}