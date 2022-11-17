package com.assignment1;
//Write a Java program to display the elements and their positions in a linked list?
import java.util.LinkedList;
import java.util.Scanner;

public class IndexPositionLinkedList {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(100);
		l.add(110);
		l.add(120);
		l.add(250);
		l.add(2785);
		l.add(175);
		System.out.println("entered Linked list is :"+l);
		for(int i=0;i<l.size();i++) {
		
			System.out.println(l.get(i)+" element index is:"+i);
		}
	}

}
