package com.singledimentionalarray;

import java.util.Scanner;

public class Single {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int size=sc.nextInt();
		int []arr=new int[size];
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter elements in array:");
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(""+arr[i]);
		}

	}

}
