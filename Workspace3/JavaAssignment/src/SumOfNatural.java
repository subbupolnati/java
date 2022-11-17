import java.util.Scanner;

public class SumOfNatural {

	public static int sumOfNatural(int num) {
		if(num<=1) {
			return num;
		}
		return num+sumOfNatural(num-1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number");
		int num=sc.nextInt();
		System.out.println("Sum of natural number is ="+sumOfNatural(num));
	}
}
