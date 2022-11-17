import java.util.Scanner;
class MinimumAgeException extends RuntimeException {
	String msg;

	
	public MinimumAgeException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
class InvalidAgeException extends RuntimeException{
	String msg;
	
public InvalidAgeException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
public class Driving {
	
	public static void main(String[] args){
		int age;
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter age");
			age=sc.nextInt();
			if(age<18 ) {
				throw new MinimumAgeException("user age 18 above");
				}
			else if(age<0 || age>100) {
				throw new InvalidAgeException("user age is negative");
			}
			else {
				System.out.println("valid age");
			}
		}
		catch(MinimumAgeException me) {
			System.out.println(me);	
			}
		catch(InvalidAgeException ie) {
			System.out.println(ie);
			}
		}
}
