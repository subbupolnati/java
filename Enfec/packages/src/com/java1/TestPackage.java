package com.java1;

import com.java1.advjava.A1;
import com.java1.advjava.A2;
import com.java1.corejava.collect.C1;
import com.java1.corejava.collect.C2;
import com.java1.corejava.oop.A;
import com.java1.corejava.oop.B1;
import com.java1.corejava.thread1.T1;
import com.java1.corejava.thread1.T2;

public class TestPackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.print();
		System.out.println("_____________________");
		B1 b=new B1();
		b.print();
		System.out.println("_____________________");
		C1 c1=new C1();
		c1.print();
		System.out.println("_____________________");
		C2 c2=new C2();
		c2.print();
		System.out.println("_____________________");
		T1 t1=new T1();
		t1.print();
		System.out.println("_____________________");
		T2 t2=new T2();
		t2.print();
		System.out.println("_____________________");
		A1 a1=new A1();
		a1.print();
		System.out.println("_____________________");
		A2 a2=new A2();
		a2.print();
		
	}

}
