package com.football.model;

import java.util.Arrays;

public class FootBall{
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private Matches data[];
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public Matches[] getData() {
		return data;
	}
	public void setData(Matches[] data) {
		this.data = data;
	}
	public FootBall(int page, int per_page, int total, int total_pages, Matches[] data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}
	public FootBall() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodBallResponse [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", data=" + Arrays.toString(data) + "]";
	}
	
}
