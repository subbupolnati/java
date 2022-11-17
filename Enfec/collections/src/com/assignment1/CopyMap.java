package com.assignment1;
//Write a Java program to copy all of the mappings from the specified map to another map?
import java.util.HashMap;
import java.util.Map;

public class CopyMap {

	public static void main(String[] args) {
		Map m=new HashMap();
		Map m1=new HashMap();
		m.put(100,256);
		m.put(101, 40);
		m.put(102, 265);
		m.put(103, "subbu");
		m.put(104, "polnati");
		System.out.println("first map elements is :"+m);
		System.out.println();
		m1.putAll(m);
		System.out.println("copied map elements is :"+m1);
	}

}
