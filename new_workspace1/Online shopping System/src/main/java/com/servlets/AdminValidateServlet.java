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
 * Servlet implementation class AdminValidateServlet
 */
@WebServlet("/AdminValidateServlet")
public class AdminValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminValidateServlet() {
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
			ResultSet rs=custcon.adminLoginConn(customer);
			if(rs.next()) {
				if(email.equals(rs.getString("email"))&& pass.equals(rs.getString("password"))) {
					HttpSession sess=request.getSession();
					sess.setAttribute("sessId",sess.getId());
					sess.setAttribute("ctime", sess.getCreationTime());
					System.out.println(sess.getId());
					sess.setAttribute("uname",email);
					response.sendRedirect("admin_home_page.jsp");
				}
			}
			//response.sendRedirect("adminlogin.jsp?msg=invalid");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
