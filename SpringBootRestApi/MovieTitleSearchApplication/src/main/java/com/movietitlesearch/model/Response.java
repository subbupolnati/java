package com.movietitlesearch.model;

public class Response {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Response [title=" + title + "]";
	}
	
}
