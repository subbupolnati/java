package com.book;
import java.util.Scanner;
public class Book {
	static String book_Name;
	static String isbn_Number;
	static String author_Name;
	static String publisher;
	String BookTest[]=new String[5];
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getIsbn_Number() {
		return isbn_Number;
	}
	public void setIsbn_Number(String isbn_Number) {
		this.isbn_Number = isbn_Number;
	}
	public String getAuthor_Name() {
		return author_Name;
	}
	public void setAuthor_Name(String author_Name) {
		this.author_Name = author_Name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book(String book_Name, String isbn_Number, String author_Name, String publisher)
	{
		super();
		this.book_Name = book_Name;
		this.isbn_Number = isbn_Number;
		this.author_Name = author_Name;
		this.publisher = publisher;
	}
	public String getBookInfo()
	{
	return "Book_name:  "+book_Name+"\nISBN NUmber: "+isbn_Number+"\nAuthor_name: "+author_Name+"\nPublisher: "+publisher+"";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Book b[] =new Book[1];
		for(int i=0;i<b.length;i++) {
			System.out.println("enter book_name");
			String book_Name=sc.next();
			System.out.println("enter isbn_number");
			String isbn_Number=sc.next();
			System.out.println("enter Author_name");
			String author_Name=sc.next();
			System.out.println("enter Publisher");
			String publisher=sc.next();
			b[i]=new Book(book_Name,isbn_Number,author_Name,publisher);
			}
		for(int i=0;i<b.length;i++) {
			System.out.println(""+b[i].getBookInfo());
			System.out.println("_______________________");
		}
		/*b.getBook_Name();
		b.getIsbn_Number();
		b.getAuthor_Name();
		b.getPublisher();
		
		System.out.println("_______________________");
		System.out.println("printing BookInfo");
		System.out.println("Book inf0:"+b.getBookInfo());
		*/
	}

}
