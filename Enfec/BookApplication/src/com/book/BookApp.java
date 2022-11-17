package com.book;
class Author
{
	int author_id;
	String author_name;
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Author(int author_id, String author_name) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
	}
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_name=" + author_name + "]";
	}
	
}
class Book1
{
	int book_id;
	String book_name;
	int price;
	Author auth;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}
	public Book1(int book_id, String book_name, int price, Author auth) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.price = price;
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", price=" + price + ", auth=" + auth + "]";
	}
	public boolean add(Book1 book) {
		return true;
	}
}
public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Author a=new Author(201,"james");
		Book1 b=new Book1(256,"java",500,a);
		System.out.println(b);
	}

}
