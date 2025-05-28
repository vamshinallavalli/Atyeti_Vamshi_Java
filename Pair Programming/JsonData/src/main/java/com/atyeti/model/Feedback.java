package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback{

	@JsonProperty("2024")
	private JsonMember2024 jsonMember2024;

	@JsonProperty("2023")
	private JsonMember2023 jsonMember2023;

	public JsonMember2024 getJsonMember2024(){
		return jsonMember2024;
	}

	public JsonMember2023 getJsonMember2023(){
		return jsonMember2023;
	}
}