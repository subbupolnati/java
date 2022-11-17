package com.string3;

import java.util.Scanner;

public class Frequency {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		int count=0,max=0;char ch=' ';
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			 count = 0;
			if(c==' ')
            	continue;
			 for(int j=0;j <str.length();j++) 
	            {   
	                 if(c==str.charAt(j)) {
	                	 count++;
	                }  
	            } 
			 if(count>max)
					max=count;
			 ch=c;
	        }  
	 
	        System.out.println("max in frequency "+ch+" "+max);
		}

	}


