package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location{

	@JsonProperty("country")
	private String country;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	public String getCountry(){
		return country;
	}

	public Address getAddress(){
		return address;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}
}