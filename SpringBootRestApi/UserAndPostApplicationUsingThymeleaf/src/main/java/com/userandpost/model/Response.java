package com.userandpost.model;

public class Response {

	private int userId;
	private String name;
	private int postcount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPostcount() {
		return postcount;
	}
	public void setPostcount(int postcount) {
		this.postcount = postcount;
	}
	public Response(int userId, String name, int postcount) {
		super();
		this.userId = userId;
		this.name = name;
		this.postcount = postcount;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Response [userId=" + userId + ", name=" + name + ", postcount=" + postcount + "]";
	}
	
}
