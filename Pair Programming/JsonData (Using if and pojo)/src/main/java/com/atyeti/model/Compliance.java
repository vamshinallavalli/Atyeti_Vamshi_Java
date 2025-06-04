package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Compliance{

	@JsonProperty("ISO27001")
	private boolean iSO27001;

	@JsonProperty("SOC2")
	private SOC2 sOC2;

	public void setISO27001(boolean iSO27001){
		this.iSO27001 = iSO27001;
	}

	public boolean isISO27001(){
		return iSO27001;
	}

	public void setSOC2(SOC2 sOC2){
		this.sOC2 = sOC2;
	}

	public SOC2 getSOC2(){
		return sOC2;
	}
}