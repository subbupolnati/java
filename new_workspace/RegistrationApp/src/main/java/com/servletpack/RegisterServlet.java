package com.servletpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
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
		String uname=request.getParameter("t1");
		String pass=request.getParameter("p1");
		String mail=request.getParameter("m1");
		String address=request.getParameter("address");
		String gender=request.getParameter("r1");
		String qul=request.getParameter("qul");
		/*String sql="call insert_register(?,?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
			CallableStatement st=(CallableStatement) con.prepareCall(sql);
			st.setString(1,uname);
			st.setString(2,pass);
			st.setString(3,mail);
			st.setString(4,address);
			st.setString(5,gender);
			st.setString(6,qul);
			st.execute();
			out.println("registration completed successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Register register=new Register();
		RegisterConn regcon=new RegisterConn();
		register.setUsername(uname);
		register.setPassword(pass);
		register.setEmail(mail);
		register.setAddress(address);
		register.setGender(gender);
		register.setQualification(qul);
		try {
			regcon.registerConn(register);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<h1>registration completed successfully</h1>");
				}

}
