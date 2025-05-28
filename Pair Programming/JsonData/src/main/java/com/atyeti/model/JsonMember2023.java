package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonMember2023{

	@JsonProperty("Q1")
	private Object q1;

	@JsonProperty("Q2")
	private Object q2;

	@JsonProperty("Q3")
	private Object q3;

	@JsonProperty("Q4")
	private Object q4;

	public Object getQ1(){
		return q1;
	}

	public Object getQ2(){
		return q2;
	}

	public Object getQ3(){
		return q3;
	}

	public Object getQ4(){
		return q4;
	}
}