package com.tweet.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="tweets")
public class Tweets {

	@Id
	private String username;
	private int tweet;
	private int followers;
	private int followings;
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private String image;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTweet() {
		return tweet;
	}
	public void setTweet(int tweet) {
		this.tweet = tweet;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowings() {
		return followings;
	}
	public void setFollowings(int followings) {
		this.followings = followings;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Tweets [username=" + username + ", tweet=" + tweet + ", followers=" + followers + ", followings="
				+ followings + ", image=" + image + "]";
	}
	public Tweets(String username, int tweet, int followers, int followings) {
		super();
		this.username = username;
		this.tweet = tweet;
		this.followers = followers;
		this.followings = followings;
	}
	public Tweets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
