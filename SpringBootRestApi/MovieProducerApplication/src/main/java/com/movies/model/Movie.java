package com.movies.model;


public class Movie {
	
	private String title;
	private int year;
	private String imdbID;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public Movie(String title, int year, String imdbID) {
		super();
		this.title = title;
		this.year = year;
		this.imdbID = imdbID;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", year=" + year + ", imdbID=" + imdbID + "]";
	}
	
}
