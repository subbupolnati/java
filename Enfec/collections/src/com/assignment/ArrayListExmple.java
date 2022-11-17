package com.assignment;

import java.util.ArrayList;
import java.util.Iterator;

//create a new array list add some colors in list and print
public class ArrayListExmple {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add("Red");
		a.add("Green");
		a.add("Black");
		a.add("white");
		a.add("blue");
		Iterator it=a.iterator();
		while(it.hasNext()) {
			System.out.println("color is -"+it.next());
		}

	}

}
