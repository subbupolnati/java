package com.employee_timesheet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp")
public class Otp {
	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String otp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Otp [id=" + id + ", email=" + email + ", otp=" + otp + "]";
	}
	public Otp(int id, String email, String otp) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
	}
	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
