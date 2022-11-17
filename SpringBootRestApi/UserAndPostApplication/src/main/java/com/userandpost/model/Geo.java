package com.userandpost.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//This Model class encapuslates Geo data
@Entity
@Table(name="geo")//Table name
public class Geo {
	@Id//primary key
	private String lat;//This field stores latitude
	private String lng;//This field stored langtitude
	//Getter and setter methods
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
	
}
