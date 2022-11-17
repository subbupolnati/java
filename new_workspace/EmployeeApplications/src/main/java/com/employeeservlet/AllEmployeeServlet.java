package com.employeeservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.Employee;
import com.employeedb.EmployeeConn;

/**
 * Servlet implementation class AllEmployeeServlet
 */
@WebServlet("/AllEmployeeServlet")
public class AllEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employee employee=new Employee();
		EmployeeConn empcon=new EmployeeConn();
		try {
			ResultSet rs=empcon.employeeDetails(employee);
			out.println("<html><head></head><body><table align=center border=1px><tr><th>Empid</th><th>Ename</th><th>salary</th><th>doj</th><th>Address</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getInt("empid")+"</td>"+"<td>"+rs.getString("ename")+"</td>"+"<td>"+rs.getInt("salary")+"</td>"+"<td>"+rs.getDate("doj")+"</td>"+"<td>"+rs.getString("address")+"</td></tr>");
			}
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*String sql="select * from employee1 ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:admin";
			String dbname="c##scott";
			String dbpass="tiger";
			Connection con=DriverManager.getConnection(url,dbname,dbpass);
			PreparedStatement stmt=con.prepareStatement(sql);;
			ResultSet rs=stmt.executeQuery();
			out.println("<html><head></head><body><table align=center border=1px><tr><th>Empid</th><th>Ename</th><th>salary</th><th>doj</th><th>Address</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getInt("empid")+"</td>"+"<td>"+rs.getString("ename")+"</td>"+"<td>"+rs.getInt("salary")+"</td>"+"<td>"+rs.getDate("doj")+"</td>"+"<td>"+rs.getString("address")+"</td></tr>");
			}
			out.println("</table></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
