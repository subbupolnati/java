import java.util.Scanner;

public class CalculatePow {
	private static int calcPow(int base, int pow) {
		if(pow==1) {
			return base;
		}
		return (base *calcPow(base, pow-1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter base value");
		int base=sc.nextInt();
		System.out.println("enter power value");
		int pow=sc.nextInt();
		System.out.println("power of value"+calcPow(base,pow));
	}

	

}
