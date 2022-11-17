import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GameRecordDelete {
	public  int game_id;
	public void deleteRecord() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		//load and register class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");//create connections
		System.out.println("enter delete row id");
		game_id=sc.nextInt();
		String sql="delete from game where game_id=?";
		PreparedStatement stmt=con.prepareStatement(sql);//create statement
		stmt.setInt(1, game_id);
		stmt.executeUpdate();
		System.out.println("row is delete succesfully");
		con.close();
	}
}
