import java.util.Scanner;

public class FIndSmallestAndLargest {
	public static void findlargeAndSmall(String str) {
		String str1[]=str.split(" ");
		  int min=999;int max=0;
		  String maxValue=null;
		  String minValue=null; 
		  for(int i=0;i<str1.length;i++)
			  if(str1[i].length()>max)
			  {
				 maxValue=str1[i];
				 max=str1[i].length();
			  }
			  else if(str1[i].length()<min)
			  {
				  minValue=str1[i];
				  min=str1[i].length();
			  }
		  System.out.println("maxValue:"+maxValue);
		  System.out.println("Min Value:"+minValue);
		  }
		 
		public static void main(String[] args) {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The String  ");
			String s=sc.nextLine();
			findlargeAndSmall(s);
	}
}
