package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseconnection.ProductConn;
import com.product.Cart;
import com.product.Product;

/**
 * Servlet implementation class QuantityIncDecServlet
 */
@WebServlet("/QuantityIncDecServlet")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QuantityIncDecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProductConn pcon=new ProductConn();
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		Product product=new Product();
		product.setProduct_id(id);
		if (action != null && id >= 1) {
			if (action.equals("inc")) {
						try {
							pcon.incrementQun(product);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						response.sendRedirect("cart.jsp");
			}
			if (action.equals("dec")) {
				try {
					pcon.decrementQun(product);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("cart.jsp");
			}
		} else {
			response.sendRedirect("cart.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
