package com.assignment;

import java.util.LinkedList;

public class ReplaceLinkedListEx {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(9);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		System.out.println("inserting elements in array list is :"+l);
		l.set(0, 10);
		System.out.println("after replace value:"+l);
	}

}
