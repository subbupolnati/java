import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameRecordView {
	public void viewGame() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		String sql="select * from game order by game_id asc";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int gameid=rs.getInt("game_id");
			String gamename=rs.getString("game_name");
			int players=rs.getInt("no_of_players");
			
			System.out.println(gameid+" "+gamename+" "+players);
		} 
		con.close();
	}
}
