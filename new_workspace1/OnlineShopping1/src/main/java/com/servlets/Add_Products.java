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

@MultipartConfig
@WebServlet("/Add_Products")
public class Add_Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Add_Products() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int pcid=Integer.parseInt(request.getParameter("pcid"));
		int avl_qun=Integer.parseInt(request.getParameter("avl"));
		double price=Double.parseDouble(request.getParameter("price"));
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
		product.setProduct_id(pid);
		product.setProduct_name(pname);
		product.setProduct_category_id(pcid);
		product.setAvailble_qunatity(avl_qun);
		product.setProduct_price(price);
		product.setImage(imagefilename);
		System.out.println(price);
		try {
			int row=pconn.product_RegisterConn(product);
			if(row>0) {
				out.println("<h1 align=center>registerd successfully</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("Add_product.jsp");
				rd.include(request, response);
			}
			else
			{
				System.out.println("data not insertes");
				out.println("<h1 align=center>data not insertes</h1>");
				RequestDispatcher rd=request.getRequestDispatcher("Add_product.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}
