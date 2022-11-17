package com.userandpost.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//This model Class encapuslated users data
@Entity
@Table(name="users")//table name
public class Users {

	@Id//primary key
	private int id;//This field stores user id
	private String name;//This field stores user name
	private String username;//this field stores users username
	private String email;//this field stores user email
	@OneToOne(cascade = CascadeType.ALL)//One to one relatioship established
	private Address address;//this field stores user address
	private String phone;//this field stores user phone number
	private String website;//this filed stores user website details
	@OneToOne(cascade = CascadeType.ALL)//One to one relatiship established
	private Company company;//This field stores comapny details
	//getter and setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
}
