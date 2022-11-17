import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GameRecordUpdate {
	public static int game_id;
	public static String game_name;
	public static int no_of_players;
	public static int newgame_id;
	public static String sql; 
	public static String updateGameid() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter old game id");
		game_id=sc.nextInt();
		System.out.println("enter new game id");
		newgame_id=sc.nextInt();
		sql="update game set game_id="+newgame_id+"where game_id="+game_id;
		return sql;
	}
	public static String updateGameName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter game name");
		game_name=sc.next();
		sql="update game set game_name="+game_name+"where game_id="+game_id;
		return sql;
	}
	public static String updateGamePlayers() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter game players");
		no_of_players=sc.nextInt();
		sql="update game set no_of_players="+no_of_players+"where game_id="+game_id;
		return sql;
	}
	public void updateGame() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int row;
		char ch='y';
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		Statement stmt=con.createStatement();
		do {
			System.out.println("enter update values\n 1.game_id\n 2.Game_name\n 3.players\n ");
			int opt=sc.nextInt();
			switch(opt) {
				case 1:
					updateGameid();
					row=stmt.executeUpdate(sql);
					System.out.println("game id updated successfully");
					break;
				case 2:
					updateGameName();
					row=stmt.executeUpdate(sql);
					System.out.println("game name updated successfully");
					break;
				case 3:
					updateGamePlayers();
					row=stmt.executeUpdate(sql);
					System.out.println("game players updated successfully");
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
