package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Technologies{

	@JsonProperty("cloud")
	private Cloud cloud;

	@JsonProperty("languages")
	private List<String> languages;

	@JsonProperty("tools")
	private List<String> tools;

	public Cloud getCloud(){
		return cloud;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public List<String> getTools(){
		return tools;
	}
}