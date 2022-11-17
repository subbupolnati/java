package com.assignment;

import java.util.ArrayList;

//insert an element into array list at the first position
public class ArrayListExample1 {

	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		
		a1.add(20);
		a1.add(30);
		a1.add(40);
		a1.add(50);
		System.out.println("inserting elements in array list is :"+a1);
		a1.add(0, 10);
		System.out.println("inserting elements in array list at the first position :"+a1);
	}

}
