package com.assignment;
//Convert to hashset to treeset
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ConvertHash2Tree {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(10);
		hs.add(100);
		hs.add(20);
		hs.add(89);
		System.out.println("insertinh elements in hashset"+hs);
		Set ts=new TreeSet();
		ts.addAll(hs);
		System.out.println("after convert tree set:"+ts);
	}

}
