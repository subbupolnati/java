package com.employeeservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Employee;
import com.employeedb.EmployeeConn;
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		String ename=request.getParameter("ename");
		int salary=Integer.parseInt(request.getParameter("sal"));
		String address=request.getParameter("address");
		Employee employee=new Employee();
		EmployeeConn empcon=new EmployeeConn();
		employee.setEmpid(empid);
		employee.setEname(ename);
		employee.setSalary(salary);
		employee.setAddress(address);
		try {
			empcon.employeeUpdate(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<h1>updated successfully</h1>");
		/*String sql="update employee1 set ename=?,salary=?,address=? where empid=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:admin";
			String dbname="c##scott";
			String dbpass="tiger";
			Connection con=DriverManager.getConnection(url,dbname,dbpass);
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,ename);
			stmt.setInt(2,salary);
			stmt.setString(3, address);
			stmt.setInt(4,empid);
			stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
