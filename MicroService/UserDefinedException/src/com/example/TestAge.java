package com.example;

import java.util.Scanner;


public class TestAge {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter age");
			int age=sc.nextInt();
			if(age<18) {
				throw new AgeException("user has age is less than 18");
			}
			else {
				System.out.println("user eligible");
			}
		}catch(AgeException ae) {
			System.out.println(ae);
		}

	}

}
