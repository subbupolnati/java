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
<title>Insert title here</title>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
input[type=text]{
width:25%;
}
</style>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<% ProductConn pcon=new ProductConn();
			Customer cust=new Customer();
			cust.setEmail(email);
			pcon.getOrders(cust);
			List<Orders> ord=pcon.vieworders(cust);
%>

<%String msg=request.getParameter("msg");
if("success".equals(msg)){
%>
<h2 class="text-danger" align="center">Your Order is Successfully Completed </h2>
<%} %>

	<div class="container my-3"><h1>Orders Page</h1>
		<div class="d-flex py-3">
		<table class="table table-light" border="1px">
				<tr>
					<th scope="col">OrderId</th>
					<th scope="col">Product_name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Price</th>
				</tr>
			<%
				if ( ord!= null) {
					for (Orders o : ord) {
				%>
				<tr>
					<td><%=o.getOrder_id()%></td>
					<td><%=o.getProduct_name()%></td>
					<td><%=o.getQunatity()%></td>
					<td><%=o.getTotal_amount() %></td>
				</tr>
				<%
				}}%>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>