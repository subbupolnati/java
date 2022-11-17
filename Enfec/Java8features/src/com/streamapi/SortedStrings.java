package com.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedStrings {

	public static void main(String[] args) {
		List<String> str=new ArrayList<String>();
		str.add("java");
		str.add("subbu");
		str.add("python");
		str.add("c");
		str.add("api");
		str.add("ruby");
		str.add("pascal");
		str.add("veera");str.add("xyz");str.add("t");
		System.out.println("Before Sorting"+str);
		List<String> sortedlist=str.stream().sorted().collect(Collectors.toList());
		System.out.println("after Sorting"+sortedlist);

	}

}
