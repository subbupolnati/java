package com.product.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id")
	//@SequenceGenerator(initialValue = 1,name="product_id",allocationSize = 1)
	private int product_id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id",referencedColumnName = "category_id")
	private Category category;
	private int availabel_quntity;
	private int price;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getAvailabel_quntity() {
		return availabel_quntity;
	}
	public void setAvailabel_quntity(int availabel_quntity) {
		this.availabel_quntity = availabel_quntity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", category=" + category
				+ ", availabel_quntity=" + availabel_quntity + ", price=" + price + "]";
	}
	
	
}
