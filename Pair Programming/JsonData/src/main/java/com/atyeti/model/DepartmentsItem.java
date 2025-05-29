package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentsItem{

	@JsonProperty("head")
	private String head;

	@JsonProperty("teams")
	private List<TeamsItem> teams;

	@JsonProperty("name")
	private String name;

	public void setHead(String head){
		this.head = head;
	}

	public String getHead(){
		return head;
	}

	public void setTeams(List<TeamsItem> teams){
		this.teams = teams;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}