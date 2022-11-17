package com.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="nurses")
public class Nurses {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nurseid")
	@SequenceGenerator(initialValue = 1,name="nurseid",allocationSize = 1)
	private int nurseid;
	private String name;
	
	public int getNurseid() {
		return nurseid;
	}
	public void setNurseid(int nurseid) {
		this.nurseid = nurseid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
