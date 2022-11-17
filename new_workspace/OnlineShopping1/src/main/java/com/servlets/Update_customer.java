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
import com.customer.Customer;
import com.databaseconnection.CustomerConn;

@WebServlet("/Update_customer")
public class Update_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update_customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setFullname(name);
		customer.setMobileno(mobile);
		customer.setEmail(email);
		try {
			int row=custcon.update_Cust(customer);
			if(row>0) {
				response.sendRedirect("custome_all_details?msg=done");
			}
			else {
				response.sendRedirect("custome_all_details?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
