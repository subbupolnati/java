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
		Part p=request.getPart("image");
		int id=1;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		String sql="insert into image values(?,?)";
		try {
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		InputStream is=p.getInputStream();
		pstmt.setBlob(2, is);
		int r=pstmt.executeUpdate();
		out.println("Image Inserted Successfully");
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		}
}
