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

	public String getHead(){
		return head;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	public String getName(){
		return name;
	}
}