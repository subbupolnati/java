package com.user.model;

import java.util.List;

public class Response {

	 private User user;
	 private List<Posts> post;
	
	public List<Posts> getPost() {
		return post;
	}
	public void setPost(List<Posts> post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Response [user=" + user + ", post=" + post + "]";
	}
	
}
