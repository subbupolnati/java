import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Upper {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String str=sc.next();
		Pattern p=Pattern.compile("[A-Z]+[a-z]+$");
		Matcher m=p.matcher(str);
		while(m.find()) {
			System.out.println("found at :"+m.group());
		}

	}

}
