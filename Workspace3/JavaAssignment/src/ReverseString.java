import java.util.Scanner;

/*Reverse Each Word in a String in at its own place*/
public class ReverseString {
	public static void reverseString(String str) {
		 	String[] str1 = str.split(" ");
	        String reverseString = "";
	        for (int i = 0; i < str1.length; i++) 
	        {
	            String word = str1[i];
	            String reverseWord = "";          
	            for (int j = word.length()-1; j >= 0; j--) 
	            {
	                reverseWord = reverseWord + word.charAt(j);
	            }
	            reverseString = reverseString + reverseWord + " ";
	        }
	        System.out.println(str);
	        System.out.println(reverseString);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		reverseString(str);
	}
}