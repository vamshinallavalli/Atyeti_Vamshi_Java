package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartnershipsItem{

	@JsonProperty("partner")
	private String partner;

	@JsonProperty("startYear")
	private int startYear;

	@JsonProperty("active")
	private boolean active;

	public String getPartner(){
		return partner;
	}

	public int getStartYear(){
		return startYear;
	}

	public boolean isActive(){
		return active;
	}
}