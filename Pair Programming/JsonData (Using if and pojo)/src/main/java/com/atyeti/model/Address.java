package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("street")
	private String street;

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getZip(){
		return zip;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}
}