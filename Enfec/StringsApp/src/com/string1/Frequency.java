// count frequency of each charcter
package com.string1;
import java.util.Scanner;

public class Frequency {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		int count[]=new int[str.length()];
		char str1[] = str.toCharArray();
		
		for(int i=0;i<str.length();i++) {
			 count[i] = 1;  
	            for(int j=i+1;j <str.length();j++) 
	            {  
	                if(str1[i]==str1[j])
	                {  
	                    count[i]++; 
	                    str1[j] = '0';  
	                }  
	            }  
	        }  
	        for(int i = 0; i<count.length; i++) 
	        {  
	            if(str1[i] != ' ' && str1[i] != '0')  
	                System.out.println(str1[i] + " " + count[i]+" occurence");  
	        }  
		}
	}
