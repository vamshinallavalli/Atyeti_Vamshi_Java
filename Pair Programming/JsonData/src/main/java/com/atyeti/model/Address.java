package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("street")
	private String street;

	public String getZip(){
		return zip;
	}

	public String getStreet(){
		return street;
	}
}