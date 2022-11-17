package com.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> str=Arrays.asList("java", "abcf", "c", "python", "subbu", "av");
		
		Long c=str.stream().filter(x->x.length()>3).count();
		System.out.println("Count of length of greaterthan 3 :"+c);

	}

}
