package com.book;
class Book
{
	int id;
	String Name;
	int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book(int id, String name, int price) {
		super();
		this.id = id;
		Name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", Name=" + Name + ", price=" + price + "]";
	}
}
public class TestBookApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b= new Book(100,"java",500);
		System.out.println(b);
	}

}
