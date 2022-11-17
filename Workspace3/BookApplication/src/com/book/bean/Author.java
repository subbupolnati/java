package com.book.bean;

public class Author {
	String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Author [author=" + author + "]";
	}
}
