package com.assignment;

import java.util.LinkedList;
import java.util.ListIterator;

//iterate a linked list in reverse order
public class ReverseLinkedlistEx {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		System.out.println("inserting elements in array list is :");
		ListIterator lt=l.listIterator();
		while(lt.hasNext()) {
			System.out.print(" "+lt.next());
		}
		System.out.println();
		System.out.println("reverse in linked list:");
		while(lt.hasPrevious()) {
			System.out.print(" "+lt.previous());
		}
	}

}
