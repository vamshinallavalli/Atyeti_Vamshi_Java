package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MembersItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("experience")
	private int experience;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setExperience(int experience){
		this.experience = experience;
	}

	public int getExperience(){
		return experience;
	}
}