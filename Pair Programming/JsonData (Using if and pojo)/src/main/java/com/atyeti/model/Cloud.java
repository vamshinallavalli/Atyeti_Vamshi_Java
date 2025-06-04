package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cloud{

	@JsonProperty("provider")
	private String provider;

	@JsonProperty("services")
	private List<String> services;

	public void setProvider(String provider){
		this.provider = provider;
	}

	public String getProvider(){
		return provider;
	}

	public void setServices(List<String> services){
		this.services = services;
	}

	public List<String> getServices(){
		return services;
	}
}