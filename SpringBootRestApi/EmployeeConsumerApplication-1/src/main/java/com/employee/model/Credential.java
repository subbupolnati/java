package com.employee.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//This pojo class store Credential data 
public class Credential {

	@NotNull
	@Size(min =5,message = " Username Should be  5 Characters and more ")
	private String userName;//This field should be store username
	private String password;//This field should be store password
	private String role;
	//Getter and Setter methods
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//to String
	@Override
	public String toString() {
		return "Credential [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
