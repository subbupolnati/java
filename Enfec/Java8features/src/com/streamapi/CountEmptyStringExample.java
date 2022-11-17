package com.streamapi;

import java.util.ArrayList;

public class CountEmptyStringExample {

	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		al.add("Subbu");
		al.add("");
		al.add("java");
		al.add("");
		al.add("c");
		Integer c=(int) al.stream().filter(str->str.isEmpty()).count();
		System.out.println("Count of empty strings is "+c);
	}
}
