package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Push{

	@JsonProperty("enabled")
	private boolean enabled;

	@JsonProperty("frequency")
	private String frequency;

	public boolean isEnabled(){
		return enabled;
	}

	public String getFrequency(){
		return frequency;
	}
}