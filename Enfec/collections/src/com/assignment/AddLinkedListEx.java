package com.assignment;

import java.util.LinkedList;

//insert elements into the linked list t the first and last position
public class AddLinkedListEx {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		System.out.println("inserting elements in array list is :"+l);
		l.addFirst(10);
		System.out.println("inserting elements in linked list at first postion :"+l);
		l.addLast(60);
		System.out.println("inserting elements in linked list at last postion :"+l);
	}

}
