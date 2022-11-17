package com.assignment1;
//How to convert ArrayList to Array and Array to ArrayList?
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertArraylist2Arr {

	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add(100);
		a1.add(125);
		a1.add("string");
		a1.add(175);
		a1.add(200);
		System.out.println("convert Arraylist to array:");
		//a1.toArray();
		//System.out.println(a1);
		 Object[] array = a1.toArray();
		 for(Object i:array) {
			 System.out.println(""+i);
		 }
		 ArrayList a2=new ArrayList();
		 for(int i=0;i<array.length;i++)
		 {
			 a2.add(array[i]);
		 }
		 System.out.println("convert Array to ArrayLIst:"+a2);
		 

	}

}
