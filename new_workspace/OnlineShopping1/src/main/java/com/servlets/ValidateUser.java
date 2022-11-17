package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.Customer;
import com.databaseconnection.CustomerConn;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=0;
    public ValidateUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("t1");
		String pass=request.getParameter("t2");
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setEmail(email);
		customer.setPassword(pass);
		try {
			ResultSet rs=custcon.loginConn(customer);
			//Customer user=custcon.userLogin(uname, pass);
			if(rs.next()) {
				if(email.equals(rs.getString("email"))&& pass.equals(rs.getString("password"))) {
					HttpSession sess=request.getSession();
					sess.setAttribute("sessId",sess.getId());
					sess.setAttribute("ctime", sess.getCreationTime());
					System.out.println(sess.getId());
					sess.setAttribute("uname",email);
					//sess.setAttribute("pass",pass);
					response.sendRedirect("products.jsp");
					//count=count+1;
					//System.out.println(count);
					//RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
					//rd.include(request, response);
				}
			}
			out.println("<h1 style=color:red>Invalid login Details</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("loginpage.jsp");
			rd.include(request, response);
			//response.sendRedirect("loginpage.jsp?msg=invalid");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
