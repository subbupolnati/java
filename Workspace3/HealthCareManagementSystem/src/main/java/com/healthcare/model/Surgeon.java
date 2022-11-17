package com.healthcare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="surgeon")
public class Surgeon  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "surgeonid")
	@SequenceGenerator(initialValue = 1,name="surgeonid",allocationSize = 1)
	private int surgeonid;
	private String name;
	private String designation;
	
	public int getSurgeonid() {
		return surgeonid;
	}
	public void setSurgeonid(int surgeonid) {
		this.surgeonid = surgeonid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
