package com.lambda;

import java.util.Scanner;

interface RectangleEx{
	int perimeter(int w,int h);
}
public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		RectangleEx r=(w,h)->{
			return (2*(w+h));
		};
		System.out.println("enter width");
		int w=sc.nextInt();
		System.out.println("enter height");
		int h=sc.nextInt();
		System.out.println("perimeter of rectangle is="+r.perimeter(w, h));
	}

}
