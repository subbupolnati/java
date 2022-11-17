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

/**
 * Servlet implementation class Update_customer
 */
@WebServlet("/Update_customer")
public class Update_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
		String uname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		Customer customer=new Customer();
		CustomerConn custcon=new CustomerConn();
		customer.setUsername(uname);
		customer.setFirst_name(fname);
		customer.setLast_name(lname);
		customer.setEmail(email);
		customer.setMobileno(mobile);
		try {
			int row=custcon.update_Cust(customer);
			System.out.println(row);
			if(row>0) {
				out.println("<h1>updated succesfully</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("update_details.jsp");

				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("update_details.jsp");
				out.println("<h1>no data found</h1>");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
