package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.customer.Customer;

public class CustomerConn {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott";
	public static String dbpass="tiger";
	public static Connection dbconnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		return con;
	}
	public void registerConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="call insert_user_register(?,?,?,?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,customer.getFirst_name());
		stmt.setString(2,customer.getLast_name());
		stmt.setString(3,customer.getUsername());
		stmt.setString(4,customer.getPassword());
		stmt.setString(5,customer.getEmail());
		stmt.setString(6, customer.getGender());
		stmt.setLong(7,customer.getMobileno());
		stmt.execute();
	}
	public void adminRegisterConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="call insert_admin(?,?,?,?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,customer.getFirst_name());
		stmt.setString(2,customer.getLast_name());
		stmt.setString(3,customer.getUsername());
		stmt.setString(4,customer.getPassword());
		stmt.setString(5,customer.getEmail());
		stmt.setString(6, customer.getGender());
		stmt.setLong(7,customer.getMobileno());
		stmt.execute();
	}
	public Customer userLogin(String uname, String password) {
		Customer user = null;
		return user;
	}
	public ResultSet loginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register where username=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getUsername());
		st.setString(2,customer.getPassword());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public ResultSet adminLoginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from admin where username=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getUsername());
		st.setString(2,customer.getPassword());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public ResultSet customer_All_Details() throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public ResultSet selectedCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register where username=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getUsername());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public int deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from user_register where username=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getUsername());
		int n=st.executeUpdate();
		return n;
	}
	public int update_Cust(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="update user_register set first_name=?,last_name=?,email=?,mobilenumber=? where username=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,customer.getFirst_name());
		stmt.setString(2,customer.getLast_name());
		stmt.setString(3,customer.getEmail());
		stmt.setLong(4,customer.getMobileno());
		stmt.setString(5,customer.getUsername());
		int n=stmt.executeUpdate();
		return n;
	}
}
