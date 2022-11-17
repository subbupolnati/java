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

@WebServlet("/Deleted_customer")
public class Deleted_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Deleted_customer() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setUsername(uname);
		try {
			int n=custcon.deleteCustomer(customer);
			System.out.println(n);
			if(n>0) {
				request.setAttribute("msg","deleted sucessffully"); 
				RequestDispatcher rd=request.getRequestDispatcher("deleted_customer.jsp");
				rd.forward(request, response);
			}
			else {
				//out.println("<h1>customer details not found</h1>");
				request.setAttribute("msg","customer details not found"); 
				RequestDispatcher rd=request.getRequestDispatcher("deleted_customer.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
