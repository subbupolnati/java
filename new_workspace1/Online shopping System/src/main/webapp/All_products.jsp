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
		<form  method="post">
  <input type="search"  name="search" placeholder="Search "><button type="submit"formaction="adminsearch.jsp"><i class="bi bi-search"></i>Search</button></
  </form>
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