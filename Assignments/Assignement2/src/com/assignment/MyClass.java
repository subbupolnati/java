package com.assignment;
interface A{
	void meth1();
	void meth2();
}
public class MyClass implements A{
	@Override
	public void meth1() {
		// TODO Auto-generated method stub
		System.out.println("print meth1");
	}

	@Override
	public void meth2() {
		// TODO Auto-generated method stub
		System.out.println("print math2");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new MyClass();
		a.meth1();
		a.meth2();
	}

	

}
