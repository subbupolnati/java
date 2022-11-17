package com.assign;

import java.util.Scanner;

class InvalidBinaryException extends RuntimeException{
	String msg;

	public InvalidBinaryException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
public class StringBinary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter a binary number");
			String str=sc.nextLine();
			for(int i=0;i<str.length();i++) {
				char c=str.charAt(i);
				if(c=='1' || c=='0') {
					continue;
				}
				else {
					throw new InvalidBinaryException("number is not a binary");
				}
			}
			System.out.println("enter number is binary");
		}
		catch(InvalidBinaryException i) {
			System.out.println(i);
		}
	}

}
