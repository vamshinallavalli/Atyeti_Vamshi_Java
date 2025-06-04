package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Push{

	@JsonProperty("enabled")
	private boolean enabled;

	@JsonProperty("frequency")
	private String frequency;

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setFrequency(String frequency){
		this.frequency = frequency;
	}

	public String getFrequency(){
		return frequency;
	}
}