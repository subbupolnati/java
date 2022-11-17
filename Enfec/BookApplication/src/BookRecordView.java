import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookRecordView {
	public void viewBook() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		String sql="select * from book order by bookid asc";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int bookid=rs.getInt("bookid");
			String bname=rs.getString("bname");
			int price=rs.getInt("price");
			String author=rs.getString("author");
			System.out.println(bookid+" "+bname+" "+price+" "+author);
		} 
		con.close();
	}
}
