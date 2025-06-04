package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Announcements{

	@JsonProperty("next")
	private String next;

	@JsonProperty("latest")
	private String latest;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setLatest(String latest){
		this.latest = latest;
	}

	public String getLatest(){
		return latest;
	}
}