package com.tweet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts1")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int postId;
	private String posts;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPosts() {
		return posts;
	}

	public void setPosts(String posts) {
		this.posts = posts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", posts=" + posts + ", user=" + user + "]";
	}

	public Posts(int postId, String posts, User user) {
		super();
		this.postId = postId;
		this.posts = posts;
		this.user = user;
	}

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
