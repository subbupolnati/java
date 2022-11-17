package com.lambda;

import java.util.Scanner;

interface Circle{
	double area(int radius);
}
public class AreaCircleExample {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Circle c=(r)->{
			double area=Math.PI*r*r;
			return area;
		};
		System.out.println("enter radius");
		int x=sc.nextInt();
		System.out.println("Area of Circle is= "+c.area(x));
	}

}
