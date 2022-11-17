package com.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.databaseconnection.ProductConn;
import com.product.Product;
//Adding the products in database using add_products servlet using dopost method action perform to add_products.jsp page
@MultipartConfig
@WebServlet("/Add_Products")
public class Add_Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add_Products() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("image/jpeg");  
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));//id fetch to add_products.jsp page
		//System.out.println(pid);
		String pname=request.getParameter("pname");
		String pcat=request.getParameter("pcat");
		String act =request.getParameter("active");
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
		Product product=new Product();//create object from produts
		ProductConn pconn=new ProductConn();//create object from productConn class its a dabase opertions perform
		product.setProduct_id(pid);
		product.setProduct_name(pname);
		product.setProduct_category(pcat);
		product.setActive(act);
		product.setProduct_price(price);
		product.setImage(imagefilename);
		System.out.println(price);
		try {
			int row=pconn.product_RegisterConn(product);//call to registerConn method in productConn class
			if(row>0) {
				response.sendRedirect("Add_product.jsp?msg=valid");
			}
			else
			{
				response.sendRedirect("Add_product.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}
