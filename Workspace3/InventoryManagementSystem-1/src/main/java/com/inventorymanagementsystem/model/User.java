package com.inventorymanagementsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userid")
	@SequenceGenerator(initialValue = 1,name="userid",allocationSize = 1)
	private int userid;
	private String username;
	private String useremail;
	private String useraddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Role userrole;
	@OneToOne(cascade = CascadeType.ALL)
	private Permission permission;
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public Role getUserrole() {
		return userrole;
	}
	public void setUserrole(Role userrole) {
		this.userrole = userrole;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", useraddress=" + useraddress + ", userrole=" + userrole + "]";
	}
	public User(int userid, String username, String useremail, String useraddress, Role userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.useraddress = useraddress;
		this.userrole = userrole;
	}
	
	
}
