import java.util.Scanner;

public class Assignment1 {

	public static int sumOfDigit(int num) {
		int sum=0;
		while (num > 0) {

		    int temp=num % 10;
		    num = num / 10;
		   // System.out.println(temp);
		    if(temp%3==1) {
		    	sum+=temp;
		    	System.out.println("Special numbers:"+temp);
		    } 
		}
		 return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter digits");
		int n=sc.nextInt();
		System.out.println("Sum of special numbers:"+Assignment1.sumOfDigit(n));
	}

}
