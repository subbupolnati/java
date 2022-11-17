<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.CustomerConn" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<style>
.card{
margin:10px 250px 0px 250px;
margin-top:50px;
}

</style>
<title>Home</title>
<%@include file="/includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<div class="container my-3">
<%String msg=request.getParameter("msg");
if("done".equals(msg)){
%>
<h2 align="center" style="color:red">updated Successfully </h2>
<%} %>
<%if("invalid".equals(msg)){
%>
<h2 align="center" style="color:red">Something we went wrong </h2>
<%} %>
<div><form action="update_customer.jsp">
<input type="text" name="email" placeholder="enter email">
<input type="submit" value="update" class="btn btn-sm btn-success">
</form></div>

<h1>All Customer Details</h1>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">password</th>
					<th scope="col">Gender</th>
					<th scope="col">MobileNumber</th>
				</tr>
			</thead>
			<tbody>
				<%
					CustomerConn custcon=new CustomerConn();
					ResultSet rs=custcon.customer_All_Details();
					while(rs.next()){
				%>
				<tr>
					<td><%=rs.getString("fullname") %></td>
					<td><%=rs.getString("email") %></td>
					<td><%=rs.getString("password") %></td>
					<td><%=rs.getString("gender") %></td>
					<td><%=rs.getLong("mobilenumber") %></td>
					</tr>
					<%} %>
					</tbody>
</table>
</div>
<%@include file="/includes/footer.jsp"%>
</body>
</html>