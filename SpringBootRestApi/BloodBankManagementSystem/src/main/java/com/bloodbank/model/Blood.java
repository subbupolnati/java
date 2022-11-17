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
@Table(name="blood")
public class Blood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bloodid")
	@SequenceGenerator(initialValue = 1,name="bloodid",allocationSize = 1)
	private int bloodid;
	private String bloodgroup;
	private String bloodtype;
	private String bloodbank;
	private String blooddescription;
	private String bloodcells;
	@OneToOne(cascade = CascadeType.ALL)
	private Donor donor;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getBloodid() {
		return bloodid;
	}
	public void setBloodid(int bloodid) {
		this.bloodid = bloodid;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getBloodbank() {
		return bloodbank;
	}
	public void setBloodbank(String bloodbank) {
		this.bloodbank = bloodbank;
	}
	public String getBlooddescription() {
		return blooddescription;
	}
	public void setBlooddescription(String blooddescription) {
		this.blooddescription = blooddescription;
	}
	public String getBloodcells() {
		return bloodcells;
	}
	public void setBloodcells(String bloodcells) {
		this.bloodcells = bloodcells;
	}
	
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Blood [bloodid=" + bloodid + ", bloodgroup=" + bloodgroup + ", bloodtype=" + bloodtype + ", bloodbank="
				+ bloodbank + ", blooddescription=" + blooddescription + ", bloodcells=" + bloodcells + ", donor="
				+ donor + "]";
	}
	public Blood() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blood(int bloodid, String bloodgroup, String bloodtype, String bloodbank, String blooddescription,
			String bloodcells, Donor donor, Permission permission) {
		super();
		this.bloodid = bloodid;
		this.bloodgroup = bloodgroup;
		this.bloodtype = bloodtype;
		this.bloodbank = bloodbank;
		this.blooddescription = blooddescription;
		this.bloodcells = bloodcells;
		this.donor = donor;
		this.permission = permission;
	}
}
