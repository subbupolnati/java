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
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "roleid")
	@SequenceGenerator(initialValue = 1,name="roleid",allocationSize = 1)
	private int roleid;
	private String roletitle;
	private String description;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
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
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", roletitle=" + roletitle + ", description=" + description + ", permission="
				+ permission + "]";
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
		this.permission = permission;
	}
	
}
