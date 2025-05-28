package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notifications{

	@JsonProperty("sms")
	private boolean sms;

	@JsonProperty("email")
	private boolean email;

	@JsonProperty("push")
	private Push push;

	public boolean isSms(){
		return sms;
	}

	public boolean isEmail(){
		return email;
	}

	public Push getPush(){
		return push;
	}
}