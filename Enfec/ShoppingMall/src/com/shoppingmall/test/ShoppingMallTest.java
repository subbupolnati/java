package com.shoppingmall.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mallmanagement.customer.Customer;
import com.shoppingmall.ShoppingMall;
import com.shoppingmall.produts.Movies;
import com.shoppingmall.produts.Products;
import com.shoppingmall.produts.shopes.ClothShop;
import com.shoppingmall.produts.shopes.FurintureShop;
import com.shoppingmall.produts.shopes.MobileStore;
import com.shoppingmall.produts.shopes.MovieTheater;

class ShoppingMallTest {
	ShoppingMall s;
	 Products p=Mockito.mock(Products.class);
	 Movies m=Mockito.mock(Movies.class);
	 Customer cust=Mockito.mock(Customer.class);
	@BeforeEach
	void setUp() throws Exception {
		
		 cust=new Customer(10,"subbu",99519);
		ClothShop c=Mockito.mock(ClothShop.class);
		
	}

	@Test
	void test1() {
		assertNotNull(cust.getCustomerName(),"subbu");
		System.out.println("Test case1 passed ");
	}
	@Test
	void test2() {
		assertTrue(cust.customerID==10);
		System.out.println("Test case2 passed ");
	}
	@Test
	void test3() {
		assertNotEquals(cust.getCustomerName(),99519);
		System.out.println("Test case3 passed ");
	}

	@Test
	void test4() {
		assertNotNull(cust.mobileno);
		System.out.println("Test case4 passed ");
	}
	@Test
	void test5() {
		assertEquals(cust.getCustomerID(),10);
		System.out.println("Test case5 passed ");
	}
	@Test
	void test6() {
		assertNull(p.getPname());
		System.out.println("Test case6 passed ");
	}
	@Test
	void test7() {
		ArrayList<Customer> al=Mockito.spy(ArrayList.class);
		al.add(new Customer(10,"subbu",9951933));
		al.add(new Customer(2,"veera",897897));
		System.out.println("size is"+al.size());
		assertEquals(2,al.size());
		System.out.println("Test case7 passed ");
	}
	@Test
	void test8() {
		when(p.totalPrice(2, 400)).thenReturn(800);
		assertEquals(800, p.totalPrice(2, 400));
		System.out.println("Test case8 passed ");
		
	}
	@Test
	void test9() {
		when(p.totalPrice(1,350)).thenReturn(700);
		assertEquals(700, p.totalPrice(1,350));
		verify(p,times(1)).totalPrice(anyInt(),anyInt());
		System.out.println("Test case9 passed ");
	}
	@Test
	void test10() {
		doReturn(400).when(p).totalPrice(1,400);
		assertEquals(400,p.totalPrice(1,400));
		System.out.println("Test case10 passed ");
	}
	@Test
	void test11() {
		when(p.totalPrice(2, 400)).thenReturn(800);
		assertEquals(800, p.totalPrice(2, 400));
		assertEquals(800, p.totalPrice(2, 400));
		verify(p,atLeastOnce()).totalPrice(anyInt(),anyInt());
		System.out.println("Test case11 passed ");
	}
	@Test
	void test12() {
		when(p.totalPrice(2, 400)).thenReturn(800);
		assertEquals(800, p.totalPrice(2, 400));
		assertEquals(800, p.totalPrice(2, 400));
		verify(p,atLeast(2)).totalPrice(anyInt(),anyInt());
		System.out.println("Test case12 passed ");
	}
	@Test
	void test13() {
		verify(p,never()).totalPrice(anyInt(),anyInt());
		System.out.println("Test case13 passed ");
	}
	@Test
	void test14() {
		when(p.totalPrice(2, 400)).thenReturn(800);
		assertEquals(800, p.totalPrice(2, 400));
		assertEquals(800, p.totalPrice(2, 400));
		verify(p,atMost(2)).totalPrice(anyInt(),anyInt());
		System.out.println("Test case14 passed ");
	}
	@Test
	void test15() {
		when(p.totalPrice(anyInt(),anyInt())).thenReturn(800,700,400,200);
		assertEquals(800, p.totalPrice(2, 400));
		assertEquals(700, p.totalPrice(2, 350));
		verify(p,times(2)).totalPrice(anyInt(),anyInt());
		System.out.println("Test case15 passed ");
	}
	@Test
	void test16() {
		when(m.ticketprice(2, 100.0)).thenReturn(200.0);
		assertEquals(200.0, m.ticketprice(2,100.0));
		System.out.println("Test case16 passed ");
	}
	@Test
	void test17() {
		doReturn(200.0).when(m).ticketprice(2,100.0);
		assertEquals(200.0, m.ticketprice(2,100.0));
		System.out.println("Test case17 passed ");
	}
	@Test
	void test18() {
		when(m.ticketprice(2, 100.0)).thenReturn(200.0);
		assertEquals(200.0, m.ticketprice(2,100.0));
		verify(m,atMost(1)).ticketprice(2, 100.0);
		System.out.println("Test case18 passed ");
	}
	@Test
	void test19() {
		when(m.ticketprice(2, 100.0)).thenReturn(200.0);
		assertEquals(200.0, m.ticketprice(2,100.0));
		verify(m,atLeast(1)).ticketprice(2, 100.0);
		System.out.println("Test case19 passed ");
	}
	@Test
	void test20() {
		verify(m,never()).getTotalPrice();
		System.out.println("Test case20 passed ");
	}
	@Test
	void test21() {
		verify(p,never()).setCust(cust);
		System.out.println("Test case21 passed ");
	}
	
}
