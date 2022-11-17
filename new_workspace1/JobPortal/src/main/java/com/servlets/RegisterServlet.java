package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jobportal.dao.JobPortalDAO;
import com.jobseeker.bean.JobSeekers;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
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
		JobSeekers js=new JobSeekers();
		JobPortalDAO jpdao=new JobPortalDAO();
		try {
			Connection con=jpdao.dbconnection();
			PreparedStatement st=con.prepareStatement("insert into jobseeker values(?,?,?,?,?,?,?)");
			st.setString(1,request.getParameter("name"));
			st.setString(2,request.getParameter("email"));
			st.setString(3,request.getParameter("gender"));
			st.setLong(4,Long.parseLong(request.getParameter("mobile")));
			st.setString(5,request.getParameter("qul"));
			st.setInt(6,Integer.parseInt(request.getParameter("yop")));
			Part f=request.getPart("resume");
			InputStream is=f.getInputStream();
			st.setBlob(7, is);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
