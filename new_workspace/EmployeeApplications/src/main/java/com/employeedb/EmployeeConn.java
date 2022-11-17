package com.employeedb;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.Employee;

public class EmployeeConn {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott";
	public static String dbpass="tiger";
	public void employeeInsert(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="insert into employee1 values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,employee.getEmpid());
		stmt.setString(2,employee.getEname());
		stmt.setInt(3,employee.getSalary());
		stmt.setDate(4,(Date) employee.getDoj());
		stmt.setString(5,employee.getAddress());
		stmt.executeUpdate();
	}
	public void employeeUpdate(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="update employee1 set ename=?,salary=?,address=? where empid=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,employee.getEname());
		stmt.setInt(2,employee.getSalary());
		stmt.setString(3,employee.getAddress());
		stmt.setInt(4,employee.getEmpid());
		stmt.executeUpdate();
	}
	public void employeeDelete(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="delete from employee1 where empid=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,employee.getEmpid());
		stmt.executeUpdate();
	}
	public ResultSet employeeSearch(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="select * from employee1 where empid=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,employee.getEmpid());
		ResultSet rs=stmt.executeQuery();
		return rs;
		
	}
	public ResultSet employeeDetails(Employee employee) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		String sql="select * from employee1";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		return rs;
	}
}
