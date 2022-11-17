package com.product;

public class Cart extends Product {
	@Override
	public String toString() {
		return "Cart [quantity=" + quantity + ", total=" + total + ", email=" + email + "]";
	}

	private int quantity;
	private float total;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
