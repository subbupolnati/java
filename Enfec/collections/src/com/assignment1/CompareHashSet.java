package com.assignment1;
//Write a Java program to compare two hash set.
import java.util.HashSet;

public class CompareHashSet {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		HashSet hs1=new HashSet();
		hs.add(100);
		hs.add(200);
		hs.add(300);
		hs.add(400);
		hs.add(500);
		System.out.println("first HashSet is:"+hs);
		hs1.add(100);
		hs1.add(200);
		hs1.add(300);
		hs1.add(400);
		hs1.add(500);
		System.out.println("second HashSet is:"+hs1);
		
		System.out.println("compare two  HashSets is:  "+hs.containsAll(hs1));

	}

}
