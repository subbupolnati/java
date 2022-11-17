import java.util.Scanner;

public class RepeatText {
	public static void findRepeatText(String str) {
		String str1[]=str.split(" ");
		int count; 
		for(int i = 0; i<str1.length; i++) 
		{
			count = 1;    
	        for(int j=i+1;j<str1.length;j++) 
	        {    
	          if(str1[i].equals(str1[j])) 
	          {    
	             count++;    
	             str1[j] = " ";    
	           }    
	         }         
	         if(count > 1 && str1[i] != " ")    
	         System.out.println(str1[i]);    
	        }  
	}
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The String  ");
			String s=sc.nextLine();
			findRepeatText(s);  
		}  
}
