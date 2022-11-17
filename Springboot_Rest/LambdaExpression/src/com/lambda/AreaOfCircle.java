package com.lambda;

import java.util.Scanner;

interface Area{
	double area(int r);
}
public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Area a=(r)->{
			return Math.PI*r*r;
		};
		System.out.println(" enter radius");
		int r=sc.nextInt();
		System.out.println("Area of circle is="+a.area(r));
		sc.close();
	}

}
