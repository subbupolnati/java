import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Book implements Serializable{
	int book_id;
	String book_name;
	int book_price;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_price=" + book_price + "]";
	}
	public Book(int book_id, String book_name, int book_price) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_price = book_price;
	}
}
class BookComparatorById implements Comparator<Book>{
	@Override
	public int compare(Book o1, Book o2) {
		if(o1.book_id<o2.book_id)
			return -1;
		else if(o1.book_id>o2.book_id)
			return 1;
		else
		return 0;
	}
}
public class BookExample {
	private static int book_id;
	private static String book_name;
	private static int book_price;
	private static void getDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book_id");
		book_id=sc.nextInt();
		System.out.println("enter book_name");
		book_name=sc.next();
		System.out.println("enter price");
		book_price=sc.nextInt();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		ArrayList<Book> a=new ArrayList<Book>();
		FileOutputStream fout=new FileOutputStream("G://java1/Book_Details.txt");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		System.out.println("enter how many elements");
		int n=sc.nextInt();
		int i=0;
		while(i<n) {
			getDetails();
			Book b1=new Book(book_id,book_name,book_price);
			out.writeObject(b1);
			i++;
		}
		out.flush();
		out.close();
		System.out.println("state of objects written successfully");
		FileInputStream fin=new FileInputStream("G://java1/Book_Details.txt");
		ObjectInputStream oin=new ObjectInputStream(fin);
		for(int j=0;j<n;j++) {
			Book ar =(Book)oin.readObject();
			//System.out.println("product id"+ar.getBook_id());
			//System.out.println("product name"+ar.getBook_name());
			//System.out.println("product price"+ar.getBook_price());
			a.add(ar);
		}
		System.out.println("All book detilas are: "+a);
		Collections.sort(a,new BookComparatorById());
		char ch;
		do {
			System.out.println("enter book_id for searching");
			int id=sc.nextInt();
			Book b2=new Book(id,null,0);
			int index=Collections.binarySearch(a,b2,new BookComparatorById());
			if(index<0)
				System.out.println("Book_id not found in file");
			else
				System.out.println("Book_id found in file :"+a.get(index));
			System.out.println(" are you continue  for searching(y/n)");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
		System.out.println();
	}
}
