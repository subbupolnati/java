import java.util.Scanner;
public class Test {
	public void convert(String s) {
		int n=0;
		for (int i=0;i<s.length();i++) {
		n=n*10;
		n=n+((int)s.charAt(i)-48);
		}
		System.out.println("convert String to integer:"+n);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String:");
		String s=sc.next();
		Test t=new Test();
		t.convert(s);

	}

}
