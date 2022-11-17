import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int vowels = 0, consonant = 0, specialChar = 0,digit = 0,spcount=0;
		File f=new File("G://java1/abc.txt");
		f.createNewFile();
		System.out.println("file is created");
		System.out.println("enter a string");
		String str=sc.nextLine();
		FileWriter fw= new FileWriter(f);
		fw.write(str);
		fw.flush();
		fw.close();
		System.out.println("file write successfully");
		FileReader fr=new FileReader(f);
		int a;
		while ((a=fr.read())!=-1) {
			char ch=(char)a;
			 if ( (ch >= 'a' && ch <= 'z') ||(ch >= 'A' && ch <= 'Z') ) {
				 if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
		               vowels++;
		         else
		        	 consonant++;
		     }
		     else if (ch >= '0' && ch <= '9')
		                digit++;
		     else if (ch==' '|| ch==32)
	               spcount++;
		     else
		                specialChar++;
		}
		System.out.println("vowels in String         :  "+vowels);
		System.out.println("consonants in String     :  "+consonant);
		System.out.println("digits in String         :  "+digit);
		System.out.println("special symbol in String :  "+specialChar);
		System.out.println("spaces in String         :  "+spcount);
		fr.close();
	}
}
