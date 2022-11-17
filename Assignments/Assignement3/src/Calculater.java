import java.util.*;
public class Calculater {
	public static void main(String[] args) {
		int a,b,c;
		char ch;
		
		Scanner sc=new Scanner(System.in);
		
		do {
			System.out.println("enter a value");
			a=sc.nextInt();
			System.out.println("enter b value");
			b=sc.nextInt();
			System.out.println("Addition =add\n"+"subtraction =sub\n"+"multiplication =mul\n"+"division =div\n"+"mod =mod"+" ");
			System.out.println("enter operation");
			final String op=sc.next();
			switch(op) {
			case "add":
				c=a+b;
				System.out.println("addition is= "+c);
				break;
			case "sub":
				c=a-b;
				System.out.println("subtraction is= "+c);
				break;
			case "mul":
				c=a*b;
				System.out.println("multiplication is= "+c);
				break;
			case "div":
				c=a/b;
				System.out.println("division is= "+c);
				break;
			case "mod":
				c=a%b;
				System.out.println("module is= "+c);
				break;
			default:
				System.out.println("please enter correct option");
				}
			
			System.out.println("Do you continue y/n");
			 ch=sc.next().charAt(0);
			if(ch=='n') {
				break;
			}
			
			}while(ch=='y');
		
		}

}
