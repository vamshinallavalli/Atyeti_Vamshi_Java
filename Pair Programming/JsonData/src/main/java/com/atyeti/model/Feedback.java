package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback{

	@JsonProperty("2024")
	private JsonMember2024 jsonMember2024;

	@JsonProperty("2023")
	private JsonMember2023 jsonMember2023;

	public void setJsonMember2024(JsonMember2024 jsonMember2024){
		this.jsonMember2024 = jsonMember2024;
	}

	public JsonMember2024 getJsonMember2024(){
		return jsonMember2024;
	}

	public void setJsonMember2023(JsonMember2023 jsonMember2023){
		this.jsonMember2023 = jsonMember2023;
	}

	public JsonMember2023 getJsonMember2023(){
		return jsonMember2023;
	}
}