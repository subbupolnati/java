package com.example;

import java.util.Scanner;

public class ConvertDigitToWords {

	public static void main(String[] args) {
		int num=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number");
		num=sc.nextInt();
		if(num==0) {
			System.out.println("number in words::"+"zero");
		}
		else
			System.out.println("Number in words::"+digitToWord(num));
	}
	private static String digitToWord(int num) {
		String word="";
		String units[]={ "zero", "one", "two", "three", "four", "five", "six","seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen","eighteen", "nineteen" };
		String tens[]={ "zero", "ten", "twenty", "thirty", "forty", "fifty","sixty", "seventy", "eighty", "ninety" };
		if((num/100000)>0) {
			word+=digitToWord(num/100000)+" laksh";
			num %=10000;
		}
		if((num / 1000)>0) {
			word+=digitToWord(num/1000)+" thousand";
			num %=1000;
		}
		if ((num / 100) > 0) {
		     word += digitToWord(num / 100) + " hundred ";
		     num %= 100;
		}
		if (num > 0) {
		   if (num < 20) { 
	            word += units[num];
	       }else { 
	    	   word += tens[num / 10]; 
	           if ((num % 10) > 0) {
	        	   word += " "+ units[num % 10];
	           }  
		   }
	    }
		return word;
	}
}
