package com.shoppingmall.produts;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mallmanagement.customer.Customer;
//create class products
public class Products {
	Customer cust;//customer class inherit has_A type relation
  private String pname;
  private int qty;
  private int price;
  private int totalPrice;
//create constructor with arguments
  public Products(Customer cust, String pname, int qty, int price, int totalPrice) {
	super();
	this.cust = cust;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
	this.totalPrice = totalPrice;
	
}
public Products() {

}
//ToString method
  @Override
public String toString() {
	return "Products [cust=" + cust + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", totalPrice="
			+ totalPrice + "]";
}
  public Customer getCust() {
	return cust;
}
public void setCust(Customer cust) {
	this.cust = cust;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public int totalPrice(int qty,int totalPrice) {
	totalPrice=price*qty;
	return totalPrice;
}
public void display() {
	System.out.println("**********************printing bill Payment recepit**********************");
	System.out.println("customer details :"+getCust().getCustomerName()+"\n mobile number: "+getCust().getMobileno());
    System.out.println("productname :"+pname);
    System.out.println("product_quality :"+qty);
    System.out.println("product_price :"+price);
    System.out.println("product Total Price :"+totalPrice);
  }
}

