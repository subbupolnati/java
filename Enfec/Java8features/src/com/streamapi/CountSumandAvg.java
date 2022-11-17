package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class CountSumandAvg {

	public static void main(String[] args) {
		int avg;
		List<Integer>al=Arrays.asList(10,25,5,9,4);
		Integer c=(int) al.stream().count();
		System.out.println("list of numbers count "+c);
		Integer mx=al.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Maximum elements is: "+mx);
		Integer mi=al.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Minum elements is: "+mi);
		int sum =al.stream().mapToInt(i -> i).sum();
		System.out.println("Sum found is: " + sum);
		OptionalDouble average =al.stream().mapToInt(a->a).average();
	    System.out.println("average of numbers: "+average);

	}

}
