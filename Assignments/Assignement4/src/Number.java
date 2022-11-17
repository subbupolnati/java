import java.util.Scanner;

public class Number {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String s=sc.nextLine();
		char [] ch=s.toCharArray();
		int n=0;
		for(char c:ch) {
			int temp = (int)c;
			n= (n*10)+(temp-'0');
		}
		
		System.out.println("enter string convert to a number:"+n);
	}

}
