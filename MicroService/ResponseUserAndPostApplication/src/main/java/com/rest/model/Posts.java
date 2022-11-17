package com.rest.model;
//This Posts Model Class represents Posts Data 
public class Posts {

	private int userId;//This field will store userId
	private int id;//This field will store postId
	private String title;//This field will store postTitle
	private String body;//This field will store Post body
	//No-argument constructor or default constructor
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Argument constructor
	public Posts(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	//Getter and Setter methods
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
	//to string method
	@Override
	public String toString() {
		return "Posts [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
}
