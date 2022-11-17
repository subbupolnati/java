
package com.lambda;

import java.util.Scanner;

class Table5 extends Thread{
	public void run() {
		  table();
		}
	synchronized void table() {
		int num=5;
		for(int i=1;i<=10;i++) {
			System.out.println(num+"*"+i+"="+num*i);
		}
	  }
}
class Table7 extends Thread{
	public void run() {
		table1();
		}
	synchronized void table1() {
		int num=7;
		for(int i=1;i<=10;i++) {
			System.out.println(num+"*"+i+"="+num*i);
		}

	}
}
public class TableExample {

	public static void main(String[] args) {
		Table5 t1=new Table5();
		t1.start();
		Table7 t2=new Table7();
		t2.start();

	}

}
