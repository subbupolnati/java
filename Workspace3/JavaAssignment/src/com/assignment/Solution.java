package com.assignment;

class Arithmetic{
	public int add(int a,int b,int c,int d) {
		int sum=a+b+c+d;
		return sum;
	}
}
class Adder extends Arithmetic{
	public int add(int a,int b,int c,int d) {
		return a+b+c+d;
	}
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adder adder=new Adder() ;
		System.out.println("My superclass is"+adder.getClass().getSuperclass().getName());
		System.out.println(adder.add(10,25,2,6)+" "+adder.add(25,6,45,25));
	}

}
