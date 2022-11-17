package com.assignment;
import java.util.Scanner;
interface A1{
	void square();
}
class Arithmetic implements A1{
	Scanner sc=new Scanner(System.in);
	@Override
	public void square() {
		int n;
		System.out.println("enter number");
		n=sc.nextInt();
		System.out.println("Square of number is: "+(n*n));
	}
	
	
}
public class TestInt extends Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arithmetic t=new TestInt();
		t.square();
	}

}
