package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConvertLowerToUpper {

	public static void main(String[] args) {
		List<String> str=Arrays.asList("java","subbu","python","c","api");
		str.stream().map(str1->str1.toUpperCase()).forEach(s-> System.out.println(s+" "));

	}

}
