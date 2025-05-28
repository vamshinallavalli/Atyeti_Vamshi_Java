package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamsItem{

	@JsonProperty("members")
	private List<MembersItem> members;

	@JsonProperty("name")
	private String name;

	@JsonProperty("lead")
	private String lead;

	public List<MembersItem> getMembers(){
		return members;
	}

	public String getName(){
		return name;
	}

	public String getLead(){
		return lead;
	}
}