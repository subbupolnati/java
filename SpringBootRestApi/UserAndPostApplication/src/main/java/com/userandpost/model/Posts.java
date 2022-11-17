package com.userandpost.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//This Model class encapuslates posts data
@Entity
@Table(name="posts")
public class Posts {
	
	@Id//primary key
	private int id;//This field stores posts id
	private String title;//This field stores posts title.
	private String body;//This field stores post body
	private int userId; //This field stores userid
	
	//Getter and setter methods
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", body=" + body + ", userId=" + userId + "]";
	}
	
}
