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
<form action="selected_customer.jsp" method="post">
<div class="form-group col-4">
    <label>Enter Email</label>
    <input type="email" class="form-control" name="email" placeholder="enter email">
    <input type="submit" class="btn btn-primary" value="search">
  </div>
</form>

<%
	String email =request.getParameter("email");
	Customer customer=new Customer();
	customer.setEmail(email);
	CustomerConn custcon=new CustomerConn();
	List<Customer> selectedCustomer=custcon.selectedCustomer(customer);
%>
<table class="table table-hover container">
  <thead>
    <tr>
      <th scope="col">FullName</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
      <th scope="col">Gender</th>
      <th scope="col">MobileNumber</th>
    </tr>
  </thead>
  <tbody>
  <% if(selectedCustomer !=null){
	 	for(Customer c:selectedCustomer){ 
	  %>
    <tr>
      <td><%=c.getFullname() %></td>
      <td><%=c.getEmail() %></td>
      <td><%=c.getPassword() %></td>
      <td><%=c.getGender() %></td>
      <td><%=c.getMobileno() %></td>
    </tr>
    <%}} 
  else{
    %>
    <h6>No customers Available</h6>
    <%} %>
  </tbody>
</table>
<%@include file="/includes/footer.jsp" %>
</body>
</html>