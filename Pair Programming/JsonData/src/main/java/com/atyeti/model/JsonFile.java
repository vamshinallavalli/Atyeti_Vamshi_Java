package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonFile{

	@JsonProperty("settings")
	private Settings settings;

	@JsonProperty("country")
	private String country;

	@JsonProperty("projects")
	private List<ProjectsItem> projects;

	@JsonProperty("founded")
	private int founded;

	@JsonProperty("active")
	private boolean active;

	@JsonProperty("services")
	private String services;

	@JsonProperty("technologies")
	private Technologies technologies;

	@JsonProperty("feedback")
	private Feedback feedback;

	@JsonProperty("partnerships")
	private List<PartnershipsItem> partnerships;

	@JsonProperty("compliance")
	private Compliance compliance;

	@JsonProperty("company")
	private String company;

	@JsonProperty("location")
	private Location location;

	@JsonProperty("departments")
	private List<DepartmentsItem> departments;

	@JsonProperty("announcements")
	private Announcements announcements;

	public Settings getSettings(){
		return settings;
	}

	public String getCountry(){
		return country;
	}

	public List<ProjectsItem> getProjects(){
		return projects;
	}

	public int getFounded(){
		return founded;
	}

	public boolean isActive(){
		return active;
	}

	public String getServices(){
		return services;
	}

	public Technologies getTechnologies(){
		return technologies;
	}

	public Feedback getFeedback(){
		return feedback;
	}

	public List<PartnershipsItem> getPartnerships(){
		return partnerships;
	}

	public Compliance getCompliance(){
		return compliance;
	}

	public String getCompany(){
		return company;
	}

	public Location getLocation(){
		return location;
	}

	public List<DepartmentsItem> getDepartments(){
		return departments;
	}

	public Announcements getAnnouncements(){
		return announcements;
	}
}