package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stack{

	@JsonProperty("database")
	private String database;

	@JsonProperty("backend")
	private String backend;

	@JsonProperty("frontend")
	private String frontend;

	public void setDatabase(String database){
		this.database = database;
	}

	public String getDatabase(){
		return database;
	}

	public void setBackend(String backend){
		this.backend = backend;
	}

	public String getBackend(){
		return backend;
	}

	public void setFrontend(String frontend){
		this.frontend = frontend;
	}

	public String getFrontend(){
		return frontend;
	}
}