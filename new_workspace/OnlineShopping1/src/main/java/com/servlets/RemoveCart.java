package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.ProductConn;
import com.product.Product;

/**
 * Servlet implementation class RemoveCart
 */
@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RemoveCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductConn pcon=new ProductConn();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product=new Product();
		product.setProduct_id(id);
		try {
			int n=pcon.removeCart(product);
			if(n>0) {
				response.sendRedirect("cart.jsp?msg=remove");
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
