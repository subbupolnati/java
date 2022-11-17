import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GameRecordInsert {
	public static int game_id;
	public static String game_name;
	public static int no_of_players;
	public static String sql;
	//user entered game details
	public static String getGameDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter game id");
		game_id=sc.nextInt();
		System.out.println("enter game name");
		game_name=sc.next();
		System.out.println("enter no_of_players");
		no_of_players=sc.nextInt();
		sql="insert into game values("+game_id+",'"+game_name+"',"+no_of_players+")";
		return sql;
	}
	//insertion operation performed
	public void insertGame() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("how many records entered");
		int n=sc.nextInt();
		int i=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		while(i<n) {
			getGameDetails();
			Statement stmt=con.createStatement();
			int rownum=stmt.executeUpdate(sql);
			System.out.println(rownum+ " row successfuly inserted");
			i++;
		}
		con.close();
	}
}
