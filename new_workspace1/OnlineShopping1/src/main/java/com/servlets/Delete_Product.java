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

import com.databaseconnection.ProductConn;
import com.product.Product;

/**
 * Servlet implementation class Delete_Product
 */
@WebServlet("/Delete_Product")
public class Delete_Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Delete_Product() {
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
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
		Product product=new Product();
		ProductConn pcon=new ProductConn();
		try {
			int row=pcon.deleteProduct(product);
			if(row>0) {
				request.setAttribute("msg","deleted sucessffully"); 
				RequestDispatcher rd=request.getRequestDispatcher("delete_product.jsp");
				rd.forward(request, response);
			}
			else {
				//out.println("<h1>customer details not found</h1>");
				request.setAttribute("msg","customer details not found"); 
				RequestDispatcher rd=request.getRequestDispatcher("delete_product.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
