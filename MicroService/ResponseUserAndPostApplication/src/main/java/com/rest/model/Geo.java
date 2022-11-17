package com.rest.model;
//This Geo Model class represents Geo Data
public class Geo {
	
	private String lat;//This field will store latitude
	private String lng;//This field will store langatitude
	//No argument constructor
	public Geo() {
		super();
		// TODO Auto-generated constructor stub
	}
	//argument constructor
	public Geo(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	//Getter and setter
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	//to string
	@Override
	public String toString() {
		return "Geo [lat=" + lat + ", lng=" + lng + "]";
	}
	

}
