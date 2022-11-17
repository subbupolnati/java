package com.rest.model;

//This class create posts pojo class or model class
public class Posts {

	private int id;//this filed will store postId
	private String title;//this field will store title 
	private String body;//this field will store body;
	private int userId;//This field will store userId
	
	//creating getter and setter methods 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//This is no-argment constructor
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	//this is argument constructor
	public Posts(int id, String title, String body, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.userId = userId;
	}
	//This is toString method
	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + "]";
	}
	
	
}
