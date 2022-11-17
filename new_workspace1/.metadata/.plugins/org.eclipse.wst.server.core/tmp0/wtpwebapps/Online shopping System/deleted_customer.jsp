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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<%@ include file="/includes/head.jsp" %>
<title>Home</title>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<h1>Selected Customer Details</h1>
<form action="Deleted_Customer" method="post">
<div class="form-group col-4">
    <label>Enter Email</label>
    <input type="email" class="form-control" name="email" placeholder="enter email">
    <input type="submit" class="btn btn-primary" value="search">
  </div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>