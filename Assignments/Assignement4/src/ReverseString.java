import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter String");
		String str=sc.nextLine();
		String rev="";
		char[] ch=str.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			int k=i;
			
			while(i>=0 && ch[i]!=' ') {
				i--;
			}
			//System.out.println("i"+i);
			int j=i+1;
			//System.out.println("j"+j);
			//System.out.println("k"+k);
			while(j<=k) {
				rev+=ch[j];
				j++;
			}
			rev+=" ";
		}
		System.out.println("Reverse of a string :"+rev);
	}

}
