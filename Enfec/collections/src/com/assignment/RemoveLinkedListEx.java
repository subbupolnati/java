package com.assignment;
//remove elements into the linked list t the first and last position
import java.util.LinkedList;

public class RemoveLinkedListEx {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		LinkedList l=new LinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		System.out.println("inserting elements in array list is :"+l);
		l.removeFirst();
		System.out.println("remove elements in linked list at first postion :"+l);
		l.removeLast();
		System.out.println("remove elements in linked list at last postion :"+l);

	}

}
