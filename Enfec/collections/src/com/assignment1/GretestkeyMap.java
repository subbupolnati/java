package com.assignment1;
import java.security.KeyStore.Entry;
//Write a Java program to get a key-value mapping associated with the greatest key in a map?
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class GretestkeyMap{

	public static void main(String[] args) {
		Object  max=null;
		
		Map h=new HashMap();
		h.put(100, "subbu");
		h.put(101, "polnati");
		h.put(102,"enfec");
		h.put(99,456.45);
		h.put(98, 865);
		Set hs=h.entrySet();
			
		Iterator it=hs.iterator();
		while(it.hasNext()) {
			Map.Entry mp=(java.util.Map.Entry)it.next();
			max=mp.getKey();
			}
		System.out.println(""+max);
		}
	
	}


