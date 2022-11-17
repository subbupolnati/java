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
import com.product.Orders;
import com.product.Product;

/**
 * Servlet implementation class Order_ItemSrevlet
 */
@WebServlet("/Order_ItemServlet")
public class Order_ItemSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Order_ItemSrevlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductConn pcon=new ProductConn();
		int pid=Integer.parseInt(request.getParameter("id"));
		String email=(String)request.getSession(false).getAttribute("uname");;
		Cart cart=new Cart();
		cart.setEmail(email);
		cart.setProduct_id(pid);
		try {
			int n=pcon.order_Items(cart);
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
