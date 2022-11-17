package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=0;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("t1");
		String pass=request.getParameter("t2");
		HttpSession sess=request.getSession();
		count++;
		//out.println("count"+count);
		sess.setAttribute("count",count);
		out.println("count"+sess.getAttribute("count"));
		//response.sendRedirect("LoginSuccess");
		//RequestDispatcher rd=request.getRequestDispatcher("LogoutServlet");
		//rd.include(request, response);
	}

}
