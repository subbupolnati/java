package com.assignment;

import java.util.Scanner;

abstract class Book{
    String title;
    abstract void setTitle(String s);
	public String getTitle() {
		return title;
	}
}
class MyBook extends Book
{
    void setTitle(String s)
    {
        title = s;
    }
    
}
public class AbstarctClass {

	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter title");
	      String title=sc.nextLine();
	      MyBook new_novel=new MyBook();
	      new_novel.setTitle(title);
	      System.out.println("The title is: "+new_novel.getTitle());
	}

}
