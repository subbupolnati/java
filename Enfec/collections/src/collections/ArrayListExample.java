package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListExample {
	
	private static String  num;
	private static String rem;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList a1=new ArrayList();
		getDetails();
		a1.add(num);
		getDetails();
		a1.add(num);
		getDetails();
		a1.add(num);
		getRemove();
		a1.remove(rem);
		//System.out.println(""+a1);
		Iterator it=a1.iterator();
		System.out.println("elements in array list");
		while(it.hasNext()) {
			System.out.println(""+it.next());
		}
	}
	private static String getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		num=sc.next();
		return num;
	}
	private static String getRemove() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter remove number");
		rem=sc.next();
		return rem;
	}
}
