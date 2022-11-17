package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentException {
	int sid;
	String sname;
	int mobile;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter student id");
			int sid=sc.nextInt();
			System.out.println("enter student name");
			String sname=sc.next();
			System.out.println("enter mobile number");
			long mobile=sc.nextLong();
			System.out.println("enter subjects");
			int d=sc.nextInt();
			int marks[]= {75,34,55,77};
			System.out.println(marks[1]/d);
			String address=null;  
            System.out.println(address.length()); 
			System.out.println(marks[10]);
			int i=Integer.parseInt(sname);
			
		
		}
		catch(NullPointerException e ) {
			 System.out.println(e);
		}
		catch (InputMismatchException ex) {
	            System.out.println("input is not with in integer range "+ ex);
	       }
		catch(NumberFormatException  ne) {
			{
	            System.out.println("input "+ ne);
	       }
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
	            System.out.println("input "+ e);
	       }
		catch(ArithmeticException ae) {
			
            System.out.println("input "+ ae);
       }
	}

}

