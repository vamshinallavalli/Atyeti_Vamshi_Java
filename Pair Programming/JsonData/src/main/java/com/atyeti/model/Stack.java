package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stack{

	@JsonProperty("database")
	private String database;

	@JsonProperty("backend")
	private String backend;

	@JsonProperty("frontend")
	private String frontend;

	public String getDatabase(){
		return database;
	}

	public String getBackend(){
		return backend;
	}

	public String getFrontend(){
		return frontend;
	}
}