package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.databaseconnection.ProductConn;
import com.product.Product;

/**
 * Servlet implementation class Update_Product
 */
@WebServlet("/Update_Product")
public class Update_Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update_Product() {
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
		ProductConn pcon=new ProductConn();
		String id=(String)request.getParameter("pid").trim();
		int pid=Integer.parseInt(id);
		System.out.println(pid);
		try 
		{
			Connection con=pcon.dbconnection();
			String sql="update products set product_name=?,category=?,active=?,price=?,image=? where product_id=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(6,pid);
			stmt.setString(1,request.getParameter("pname"));
			stmt.setString(2,request.getParameter("pcat"));
			stmt.setString(3,request.getParameter("active"));
			stmt.setFloat(4,Float.parseFloat(request.getParameter("price")));
			Part fname=request.getPart("filename");
			InputStream is=fname.getInputStream();
			stmt.setBlob(5,is);
			int n=stmt.executeUpdate();
			if(n>0) {
				response.sendRedirect("update_product.jsp?msg=valid");
			}
			else
			{
				response.sendRedirect("update_product.jsp?msg=invalid");
			}
		}catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
	
}
