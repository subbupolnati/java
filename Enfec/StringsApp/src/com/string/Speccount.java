package com.string;
import java.util.*;
public class Speccount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int acount=0;int nc=0;int scount=0; int spcount=0;
		System.out.println("enter a String");
		String str=sc.nextLine();
		for(int i=0;i<str.length();i++)
		{	 
			char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')
                acount++;
            else if (ch==' '|| ch==32)
               spcount++;
            else if (ch >= '0' && ch <= '9')
                nc++;
            else
                scount++;
		}
        System.out.println("Special  characters : " + scount);
        System.out.println("Space characters : " + spcount);
    }
}
