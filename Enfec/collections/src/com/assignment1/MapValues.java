package com.assignment1;

//Write a Java program to get a collection view of the values contained in this map?
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.Iterator;
import java.util.Map.Entry;
public class MapValues {

	public static void main(String[] args) {
		Map hm=new HashMap();
		hm.put(100,"enfec");
		hm.put(101, "solutions");
		hm.put(102, "hyd");
		hm.put(103, "subbu");
		hm.put(104, "polnati");
		
		//System.out.println("all values in map: "+hm.values());
		Set hs=hm.entrySet();
		Iterator it=hs.iterator();
		System.out.println("collection view");
		while (it.hasNext()) {
			Map.Entry mp=(Entry)it.next();
			System.out.print(" "+mp.getValue());
		}
	}

}
