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

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}