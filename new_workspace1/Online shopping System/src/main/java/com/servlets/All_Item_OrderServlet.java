package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.ProductConn;
import com.product.Cart;

/**
 * Servlet implementation class All_Item_OrderServlet
 */
@WebServlet("/All_Item_OrderServlet")
public class All_Item_OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All_Item_OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductConn pcon=new ProductConn();
		String email=(String)request.getSession(false).getAttribute("uname");
		Cart cart=new Cart();
		cart.setEmail(email);
		try {
			int n=pcon.checkout_Items(cart);
			if(n>0) {
				response.sendRedirect("Add_Address.jsp?msg=success");
			}
			else {
				response.sendRedirect("cart.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
