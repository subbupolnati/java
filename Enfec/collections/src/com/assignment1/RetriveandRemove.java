package com.assignment1;
//Write a Java program to retrieve and remove the first element of a LinkedList?
import java.util.LinkedList;

public class RetriveandRemove {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(100);
		l.add(110);
		l.add(120);
		l.add(130);
		l.add(140);
		l.add(150);
		System.out.println("linked list elements in: "+l);
		System.out.println("retrive first element in linkedlist is: "+l.getFirst());
		l.removeFirst();
		System.out.println("removing first element in linkedlist is: "+l);
	}

}
