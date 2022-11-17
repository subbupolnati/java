package com.lambda;

import java.util.Scanner;

@FunctionalInterface
interface Cube{
	int cube(int x);
}
public class CubeExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Cube c=(x)->{
			return (x*x*x);
		};
		System.out.println("enter number");
		int x=sc.nextInt();
		int z=c.cube(x);
		System.out.println("enter number cube is= "+z);
	}

}
