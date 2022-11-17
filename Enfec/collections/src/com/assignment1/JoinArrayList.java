package com.assignment1;

import java.util.ArrayList;

public class JoinArrayList {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		ArrayList a1=new ArrayList();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		a.add(50);
		System.out.println("Arraylist1: "+a);
		a1.add(60);
		a1.add(70);
		a1.add(80);
		a1.add(90);
		a1.add(100);
		System.out.println("Arraylist2: "+a1);
		
		a.addAll(a1);
		System.out.println("join two arrays in single arraylist: "+a);
		
	}

}
