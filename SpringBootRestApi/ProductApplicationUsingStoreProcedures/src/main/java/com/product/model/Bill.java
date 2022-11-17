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
@Table(name="bill")
public class Bill {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bill_no")
	//@SequenceGenerator(initialValue = 1,name="bill_no",allocationSize = 1)
	private int bill_no;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid")
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	private int selected_quantity;
	private int amount;
	public int getBill_no() {
		return bill_no;
	}
	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSelected_quantity() {
		return selected_quantity;
	}
	public void setSelected_quantity(int selected_quantity) {
		this.selected_quantity = selected_quantity;
	}
	public int getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "Bill [bill_no=" + bill_no + ", user=" + user + ", product=" + product + ", selected_quantity="
				+ selected_quantity + ", amount=" + amount + "]";
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
