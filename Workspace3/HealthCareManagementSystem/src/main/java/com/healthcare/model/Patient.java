package com.healthcare.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="patientTable")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patientid")
	@SequenceGenerator(initialValue = 1,name="patientid",allocationSize = 1)
	private int patientid;
	private String name;
	private String type_of_treatment;
	@OneToOne(cascade = CascadeType.ALL)
	private Ward ward_no;
	
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_of_treatment() {
		return type_of_treatment;
	}
	public void setType_of_treatment(String type_of_treatment) {
		this.type_of_treatment = type_of_treatment;
	}
	public Ward getWard_no() {
		return ward_no;
	}
	public void setWard_no(Ward ward_no) {
		this.ward_no = ward_no;
	}
	
}
