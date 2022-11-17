package com.inventory.model;

public class User {

	private String username;
	private String password;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userrole=" + userrole + "]";
	}
	
	
}
