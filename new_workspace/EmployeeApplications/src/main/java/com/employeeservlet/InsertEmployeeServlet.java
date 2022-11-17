package com.employeeservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Employee;
import com.employeedb.EmployeeConn;
@WebServlet("/InsertEmployeeServlet")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertEmployeeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		String ename=request.getParameter("ename");
		int salary=Integer.parseInt(request.getParameter("sal"));
		Date doj=Date.valueOf(request.getParameter("date"));
		//out.println(doj);
		String address=request.getParameter("address");	
		Employee employee=new Employee();
		EmployeeConn empcon=new EmployeeConn();
		employee.setEmpid(empid);
		employee.setEname(ename);
		employee.setSalary(salary);
		employee.setDoj(doj);
		employee.setAddress(address);
		try {
			empcon.employeeInsert(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<h1>registration completed successfully</h1>");
	}
	/*String sql="insert into employee1 values(?,?,?,?,?)";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:admin";
		String dbname="c##scott";
		String dbpass="tiger";
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,empid);
		stmt.setString(2,ename);
		stmt.setInt(3,salary);
		stmt.setDate(4,doj);
		stmt.setString(5,address);
		stmt.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/

}
