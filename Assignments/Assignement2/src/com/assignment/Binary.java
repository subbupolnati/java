package com.assignment;
import java.util.Scanner;
public class Binary {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter decimal number");
		int n=sc.nextInt();
		int temp=n;
		int a[]=new int[20];
		int i=0;
		while(n>0) {
			a[i]=n%2;
			n=n/2;
			i++;
		}
		System.out.println(""+temp+"  binary number is: ");
		for(int j=i-1;j>=0;j--) {
			System.out.print(a[j]);
		}
	}

}
