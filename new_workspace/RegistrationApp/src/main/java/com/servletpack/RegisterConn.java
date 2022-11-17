package com.servletpack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterConn {
	
	public void registerConn(Register register) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:admin";
		String dbname="c##scott";
		String dbpass="tiger";
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="call insert_register(?,?,?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,register.getUsername());
		stmt.setString(2,register.getPassword());
		stmt.setString(3,register.getEmail());
		stmt.setString(4,register.getAddress());
		stmt.setString(5,register.getGender());
		stmt.setString(6,register.getQualification());
		stmt.execute();	
	}
}
