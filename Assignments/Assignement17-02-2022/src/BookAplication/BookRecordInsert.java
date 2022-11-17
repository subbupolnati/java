package BookAplication;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookRecordInsert {
	public static int bookid;
	public static String bname;
	public static int price;
	public static String author;
	public static String sql;
	//user entered book details
	public static void getBookDetails() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		System.out.println("enter book id");
		bookid=sc.nextInt();
		System.out.println("enter book name");
		bname=sc.next();
		System.out.println("enter book price");
		price=sc.nextInt();
		System.out.println("enter book authorName");
		author=sc.next();
		sql="call insert_book(?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setInt(1, bookid);
		stmt.setString(2, bname);
		stmt.setInt(3, price);
		stmt.setString(4, author);
		stmt.execute();
		System.out.println(" row successfuly inserted");
		con.close();
	}
	//insertion operation performed
	public void insertBook() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("how many records entered");
		int n=sc.nextInt();
		int i=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		while(i<n) {
			getBookDetails();
			i++;
		}
		
	}
}

