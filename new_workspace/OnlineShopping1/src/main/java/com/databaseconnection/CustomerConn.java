package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.customer.Address;
import com.customer.Customer;

public class CustomerConn {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott2";
	public static String dbpass="tiger";
	public static Connection dbconnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		return con;
	}
	public int registerConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into user_register values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,customer.getFullname());
		stmt.setString(2,customer.getEmail());
		stmt.setString(3,customer.getPassword());	
		stmt.setString(4, customer.getGender());
		stmt.setLong(5,customer.getMobileno());
		int n=stmt.executeUpdate();
		return n;
	}
	public int adminRegisterConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into admin values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,customer.getFullname());
		stmt.setString(2,customer.getEmail());
		stmt.setString(3,customer.getPassword());
		stmt.setString(4, customer.getGender());
		stmt.setLong(5,customer.getMobileno());
		int n=stmt.executeUpdate();
		return n;
	}
	public Customer userLogin(String uname, String password) {
		Customer user = null;
		return user;
	}
	public ResultSet loginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register where email=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		st.setString(2,customer.getPassword());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public ResultSet adminLoginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from admin where email=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
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
		String sql="select * from user_register where fullname=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getFullname());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	public int deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from user_register where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		int n=st.executeUpdate();
		return n;
	}
	public int update_Cust(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="update user_register set fullname=?,mobilenumber=? where email=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,customer.getFullname());
		stmt.setLong(2,customer.getMobileno());
		stmt.setString(3,customer.getEmail());
		int n=stmt.executeUpdate();
		return n;
	}
	public int address_Register(Address address,Customer cust) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into address values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,cust.getFullname());
		stmt.setString(2,cust.getEmail());
		stmt.setLong(3,cust.getMobileno());	
		stmt.setString(4,address.getAddress());
		stmt.setString(5,address.getCity());
		stmt.setString(6,address.getCountry());
		stmt.setString(7,address.getState());
		stmt.setInt(8,address.getPincode());
		int n=stmt.executeUpdate();
		return n;
	}
	
}
