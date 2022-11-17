package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.Customer;
import com.databaseconnection.CustomerConn;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String fname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setFullname(fname);
		customer.setPassword(pass);
		customer.setEmail(email);
		customer.setGender(gender);
		customer.setMobileno(mobile);
		try {
			int n=custcon.registerConn(customer);
			if(n>0) {
			//out.println("<h1 align=center>registerd successfully</h1>");
			//RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			//rd.include(request, response);
			response.sendRedirect("register.jsp?msg=valid");
			}
			else {
				response.sendRedirect("register.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
