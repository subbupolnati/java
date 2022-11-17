package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.Customer;
import com.databaseconnection.CustomerConn;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		CustomerConn custcon=new CustomerConn();
		Customer cust=new Customer();
		cust.setEmail(request.getParameter("email"));
		cust.setMobileno(Long.parseLong(request.getParameter("mobile")));
		cust.setPassword(request.getParameter("password"));
		try {
			int n=custcon.CustResetPassword(cust);
			if(n>0) {
				response.sendRedirect("loginpage.jsp?msg=done");
			}
			else {
				response.sendRedirect("resetpassword.jsp?invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
