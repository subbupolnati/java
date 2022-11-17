<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>   
<%
ProductConn pcon=new ProductConn();
List<Product> products=pcon.all_Product_Details();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp" %>
<meta name="viewport" content="width=device-width, initial-scale=1;image/jpeg">
 
<title>Home</title>
<style>
@charset "ISO-8859-1";
</style>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=p.getImage()%>"alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getProduct_name()%></h5>
						<h6 class="price">Price: $<%=p.getProduct_price()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="update_product.jsp?id=<%=p.getProduct_id()%>">Edit</a> <a
								class="btn btn-primary" href="delete_product.jsp?id=<%=p.getProduct_id()%>">Delete</a>
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