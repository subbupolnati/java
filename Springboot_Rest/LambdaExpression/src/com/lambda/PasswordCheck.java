package com.lambda;
import java.util.Scanner;
class InvalidPasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	String msg;
	public InvalidPasswordException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
class Password{
	
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	static synchronized void validePassword(String pass) {
		 
          int n=pass.length();
          boolean lower=false;
          boolean upper=false;
          boolean digit=false;
          boolean special=false;
          boolean len=false;
          for(char c:pass.toCharArray()){
        	if(Character.isLowerCase(c))
        		lower=true;
        	if(Character.isUpperCase(c))
        		upper=true;
        	if(Character.isDigit(c))
        		digit=true;
          }
          if (pass.contains("@") || pass.contains("#")|| pass.contains("!") ||pass.contains("~")||pass.contains("$") || pass.contains("%")|| pass.contains("&")
                  || pass.contains("*") || pass.contains("(")|| pass.contains("|")) {
                special=true;
            }
          if(n>=8) {
        	  len=true;
          }
          if(lower==true && upper==true && digit==true&& special==true&&len==true) {
        	  System.out.println("password is valid"+pass);
          }
          else {
        	  throw new InvalidPasswordException("password is at least 1 upper case latter and 1 lower case letter and 1 digit and 1 special symbol and lenght more than 8 characters ");
          }
	}
}
class Thread1 extends Thread{
	String pass;
	Password pd;
	Thread1(String pass,Password pd){
		this.pass=pass;
		this.pd=pd;
	}
	public void run() {
		pd.validePassword(pass);
	}
}
public class PasswordCheck {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter password is");
	String pass=sc.next();
	//System.out.println("enter second password is");
	//String pass1=sc.next();
	Password p1=new Password();
	Thread1 t1=new Thread1(pass,p1);
	//Thread1 t2=new Thread1(pass1,p1);
	t1.start();
	//t2.start();

	}
}
