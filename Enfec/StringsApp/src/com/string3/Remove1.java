package com.string3;

import java.util.Scanner;

public class Remove1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter string");
		String s=sc.nextLine();
		System.out.println("enter remove String");
		String re=sc.nextLine();
		String a[]=s.split(" ");
		for(int i=0;i<a.length;i++) {
			if(a[i].equals(re)) {
				continue;
			}
			else
				System.out.print(a[i]);
		}
		

	}

}
