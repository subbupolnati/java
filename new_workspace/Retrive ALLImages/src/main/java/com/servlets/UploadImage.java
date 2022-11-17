package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.Product;
import com.productdb.ProductDao;
@WebServlet("/UploadImage")
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public UploadImage() {
		super();
		// TODO Auto-generated constructor stub
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ProductDao pd=new ProductDao();
		Product product=new Product();
		int id=Integer.parseInt(request.getParameter("id"));
		Part p=request.getPart("image");
		Connection con;
		try {
			con = pd.getConnect();
			String sql="insert into image values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,id);
			InputStream is=p.getInputStream();
			pstmt.setBlob(2, is);
			int n=pstmt.executeUpdate();
			if(n>0) {
					System.out.println("data is inserted");
				}
				else
					System.out.println("data not inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
