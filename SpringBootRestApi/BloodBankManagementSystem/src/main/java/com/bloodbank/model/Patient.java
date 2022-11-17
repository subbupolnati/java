package com.bloodbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patientid")
	@SequenceGenerator(initialValue = 1,name="patientid",allocationSize = 1)
	private int patientid;
	private String patientname;
	private String patientmobile;
	private String patientaddress;
	private String patientemail;
	private String patientusername;
	private String patientpassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientmobile() {
		return patientmobile;
	}
	public void setPatientmobile(String patientmobile) {
		this.patientmobile = patientmobile;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public String getPatientemail() {
		return patientemail;
	}
	public void setPatientemail(String patientemail) {
		this.patientemail = patientemail;
	}
	public String getPatientusername() {
		return patientusername;
	}
	public void setPatientusername(String patientusername) {
		this.patientusername = patientusername;
	}
	public String getPatientpassword() {
		return patientpassword;
	}
	public void setPatientpassword(String patientpassword) {
		this.patientpassword = patientpassword;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", patientname=" + patientname + ", patientmobile=" + patientmobile
				+ ", patientaddress=" + patientaddress + ", patientemail=" + patientemail + ", patientusername="
				+ patientusername +"]";
	}
	public Patient(int patientid, String patientname, String patientmobile, String patientaddress, String patientemail,
			String patientusername, String patientpassword, Permission permission) {
		super();
		this.patientid = patientid;
		this.patientname = patientname;
		this.patientmobile = patientmobile;
		this.patientaddress = patientaddress;
		this.patientemail = patientemail;
		this.patientusername = patientusername;
		this.patientpassword = patientpassword;
		this.permission = permission;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
