<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.databaseconnection.*" %>
<%@ page import="com.servlets.*" %>
<%@ page import="java.sql.*" %> 
<%
	ProductConn pcon=new ProductConn();
	List<Product> products=pcon.all_Product_Details();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp"%>
<title>Home</title>

</head>
<body>

<%@ include file="/includes/navbar.jsp"  %>

<div class="container-fluid">
	<%String msg=request.getParameter("msg"); 
		if("done".equals(msg)){
	%>
	<h3>Cart Added Successfully</h3>
	<%} %>
	<%if("notexist".equals(msg)){
		%>
		<h3>item is not available to cart</h3>
		<%} %>
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="data:image/jpg;Base64,<%=p.getImage()%>" width="300px" height="300px" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getProduct_name()%></h5>
						<h6 class="price">Price: $<%=p.getProduct_price() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="Add_To_Cart?id=<%=p.getProduct_id()%>">ADD To Cart</a> 
							<a class="btn btn-primary" href="Order_ItemServlet?id=<%=p.getProduct_id()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
<%@include file="/includes/footer.jsp"%>
</body>
</html>
 