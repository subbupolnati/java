package com.product;

import java.io.File;

public class Product {
	private int Product_id;
	private String product_name;
	private int product_category_id;
	private int availble_qunatity;
	private double product_price;
	private String image;
	public int getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	public int getAvailble_qunatity() {
		return availble_qunatity;
	}
	public void setAvailble_qunatity(int availble_qunatity) {
		this.availble_qunatity = availble_qunatity;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
