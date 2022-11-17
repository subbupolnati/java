package com.singledimentionalarray;

import java.util.Scanner;

public class Insertelement {

	public static void main(String[] args) {
		int element,i,pos;
		Scanner sc=new Scanner(System.in);
		int a[]=new int[5];
		for(i=0;i<5;i++) {
			System.out.println("enter numbers");
			a[i]=sc.nextInt();	
		}
		System.out.println("enter position");
		pos=sc.nextInt();
		System.out.println("enter element");
		element=sc.nextInt();
		for(i=0;i<5;i++) {
			if(i==pos) {
				break;
			}
		}
		for(i=a.length-1;i>pos;i--) {
			a[i]=a[i-1];	
		}
		a[pos]=element;
		for(i=0;i<5;i++) {
			System.out.print(a[i]);
		}
	}

}
