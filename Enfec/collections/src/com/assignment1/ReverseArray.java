package com.assignment1;


import java.util.ArrayList;
import java.util.ListIterator;

public class ReverseArray {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		a.add(50);
		System.out.println("inserting elements in array list is :");
		ListIterator lt=a.listIterator();
		while(lt.hasNext()) {
			System.out.print(" "+lt.next());
		}
		System.out.println();
		System.out.println("reverse in array list:");
		while(lt.hasPrevious()) {
			System.out.print(" "+lt.previous());
		}
	}

}
