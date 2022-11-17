<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>
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
<%String msg=request.getParameter("msg");
if("added".equals(msg)){
%>
<h2 align="center" style="color:red">Product added Successfully in cart </h2>
<%} %>
<%if("exist".equals(msg)){
%>
<h2 align="center" style="color:red">Product already cart in cart </h2>
<%} %>
<%if("remove".equals(msg)){
%>
<h2 align="center" style="color:red">Product removed Successfully in cart </h2>
<%} %>
<%if("invalid".equals(msg)){
%>
<h2 align="center" style="color:red">Something went to wrong please check </h2>
<%} %>
	<div class="container my-3">
		<div class="d-flex py-3">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">OrderId</th>
					<th scope="col">Product_name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Price</th>
				</tr>
			</thead>
			<tbody>
			<tr>
			<% ProductConn pcon=new ProductConn();
			Customer cust=new Customer();
			cust.setEmail(email);
			ResultSet rs=pcon.getOrders(cust);
			while(rs.next()){
			%>
			<td><%=rs.getInt("order_id") %></td>
			<td><%=rs.getString("product_name") %></td>
			<td><%=rs.getInt("qunatity") %></td>
			<td><%=rs.getFloat("total_price") %></td>
			<%} %>
			</tr>
			</tbody>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>