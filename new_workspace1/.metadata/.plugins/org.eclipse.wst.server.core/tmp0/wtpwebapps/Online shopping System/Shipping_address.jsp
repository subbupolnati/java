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
<%@include file="/includes/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<%String msg=request.getParameter("msg");
if("success".equals(msg)){
%>
<h2 align="center" style="color:red">Product ordered Successfully please entered delivery Address </h2>
<%} %>

<div class="container my-3"><h1>Orders Page</h1>
		<div class="d-flex py-3">
		<table class="table table-light" border="1px">
		<tr>		<th scop="col">Select</th>
					<th scope="col">Fullname</th>
					<th scope="col">Street</th>
					<th scope="col">City</th>
					<th scope="col">County</th>
					<th scope="col">State</th>
					<th scope="col">pincode</th>
					<th scope="col">mobileno</th>
		</tr>
		  </table>
		</div>
		</div>
	
</body>
</html>