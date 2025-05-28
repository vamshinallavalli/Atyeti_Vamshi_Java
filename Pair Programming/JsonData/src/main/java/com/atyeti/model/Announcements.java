package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Announcements{

	@JsonProperty("next")
	private String next;

	@JsonProperty("latest")
	private String latest;

	public String getNext(){
		return next;
	}

	public String getLatest(){
		return latest;
	}
}