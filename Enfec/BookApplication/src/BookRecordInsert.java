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
	public static String getBookDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book id");
		bookid=sc.nextInt();
		System.out.println("enter book name");
		bname=sc.next();
		System.out.println("enter book price");
		price=sc.nextInt();
		System.out.println("enter book authorName");
		author=sc.next();
		sql="insert into book values("+bookid+",'"+bname+"',"+price+",'"+author+"')";
		return sql;
	}
	//insertion operation performed
	public void insertBook() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("how many records entered");
		int n=sc.nextInt();
		int i=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		while(i<n) {
			getBookDetails();
			Statement stmt=con.createStatement();
			int rownum=stmt.executeUpdate(sql);
			System.out.println(rownum+ " row successfuly inserted");
			i++;
		}
		con.close();
	}
}

