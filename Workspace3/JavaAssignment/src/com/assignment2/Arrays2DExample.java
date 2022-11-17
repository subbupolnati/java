package com.assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Arrays2DExample {
	public static ArrayList createList(int size) {
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		ArrayList finalList=new ArrayList();
		for(int i=0;i<size;i++) {
			System.out.println("how many elements in each row");
			int elesize=sc.nextInt();
			ArrayList<Integer> sublist=new ArrayList<Integer>();
			for(int j=0;j<elesize;j++) {
				System.out.println("enter elements");
				int element=sc.nextInt();
				sublist.add(element);
			}
			list.add(sublist);
		}
		System.out.println(list);
		System.out.println("enter Queries size");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("enter row number");
			int x=sc.nextInt();
			System.out.println("enter element address");
			int y=sc.nextInt();
			//System.out.println(list.get(x-1).size());
			if (y > list.get(x - 1).size()) {
                //System.out.println("ERROR!");
				finalList.add("ERROR!");
            } else {
                //System.out.println(list.get(x - 1).get(y - 1));
            	finalList.add(list.get(x-1).get(y-1));
            }
        }
		return finalList;
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many rows");
		int size=sc.nextInt();
		ArrayList a=createList(size);
		Iterator it=a.iterator();
		System.out.println("Output ");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

}
