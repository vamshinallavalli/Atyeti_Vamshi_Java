package com.atyeti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Settings{

	@JsonProperty("theme")
	private String theme;

	@JsonProperty("notifications")
	private Notifications notifications;

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return theme;
	}

	public void setNotifications(Notifications notifications){
		this.notifications = notifications;
	}

	public Notifications getNotifications(){
		return notifications;
	}
}