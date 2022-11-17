package com.sample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee2")
public class Employee {
	
	@Id
	@Min(value=5,message="empid min 5 characters")
	private int empid;
	@Size(min = 5,message = " username Should be  5 Characters and more ")
	private String username;
	private String fullname;
	private String address;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="should have a valid Email id")
	private String email;
	@Min(value = 5,message = "Salary Should be Minimum 5 digits")
	private int salary;
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}",message="mobile number should be of 10 numbers")
	private String mobile;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Credential credential;
	
	public Credential getCredential() {
		return credential;
	}
	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
