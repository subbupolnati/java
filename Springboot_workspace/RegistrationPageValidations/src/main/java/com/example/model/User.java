package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="user1")
public class User {
	@NotNull(message="please enter username")
	@Size(min = 8,message = "User name Should be  8 Characters and more ")
	//@Pattern(regexp = "^[a-zA-Z]{3,}$",message = "User name Should be  8 Characters and more ")
	@Id
	private String username;
	
	@Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\\\d]){1,})(?=(.*[\\\\W]){1,})(?!.*\\\\s).{8,}$",
			message="password minimum length 8 characters \\n atleast 1 upper case\\n 1 lowercase \\n 1 digit \\n 1 special character")
	@Column
	private String password;
	@Column
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="should have a valid Email id")
	private String email;
	@NotNull(message="please select gender")
	@Column
	private String Gender;
	@NotNull(message="please enter qualification")
	@Column
	private String qualification;
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}",message="mobile number should be of 10 numbers")
	@Column
	private String mobilenumber;
	@Min(value=18,message="age should be less than 18years")
	@Max(value=80,message="age should be greater than 80 years")
	@Column
	private int age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
