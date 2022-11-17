import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookRecordUpdate {
	public static int bookid;
	public static String bname;
	public static int price;
	public static String author;
	public static int newbookid;
	public static String sql;
	public static String updateBookid() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter old book id");
		bookid=sc.nextInt();
		System.out.println("enter new book id");
		newbookid=sc.nextInt();
		sql="update book set bookid="+newbookid+"where bookid="+bookid;
		return sql;
	}
	public static String updateBookName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book name");
		bname=sc.next();
		sql="update book set bname="+bname+"where bookid="+bookid;
		return sql;
	}
	public static String updateBookPrice() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book price");
		price=sc.nextInt();
		sql="update book set price="+price+"where bookid="+bookid;
		return sql;
	}
	public static String updateBookAuthor() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book author name");
		author=sc.next();
		sql="update book set author="+author+"where bookid="+bookid;
		return sql;
	}
	public void updateBook() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int row;
		char ch='y';
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		do {
			System.out.println("enter update values\n 1.bookid\n 2.bname\n 3.price\n 4.author\n");
			int opt=sc.nextInt();
			switch(opt) {
				case 1:
					updateBookid();
					row=stmt.executeUpdate(sql);
					System.out.println("book id updated successfully");
					break;
				case 2:
					updateBookName();
					row=stmt.executeUpdate(sql);
					System.out.println("book name updated successfully");
					break;
				case 3:
					updateBookPrice();
					row=stmt.executeUpdate(sql);
					System.out.println("book price updated successfully");
					break;
				case 4:
					updateBookAuthor();
					row=stmt.executeUpdate(sql);
					System.out.println("book author updated successfully");
					break;
				default:
					System.out.println("please select valid options");
					break;
				}
			System.out.println("Do you Want contionue y/n");
			ch=sc.next().charAt(0);
			if(ch=='n' ||ch=='N')
				break;
			}while(ch=='Y'|| ch=='y');
			con.close();
		}
}
