package com.string3;

import java.util.Scanner;

public class Name1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String name=sc.nextLine();
		
	    String str[]=name.split(" ");
	    int len =str.length-1;
	    for(int i=0;i<str.length;i++) {
	    	if(i==len) {
	    		System.out.println(str[i]);
	    		break;
	    	}
	    }
	    for(int i=0;i<str.length;i++) {
	    	if(i!=len) {
	    		str[i]=str[i].toLowerCase().substring(0,1);
	    		System.out.print(str[i]);
	    	}
	    }
		}

}
