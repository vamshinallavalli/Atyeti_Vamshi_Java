package com.atyeti.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "company", "location", "departments"})
public class Root{

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

	@JsonProperty("CEO")
	private String cEO;

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

	public void setSettings(Settings settings){
		this.settings = settings;
	}

	public Settings getSettings(){
		return settings;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setProjects(List<ProjectsItem> projects){
		this.projects = projects;
	}

	public List<ProjectsItem> getProjects(){
		return projects;
	}

	public void setFounded(int founded){
		this.founded = founded;
	}

	public int getFounded(){
		return founded;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setServices(String services){
		this.services = services;
	}

	public String getServices(){
		return services;
	}

	public void setCEO(String cEO){
		this.cEO = cEO;
	}

	public String getCEO(){
		return cEO;
	}

	public void setTechnologies(Technologies technologies){
		this.technologies = technologies;
	}

	public Technologies getTechnologies(){
		return technologies;
	}

	public void setFeedback(Feedback feedback){
		this.feedback = feedback;
	}

	public Feedback getFeedback(){
		return feedback;
	}

	public void setPartnerships(List<PartnershipsItem> partnerships){
		this.partnerships = partnerships;
	}

	public List<PartnershipsItem> getPartnerships(){
		return partnerships;
	}

	public void setCompliance(Compliance compliance){
		this.compliance = compliance;
	}

	public Compliance getCompliance(){
		return compliance;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setDepartments(List<DepartmentsItem> departments){
		this.departments = departments;
	}

	public List<DepartmentsItem> getDepartments(){
		return departments;
	}

	public void setAnnouncements(Announcements announcements){
		this.announcements = announcements;
	}

	public Announcements getAnnouncements(){
		return announcements;
	}
}