<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.databaseconnection.*" %>
<%@ page import="com.servlets.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp" %>
<title>Login Page</title>
<style>
body{
	background-image:url("login1.jpg");
	background-repeat: no-repeat;
  	background-attachment: fixed; 
  	background-size: 100% 100%;
	color:white;
}
</style>
</head>
<body>
<% 
String msg=request.getParameter("msg");
if("invalid".equals(msg)){
%>
<h1 align="center" style=color:red>Invalid login Details</h1>
<%} %>
<%
if("done".equals(msg)){
%>
<h1 align="center" style=color:red>Password reset successfully</h1>
<% } %>
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center text-dark">User Login</div>
			<div class="card-body">
				<form action="ValidateUser" method="post">
				<div class="form-group">
						<label>Email</label> 
						<input type="email" name="t1" placeholder="email" class="form-control"required >
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="t2" class="form-control" placeholder="Password" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
						<a href="resetpassword.jsp" style="color:black" >forget password</a>
					</div>
					
					<div class="text-center">
					<h6 class="text-dark">If you have Admin<a href="adminlogin.jsp">
						<input type="button" class="btn btn-primary"value="AdminLogin"></a></h6>
					</div><div class="text-center">
					<h6 class="text-dark">If you don't  have account<a href="register.jsp">
						<input type="button" class="btn btn-primary"value="register"></a></h6>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>