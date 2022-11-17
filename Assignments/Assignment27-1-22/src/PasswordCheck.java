import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class InvalidPasswordException extends RuntimeException{
	String msg;
	
public InvalidPasswordException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
public class PasswordCheck {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter password");
		String pass=sc.next();
		Pattern p=Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
		Matcher m=p.matcher(pass);
		try {
			if(m.find())
				System.out.println(pass+"   :password is Valid ");
			else
				throw new InvalidPasswordException("password minimum length 8 characters \n atleast 1 upper case\n 1 lowercase \n 1 digit \n 1 special character ");
		}
		catch(InvalidPasswordException ie) {
			System.out.println(ie);
			}

	}

}
//