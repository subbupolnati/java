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
@Table(name="donor")
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "donorid")
	@SequenceGenerator(initialValue = 1,name="donorid",allocationSize = 1)
	private int donorid;
	private String donorname;
	private String donormobile;
	private String donoremail;
	private String donoraddress;
	private String donorusername;
	private String donorpassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public int getDonorid() {
		return donorid;
	}
	public void setDonorid(int donorid) {
		this.donorid = donorid;
	}
	public String getDonorname() {
		return donorname;
	}
	public void setDonorname(String donorname) {
		this.donorname = donorname;
	}
	public String getDonormobile() {
		return donormobile;
	}
	public void setDonormobile(String donormobile) {
		this.donormobile = donormobile;
	}
	public String getDonoremail() {
		return donoremail;
	}
	public void setDonoremail(String donoremail) {
		this.donoremail = donoremail;
	}
	public String getDonoraddress() {
		return donoraddress;
	}
	public void setDonoraddress(String donoraddress) {
		this.donoraddress = donoraddress;
	}
	public String getDonorusername() {
		return donorusername;
	}
	public void setDonorusername(String donorusername) {
		this.donorusername = donorusername;
	}
	public String getDonorpassword() {
		return donorpassword;
	}
	public void setDonorpassword(String donorpassword) {
		this.donorpassword = donorpassword;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Donor [donorid=" + donorid + ", donorname=" + donorname + ", donormobile=" + donormobile
				+ ", donoremail=" + donoremail + ", donoraddress=" + donoraddress + ", donorusername=" + donorusername+"]";
	}
	public Donor(int donorid, String donorname, String donormobile, String donoremail, String donoraddress,
			String donorusername, String donorpassword, Permission permission) {
		super();
		this.donorid = donorid;
		this.donorname = donorname;
		this.donormobile = donormobile;
		this.donoremail = donoremail;
		this.donoraddress = donoraddress;
		this.donorusername = donorusername;
		this.donorpassword = donorpassword;
		this.permission = permission;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
