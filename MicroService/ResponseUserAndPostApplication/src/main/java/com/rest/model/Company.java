package com.rest.model;
//This  Model class represents Company Data
public class Company {
	
	private String name;//This field will store name
	private String catchPhrase;//This field will store catch Phrase
	private String bs;//This field will store bs
	//No argument constructor
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	//argument constructor
	public Company(String name, String catchPhrase, String bs) {
		super();
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}
	//Getter and Setter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	//String
	@Override
	public String toString() {
		return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
	}
	
}
