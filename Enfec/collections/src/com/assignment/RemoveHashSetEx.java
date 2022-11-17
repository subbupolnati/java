package com.assignment;
//Remove all elements in hash Set
import java.util.HashSet;

public class RemoveHashSetEx {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add("subbu");
		hs.add(100);
		hs.add('A');
		hs.add(89.52);
		System.out.println("insert in elements in hashset"+hs);
		hs.removeAll(hs);
		System.out.println("remove all elements in hash set:"+hs);

	}

}
