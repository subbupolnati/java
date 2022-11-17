package com.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calaculator
 */
@WebServlet("/Calaculator")
public class Calaculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Calaculator() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int a=Integer.parseInt(request.getParameter("t1"));
		int b=Integer.parseInt(request.getParameter("t2"));
		int c;
		if("ADD".equals(request.getParameter("add"))) {
			c=a+b;
			out.println("<h1>Addition is:: "+c+"</h1>");
		}
		if("SUB".equals(request.getParameter("sub"))) {
			c=a-b;
			out.println("<h1>Subtraction is:: "+c+"</h1>");
		}
		if("MUL".equals(request.getParameter("mul"))) {
			c=a*b;
			out.println("<h1>Multiplication is:: "+c+"</h1>");
		}
		if("DIV".equals(request.getParameter("div"))) {
			c=a/b;
			out.println("<h1>Division is ::"+c+"</h1>");
		}
	}

}
