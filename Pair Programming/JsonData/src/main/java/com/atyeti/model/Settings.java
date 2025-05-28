package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Settings{

	@JsonProperty("theme")
	private String theme;

	@JsonProperty("notifications")
	private Notifications notifications;

	public String getTheme(){
		return theme;
	}

	public Notifications getNotifications(){
		return notifications;
	}
}