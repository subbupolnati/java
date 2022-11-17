import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmailIdExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email id:");
		String mail=sc.next();
		Pattern p=Pattern.compile("^[A-Za-z0-9(\\W)]+@[A-Za-z0-9.]+$");
		Matcher m=p.matcher(mail);
		if(m.find())
			System.out.println(mail+"   :Email Id is Valid ");
		else
			System.out.println(mail+" :email id is Invalid ");
	}

}
