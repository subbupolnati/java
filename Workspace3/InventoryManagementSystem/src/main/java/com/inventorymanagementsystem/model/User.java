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

	
	@Id
	private String username;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Role userrole;	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Role getUserrole() {
		return userrole;
	}
	public void setUserrole(Role userrole) {
		this.userrole = userrole;
	}
	
	public User(String username, String password, Role userrole) {
		super();
		this.username = username;
		this.password = password;
		this.userrole = userrole;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
