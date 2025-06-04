package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SOC2{

	@JsonProperty("type2")
	private boolean type2;

	@JsonProperty("type1")
	private boolean type1;

	public void setType2(boolean type2){
		this.type2 = type2;
	}

	public boolean isType2(){
		return type2;
	}

	public void setType1(boolean type1){
		this.type1 = type1;
	}

	public boolean isType1(){
		return type1;
	}
}