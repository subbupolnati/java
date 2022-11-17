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
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setFullname(request.getParameter("uname"));
		customer.setPassword(request.getParameter("pass"));
		customer.setEmail(request.getParameter("email"));
		customer.setGender(request.getParameter("gender"));
		customer.setMobileno(Long.parseLong(request.getParameter("mobile")));
		try {
			int n=custcon.adminRegisterConn(customer);
			if(n>0) {
				response.sendRedirect("admin_register_page.jsp?msg=valid");
			}
			else {
				response.sendRedirect("admin_register_page.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
