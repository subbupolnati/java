package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Prime_Armstrong {	
	public static void prime(int n)
	{
		ArrayList a1=new ArrayList();
		int i,flag=0;
		if(n==0||n==1){
			System.out.println(n+"is not prime number");
		}
		else{
			for(i=2;i<n/2;i++){
				if(n%i==0){
					System.out.println(n+"is not prme number");
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println(n+"is prime number");
				a1.add(n);
			}
		}
		System.out.println("prime number in arraylist"+a1);
	}
	static void armstrong(int n) {
		int num,temp,sum=0,rem,i;
		LinkedList l1=new LinkedList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number");
		num=sc.nextInt();
		temp=num;
		while(num>0)
		{	
			rem=num%10;
			num=num/10;
			sum=sum+(rem*rem*rem);
		}
		if(temp==sum) {
			System.out.println("Aramstrong Number");
			l1.add(sum);
		}
		else
			System.out.println("Not an Aramstrong Number");
		System.out.println("Linked list in arm strong number"+l1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		int n=sc.nextInt();
		prime(n);
		armstrong(n);
		
		
	}
	
}
