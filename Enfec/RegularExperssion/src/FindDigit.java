import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.next();
		Pattern p=Pattern.compile("[0-9]");
		Matcher m=p.matcher(str);
		while(m.find()) {
			System.out.println("found at :"+m.start());
		}
	}
}
