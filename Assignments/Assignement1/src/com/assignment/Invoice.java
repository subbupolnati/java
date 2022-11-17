package com.assignment;
import java.util.Scanner;
public class Invoice {
	String part_Number;
	String part_description;
	int purchesed;
	double price;
	Scanner sc=new Scanner(System.in);
	public String getPart_Number() {
		return part_Number;
	}

	public void setPart_Number(String part_Number) {
		this.part_Number = part_Number;
	}

	public String getPart_description() {
		return part_description;
	}

	public void setPart_description(String part_description) {
		this.part_description = part_description;
	}

	public int getPurchesed() {
		return purchesed;
	}

	public void setPurchesed(int purchesed) {
		this.purchesed = purchesed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	public Invoice() {
		super();
		getDetails();
	}

	public Invoice(String part_Number, String part_description, int purchesed, double price) {
		super();
		this.part_Number = part_Number;
		this.part_description = part_description;
		this.purchesed = purchesed;
		this.price = price;
	}
	void getDetails()
	{
		System.out.println("Enter Part_number is : ");
		part_Number=sc.next();
		System.out.println("enter part_decription is :");
		part_description=sc.next();
		System.out.println("enter quaninty  is :");
		purchesed=sc.nextInt();
		System.out.println("enter price is :");
		price=sc.nextDouble();
	}
	public double getInvoiceAmount() {
		if(purchesed>0 && price>0) {
			price=purchesed*price;
			return price;
		}
		else {
			return 0.0;
		}
	}
	public int quntity() {
		if(purchesed>0) {
			return purchesed;
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Invoice in=new Invoice();
		System.out.println("part number is :"+in.getPart_Number());
		System.out.println("part_description is: "+in.getPart_description());
		System.out.println("quantinty is "+in.quntity());
		System.out.println("invoice is "+ in.getInvoiceAmount());
	}

}
