package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SquareDistinct {

	public static void main(String[] args) {
		List<Integer>al=Arrays.asList(10,25,10,5,9,5,4);
		Stream<Integer> c=al.stream().distinct();
		c.forEach(n-> System.out.println(n*n));
	}

}
