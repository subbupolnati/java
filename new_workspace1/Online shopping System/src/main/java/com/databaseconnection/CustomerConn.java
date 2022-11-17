package com.databaseconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	// in this method implementation user registration in RegisterServlet call this method
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
	// in this method implementation user admin registration in AdminRegisterServlet call this method
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
	// in this method implemetation user password update in Resetpassword call this method
	public int CustResetPassword(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		PreparedStatement st=con.prepareStatement("update user_register set password=? where email=? and mobilenumber=?");
		st.setString(1,customer.getPassword());
		st.setString(2,customer.getEmail());
		st.setLong(3,customer.getMobileno());
		int n=st.executeUpdate();
		return n;
	}
	// in this method implementation login connection checking in ValidateUser call this method
	public ResultSet loginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register where email=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		st.setString(2,customer.getPassword());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	// in this method implementation adminlogin connection checking in Admin ValidateUser call this method
	public ResultSet adminLoginConn(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from admin where email=? and password=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		st.setString(2,customer.getPassword());
		ResultSet rs=st.executeQuery();
		return rs;
	}
	// in this method implementation customer All Details in admin portal
	public ResultSet customer_All_Details() throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="select * from user_register";
		PreparedStatement st=con.prepareStatement(sql);
		ResultSet rs=st.executeQuery();
		return rs;
	}
	//	// in this method implementation Selected customer search using email in admin portal
	public List<Customer> selectedCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		List<Customer> selectedCustomer=new ArrayList<Customer>();
		String sql="select * from user_register where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Customer cust=new Customer();
			cust.setFullname(rs.getString("fullname"));
			cust.setEmail(rs.getString("email"));
			cust.setGender(rs.getString("gender"));
			cust.setMobileno(rs.getLong("mobilenumber"));
			cust.setPassword(rs.getString("password"));
			selectedCustomer.add(cust);
		}
		return selectedCustomer;
	}
	// in this method implementation delete customer using email in admin portal
	public int deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="delete from user_register where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,customer.getEmail());
		int n=st.executeUpdate();
		return n;
	}
	// in this method implementation Update customer details using email in admin portal
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
	// in this method implementation customer Address registration 
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
