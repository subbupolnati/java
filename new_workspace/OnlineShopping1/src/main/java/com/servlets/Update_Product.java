package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
		PrintWriter out=response.getWriter();
		System.out.println(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		String pname=request.getParameter("pname");
		String pcat=request.getParameter("pcat");
		String act=request.getParameter("active");
		float price=Float.parseFloat(request.getParameter("price"));
		Part fname=request.getPart("filename");
		String imagefilename=fname.getSubmittedFileName();
		System.out.println(imagefilename);
		String uploadpath="C:/new_workspace/OnlineShopping1/src/main/webapp/images/"+imagefilename;
		System.out.println(uploadpath);
		try {
			FileOutputStream fos=new FileOutputStream(uploadpath);
			InputStream is=fname.getInputStream();
			byte[] data=new byte[is.available()];
			is.read();
			fos.write(data);
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Product product=new Product();
		ProductConn pconn=new ProductConn();
		product.setProduct_id(id);
		product.setProduct_name(pname);
		product.setProduct_category(pcat);
		product.setActive(act);
		product.setProduct_price(price);
		product.setImage(imagefilename);
		try {
			int row=pconn.product_UpdateConn(product);
			if(row>0) {
				//out.println("<h1 align=center>updated successfully</h1>");
				//RequestDispatcher rd=request.getRequestDispatcher("update_product.jsp");
				//rd.include(request, response);
				response.sendRedirect("update_product.jsp?msg=valid");
			}
			else
			{
				//out.println("<h1 align=center>data not updated</h1>");
				//RequestDispatcher rd=request.getRequestDispatcher("update_product.jsp");
				//rd.include(request, response);
				response.sendRedirect("update_product.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
