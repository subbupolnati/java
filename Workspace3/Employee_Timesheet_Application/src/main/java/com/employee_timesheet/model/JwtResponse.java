package com.employee_timesheet.model;
//This JwtResponse model class encapsulated token details
public class JwtResponse {
	private String token;//This field store token details
	//setter and getter methods
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	//toString method
	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}
	//argument constructor
	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	//No argument constructor
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
