<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>
    <%
  		ProductConn pcon=new ProductConn();
    	String email1=(String)request.getSession(false).getAttribute("uname");
		Customer cust=new Customer();
		cust.setEmail(email1);
    	List<Cart> cartProduct=pcon.getCart(cust);
    	float total=pcon.getTotalCartPrice(cartProduct);
    	
      %>
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
		<div class="d-flex py-3"><h3>Total Price: $<%out.println((total>0)?total:0.0); %></h3> <a class="mx-3 btn btn-primary" href="#">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scopr="col">Buy</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if ( cartProduct!= null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getProduct_name() %></td>
					<td><%=c.getProduct_category()%></td>
					<td><%=c.getProduct_price()%></td>
					<td><input type="hidden" name="id" value="<%= c.getProduct_id()%>" class="form-input-sm">
						<div class="form-group d-flex justify-content-between">
							<a class="btn btn-sm btn-incre" href="QuantityIncDecServlet?action=inc&id=<%=c.getProduct_id()%>"><i class="fas fa-plus-square"></i></a> 
							<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
							<a class="btn btn-sm btn-decre" href="QuantityIncDecServlet?action=dec&id=<%=c.getProduct_id()%>"><i class="fas fa-minus-square"></i></a>
						</div>
					</td>
					<td><a href="Order_ItemServlet?id=<%=c.getProduct_id()%>" class="btn btn-sm btn-success">Buy</a></td>
					<td><a href="RemoveCart?id=<%=c.getProduct_id()%>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>