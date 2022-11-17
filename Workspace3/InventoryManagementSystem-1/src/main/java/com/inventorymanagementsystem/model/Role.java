package com.inventorymanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roleid")
	@SequenceGenerator(initialValue = 1,name="roleid",allocationSize = 1)
	private int roleid;
	private String roletitle;
	private String description;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRoletitle() {
		return roletitle;
	}
	public void setRoletitle(String roletitle) {
		this.roletitle = roletitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", roletitle=" + roletitle + ", description=" + description + "]";
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int roleid, String roletitle, String description, Permission permission) {
		super();
		this.roleid = roleid;
		this.roletitle = roletitle;
		this.description = description;
	}
	
}
