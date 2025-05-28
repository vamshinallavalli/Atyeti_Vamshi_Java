package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectsItem{

	@JsonProperty("stack")
	private Stack stack;

	@JsonProperty("teamSize")
	private int teamSize;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("status")
	private String status;

	public Stack getStack(){
		return stack;
	}

	public int getTeamSize(){
		return teamSize;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}
}