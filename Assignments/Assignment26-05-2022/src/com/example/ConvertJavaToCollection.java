package com.example;

import java.util.Arrays;
import java.util.List;

public class ConvertJavaToCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[]={ "subbu", "veera", "Rohit", "Mohan" };
		System.out.println("array"+Arrays.toString(names));
		List<String>  nameList=Arrays.asList(names);
		System.out.println("List"+nameList);
	}
	
}
