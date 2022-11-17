import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.next();
		Pattern p=Pattern.compile("(b)$");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println("String matches");
		}
	}

}
