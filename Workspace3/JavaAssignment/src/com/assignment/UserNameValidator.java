package com.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class UserNameValidator {
	public static void validate(ArrayList<String> usernames) {
		String regEx = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";
		for(Object str:usernames) {
			if (((String) str).matches(regEx)) {
                System.out.println("Valid");
            } 
			else {
                System.out.println("Invalid");
            }
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size");
		int size=sc.nextInt();
		ArrayList<String> usernames=new ArrayList<String>();
		System.out.println("enter username");
		for(int i=0;i<size;i++) {
			usernames.add(sc.next());
		}
		validate(usernames);
	}

}
