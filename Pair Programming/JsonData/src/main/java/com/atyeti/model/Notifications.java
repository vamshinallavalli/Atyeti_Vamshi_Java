package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Notifications{

	@JsonProperty("sms")
	private boolean sms;

	@JsonProperty("email")
	private boolean email;

	@JsonProperty("push")
	private Push push;

	public void setSms(boolean sms){
		this.sms = sms;
	}

	public boolean isSms(){
		return sms;
	}

	public void setEmail(boolean email){
		this.email = email;
	}

	public boolean isEmail(){
		return email;
	}

	public void setPush(Push push){
		this.push = push;
	}

	public Push getPush(){
		return push;
	}
}