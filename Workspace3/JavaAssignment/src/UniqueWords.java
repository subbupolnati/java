import java.util.Scanner;

public class UniqueWords {

	public static void findUniqueWords(String str) {
		String str1[]=str.split(" ");
		  int count=0;int k=0;
		  for(int i = 0; i < str1.length; i++) 
		  {    
	         count = 1;    
	          for(int j = i+1; j < str1.length; j++) 
	          {    
	                if(str1[i].equals(str1[j])) 
	                {    
	                    count++;    
	                    str1[j] = " ";    
	                }    
	            }    
	            if(count == 1 && str1[i] != " ")    
	            k++;  
	        }  
		  System.out.println("count is "+k);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		findUniqueWords(str);
	}

}
