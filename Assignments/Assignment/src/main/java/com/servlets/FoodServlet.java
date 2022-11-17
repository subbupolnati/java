package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=0;
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
			String ch=request.getParameter("choice");
			System.out.println(ch);
			String sql=" update food set vote=vote+1 where food=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,ch);
			st.execute();
			String sql1="select * from food order by vote desc";
			 st=con.prepareStatement(sql1);
			ResultSet rs = st.executeQuery(sql1);
			out.println("<html><head></head><body><table align=center border=1px><tr><th>Food</th><th>Vote</th></tr>");
			while(rs.next()) {
				//System.out.println(""+rs.getString("food"));
				out.println("<tr><td>"+rs.getString("food")+"</td>"+"<td>"+rs.getInt("vote")+"</td></tr>");
			}
			out.println("</table></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
