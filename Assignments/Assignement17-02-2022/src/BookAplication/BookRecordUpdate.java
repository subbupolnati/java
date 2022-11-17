package BookAplication;
import java.sql.CallableStatement;
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
	public static void updateBookid(Connection con) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter old book id");
		bookid=sc.nextInt();
		System.out.println("enter new book id");
		newbookid=sc.nextInt();
		sql="call update_bookid(?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setInt(2,newbookid);
		stmt.setInt(1,bookid);
		stmt.execute();
		System.out.println("book id updated successfully");
		stmt.close();
	}
	public static void updateBookName(Connection con) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter new book name");
		bname=sc.next();
		System.out.println("enter book id");
		bookid=sc.nextInt();
		sql="call update_bname(?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,bname);
		stmt.setInt(2,bookid);
		stmt.execute();
		System.out.println("book name updated successfully");
		stmt.close();
	}
	public static void updateBookPrice(Connection con) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter new book price");
		price=sc.nextInt();
		System.out.println("enter book id");
		bookid=sc.nextInt();
		sql="call update_price(?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setInt(1,price);
		stmt.setInt(2,bookid);
		stmt.execute();
		System.out.println("book price updated successfully");
		stmt.close();
	}
	public static void updateBookAuthor(Connection con) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book  new author name");
		author=sc.next();
		System.out.println("enter book id");
		bookid=sc.nextInt();
		sql="call update_author(?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,author);
		stmt.setInt(2,bookid);
		stmt.execute();
		System.out.println("book author updated successfully");
		stmt.close();
	}
	public void updateBook() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		char ch='y';
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		do {
			System.out.println("enter update values\n 1.bookid\n 2.bname\n 3.price\n 4.author\n");
			int opt=sc.nextInt();
			switch(opt) {
				case 1:
					updateBookid(con);
					break;
				case 2:
					updateBookName(con);
					break;
				case 3:
					updateBookPrice(con);
					break;
				case 4:
					updateBookAuthor(con);
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
