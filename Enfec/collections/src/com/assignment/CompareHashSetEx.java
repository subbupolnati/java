package com.assignment;
//compare two hashset
import java.util.HashSet;

public class CompareHashSetEx {

	public static void main(String[] args) {
		HashSet hs1=new HashSet();
		hs1.add("subbu");
		hs1.add(100);
		hs1.add('A');
		hs1.add(89.52);
		System.out.println("insertinh elements in hashset"+hs1);
		HashSet hs2=new HashSet();
		hs2.add("subbu");
		hs2.add(100);
		hs2.add('A');
		hs2.add(89.52);
		System.out.println("insertinh elements in hashset"+hs2);
		if(hs1.equals(hs2)) 
			System.out.println("two sets are same data");
		else
			System.out.println("two sets are not a same data");
	}

}
