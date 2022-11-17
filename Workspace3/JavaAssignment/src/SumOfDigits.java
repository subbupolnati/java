import java.util.Scanner;

public class SumOfDigits {

	public static int SumOfNumber(int num) {
		if(num==0) {
			return num;
		}
		return num%10+SumOfNumber(num/10);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter  value");
		int num=sc.nextInt();
		System.out.println("sum of numbers is ="+SumOfNumber(num));
	}

}
