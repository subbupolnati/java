package com.lambda;

import java.util.Scanner;

interface Rectangle{
	int perimeter(int width,int height);
}
public class RectangleExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Rectangle rp=(width,height)->{
			int perimeter=2*(width+height);
			return perimeter;
		};
		System.out.println("enter width");
		int width=sc.nextInt();
		System.out.println("enter height");
		int height=sc.nextInt();
		System.out.println("Rectangle perimeter is:="+rp.perimeter(width,height));
	}

}
