<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="javax.servlet.*" %>
<%@page import="java.sql.*" %>
<div align="center" >
<%
	String uname=request.getParameter("t1");
	String pass=request.getParameter("p1");
	String rpass=request.getParameter("rp1");
	String mail=request.getParameter("m1");
	String address=request.getParameter("address");
	String gender=request.getParameter("r1");
	String qul=request.getParameter("qul");
	out.println("<h1>Registration Details</h1>");
	out.println("<html><body><table border=1>");
	out.println("<tr><th>Username</th><th>Password</th><th>Reenter Password</th><th>Email</th><th>Address</th><th>Gender</th><th>Qualification</th></tr>");
	out.println("<tr><td>"+uname+"</td>"+"<td>"+pass+"</td>"+"<td>"+rpass+"</td>"+"<td>"+mail+"</td>"+"<td>"+address+"</td>"+"<td>"+gender+"</td>"+"<td>"+qul+"</td></tr>");
	out.println("</table></body></html>");
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
%>
</div>
</body>
</html>