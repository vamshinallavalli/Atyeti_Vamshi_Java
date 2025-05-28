package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cloud{

	@JsonProperty("provider")
	private String provider;

	@JsonProperty("services")
	private List<String> services;

	public String getProvider(){
		return provider;
	}

	public List<String> getServices(){
		return services;
	}
}