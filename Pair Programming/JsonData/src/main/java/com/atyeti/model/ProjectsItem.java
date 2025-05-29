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

	public void setStack(Stack stack){
		this.stack = stack;
	}

	public Stack getStack(){
		return stack;
	}

	public void setTeamSize(int teamSize){
		this.teamSize = teamSize;
	}

	public int getTeamSize(){
		return teamSize;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}