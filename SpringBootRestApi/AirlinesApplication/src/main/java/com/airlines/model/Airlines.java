package com.airlines.model;

import java.util.List;

public class Airlines {

	private int id;
	private String name;
	private String country;
	private String logo;
	private String slogan;
	private String head_quaters;
	private String website;
	private String established;
	private List<Passenger> passenger;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getHead_quaters() {
		return head_quaters;
	}
	public void setHead_quaters(String head_quaters) {
		this.head_quaters = head_quaters;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEstablished() {
		return established;
	}
	public void setEstablished(String established) {
		this.established = established;
	}
	@Override
	public String toString() {
		return "Airlines [id=" + id + ", name=" + name + ", country=" + country + ", logo=" + logo + ", slogan="
				+ slogan + ", head_quaters=" + head_quaters + ", website=" + website + ", established=" + established
				+ ", passenger=" + passenger + "]";
	}
	
	
}
