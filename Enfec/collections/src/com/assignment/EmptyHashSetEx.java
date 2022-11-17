package com.assignment;

import java.util.HashSet;

public class EmptyHashSetEx {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add("subbu");
		hs.add(100);
		hs.add('A');
		hs.add(89.52);
		System.out.println("insert in elements in hashset"+hs);
		hs.clear();
		System.out.println("after clear all in elements in hashset:"+hs);

	}

}
