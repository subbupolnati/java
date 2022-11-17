package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.Address;
import com.customer.Customer;
import com.databaseconnection.CustomerConn;
import com.databaseconnection.ProductConn;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddressServlet() {
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
		Address address=new Address();
		Customer cust=new Customer();
		cust.setEmail(request.getParameter("email"));
		cust.setFullname(request.getParameter("name"));
		cust.setMobileno(Long.parseLong(request.getParameter("mobile")));
		address.setAddress(request.getParameter("address"));
		address.setCity(request.getParameter("city"));
		address.setCountry(request.getParameter("country"));
		address.setState(request.getParameter("state"));
		address.setPincode(Integer.parseInt(request.getParameter("pincode")));
		try {
			int n=custcon.address_Register(address, cust);
			if(n>0) {
				response.sendRedirect("payment.jsp?msg=done");
			}
			else {
				response.sendRedirect("Add_address.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
