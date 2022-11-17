
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load or register the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create connection object
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		//create statement object
		Statement stmt=con.createStatement();
		//execute query
		ResultSet rs=stmt.executeQuery("select * from emp order by emp_id asc");
		while(rs.next()) {
			System.out.println("employee_id:"+rs.getInt("emp_id"));
			System.out.println("employee_name:"+rs.getString("ename"));
		}
		//connection close
		con.close();
	}
}
