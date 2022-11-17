package com.singledimentionalarray;

import java.util.Scanner;

public class Two {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int size=sc.nextInt();
		int size1=sc.nextInt();
		int arr[][]=new int[size][size1];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size1;j++) {
				System.out.println("enter elemets");
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size1;j++) {
				System.out.println(""+arr[i][j]);
			}
		}
	}

}
