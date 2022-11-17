package com.assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Example{
	private void func(ArrayList mylist) {
		List newList=new Vector();
		for(int i=0;i<mylist.size();i++) {
			if(mylist.get(i).equals("###")) {
				for(int j=i+1;j<mylist.size();j++) {
					newList.add(mylist.get(j));
				}
			}
		}
		Iterator it=newList.iterator();
		while(it.hasNext()) {
			Object element = it.next();
            System.out.println((String)element);
		}
	}
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
        ArrayList mylist = new ArrayList();
        System.out.println("Enter List Size");
        int n=sc.nextInt();
        System.out.println("enter elemnets");
        for(int i=0;i<n;i++) {
        	String str=sc.next();
        	mylist.add(str);
        	new Example().func(mylist);
        }
    }

	
}
