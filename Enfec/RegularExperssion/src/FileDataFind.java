
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataFind {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		File f=new File("G://java1/abc.txt");
		f.createNewFile();
		System.out.println("file is created");
		System.out.println("enter a string");
		String str=sc.nextLine();
		FileWriter fw= new FileWriter(f);
		fw.write(str);
		fw.flush();
		fw.close();
		File f1=new File("G://java1/abc1.txt");
		f1.createNewFile();
		System.out.println("file write successfully");
		BufferedReader bf = new BufferedReader(new FileReader(f));
		int linecount = 0;
		int count=0;
        String line;
        FileWriter fw1= new FileWriter(f1);
		while ((line=bf.readLine())!=null) {
	
			linecount++;
		    Matcher m = p.matcher(line);
		    while (m.find()) {
				fw1.write(m.group());
				fw1.flush();
				fw1.close();
		    }
		}
		FileReader fr=new FileReader(f1);
		int a;
		while ((a=fr.read())!=-1) {
			char ch=(char)a;
			System.out.println(ch);
		}
		
	}
}