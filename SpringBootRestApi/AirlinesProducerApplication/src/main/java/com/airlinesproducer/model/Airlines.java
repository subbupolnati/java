package com.airlinesproducer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//This Airlines Pojo class is used to airline data store and retrive
@Entity
@Table(name="airlines")//table name
public class Airlines {

	@Id//primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id")
	@SequenceGenerator(initialValue = 1,name="id",allocationSize = 1)
	private int id;//This field will store airlineId
	private String name;//This field will store airline name
	private String country;//This field will store airline name
	private String logo;//This field will store logo
	private String slogan;//This field will store slogan
	private String head_quaters;//This field will store head_quaters name
	private String website;//This field will store airline webSite 
	private String established;//This field will store airline established year
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "airline")
	//@JsonManagedReference
	@JsonIgnore
	List<Passenger> passenger;
	
	//Getter and setter methods
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	@Override
	public String toString() {
		return "Airlines [id=" + id + ", name=" + name + ", country=" + country + ", logo=" + logo + ", slogan="
				+ slogan + ", head_quaters=" + head_quaters + ", website=" + website + ", established=" + established
				+ ", passenger=" + passenger + "]";
	}
	public Airlines() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airlines(int id, String name, String country, String logo, String slogan, String head_quaters,
			String website, String established, List<Passenger> passenger) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.logo = logo;
		this.slogan = slogan;
		this.head_quaters = head_quaters;
		this.website = website;
		this.established = established;
		this.passenger = passenger;
	}
	public Airlines(int id, String name, String country, String logo, String slogan, String head_quaters,
			String website, String established) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.logo = logo;
		this.slogan = slogan;
		this.head_quaters = head_quaters;
		this.website = website;
		this.established = established;
	}
	
	
}
