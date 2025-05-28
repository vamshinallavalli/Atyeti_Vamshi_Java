package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SOC2{

	@JsonProperty("type2")
	private boolean type2;

	@JsonProperty("type1")
	private boolean type1;

	public boolean isType2(){
		return type2;
	}

	public boolean isType1(){
		return type1;
	}
}