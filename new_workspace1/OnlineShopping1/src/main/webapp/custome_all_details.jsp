<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/adminstyle.css">
<meta charset="ISO-8859-1">
<style>
.card{
 margin-top:5%;

}

</style>
<title>Home</title><%@ include file="/includes/head.jsp" %>
  <meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>

<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.CustomerConn" %>
<div align="center" class="card">
<table border="1px">
<%
	CustomerConn custcon=new CustomerConn();
	ResultSet rs=custcon.customer_All_Details();
	out.println("<h1>All Customer Details</h1>");
	out.println("<tr><th>First_Name</th><th>Last_Name</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>mobileNumber</th></tr>");
	while(rs.next()){
		out.println("<tr><td>"+rs.getString("first_name")+"</td>"+"<td>"+rs.getString("last_name")+"</td>"+
				"<td>"+rs.getString("username")+"</td>"+"<td>"+rs.getString("password")+"</td>"+
				"<td>"+rs.getString("email")+"</td>"+"<td>"+rs.getString("gender")+"</td>"+"<td>"+rs.getLong("mobilenumber")+"</td></tr>");
	}

%>
</table>
</div>
<%@include file="/includes/footer.jsp"%>
</body>
</html>