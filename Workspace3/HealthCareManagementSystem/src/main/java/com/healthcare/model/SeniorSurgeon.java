package com.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="seniorsurgeon")
public class SeniorSurgeon extends Surgeon{

	//@Id
	private String specialzation_in;

	public String getSpecialzation_in() {
		return specialzation_in;
	}

	public void setSpecialzation_in(String specialzation_in) {
		this.specialzation_in = specialzation_in;
	}
	
}
