import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookRecordDelete {
	public static int bookid;
	//delete operation based on user requirement
	public void deleteBook() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter delete row id");
		bookid=sc.nextInt();
		String sql="delete from book where bookid="+bookid;
		//load and register class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");//create connections
		Statement stmt=con.createStatement();//create statement
		stmt.executeUpdate(sql);
		System.out.println("row is delete succesfully");
		con.close();
		}
}
