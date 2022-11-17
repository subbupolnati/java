package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobPortalDAO;
import com.jobseeker.bean.Recuriter;

@WebServlet("/RecuriterServlet")
public class RecuriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuriterServlet() {
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
		JobPortalDAO jcon=new JobPortalDAO();
		Recuriter r=new Recuriter();
		r.setFullname(request.getParameter("name"));
		r.setEmail(request.getParameter("email"));
		r.setCompanyname(request.getParameter("cname"));
		r.setMobile(Long.parseLong(request.getParameter("mobile")));
		r.setGender(request.getParameter("gender"));
		try {
			int n=jcon.recuriterInsert(r);
			if(n>0) {
				response.sendRedirect("Recruiter_register.jsp?msg=valid");
			}
			else {
				response.sendRedirect("Recruiter_register.jsp?msg=invalid");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
