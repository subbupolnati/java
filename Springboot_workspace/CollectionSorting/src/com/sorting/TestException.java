package com.sorting;

class A
{
	int x;

	public A(int x) {
		super();
		this.x = x;
	}
	public void display()
	{
		System.out.println("displaying details");
	}
	
}

public class TestException {
	public static void main(String[] args)
	{
		int a=10,b=0,c;
		try
		{
			
			//A a1=null;
			String str="Xy";
			int x=Integer.parseInt(str);
			c=a/b;	
			//a1.display();
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Cannot Divide Number by 0");
		}
		catch(NullPointerException ne)
		{
			System.out.println("MemoryNotAllocated For Object");	
		}
		catch(NumberFormatException ee) {
			System.out.println("Not a valid Number");
			
		}
		System.out.println("after catch block");
	
	}
}
