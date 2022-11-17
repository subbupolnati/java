import java.util.Scanner;

public class Concate {

	static char[] concat(String str,String str1) {
		int index=0;
		char str2[]=new char[str.length()+str1.length()];
		for(int i=0;i<str.length();i++) {
			str2[i]+=str.charAt(i);
			index=i;
		}
		index+=1;
		for (int i=0;i<str1.length();i++) {
			str2[index]+=str1.charAt(i);
			index+=1;
		}
		return str2;
	}
	public static void main(String[] args) {
		System.out.println(concat("hello","world"));
		
	}
}
