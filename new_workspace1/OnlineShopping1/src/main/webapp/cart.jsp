<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>
    <%
    ArrayList<Cart> cart_list = (ArrayList<Cart>)session.getAttribute("cart_list");
    List<Cart> cartProduct = null;
    if (cart_list != null) {
    	ProductConn pcon=new ProductConn();
    	cartProduct = pcon.getCartProducts(cart_list);
    	double total = pcon.getTotalCartPrice(cart_list);
    	request.setAttribute("total", total);
    	request.setAttribute("cart_list", cart_list);
    }
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
</style>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?total:0} </h3> <a class="mx-3 btn btn-primary" href="#">Check Out</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getProduct_name() %></td>
					<td><%=c.getProduct_category_id()%></td>
					<td><%=c.getProduct_price()%></td>
					<td>
						<form action="#" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getProduct_id()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="QuantityIncDecServlet?action=inc&id=<%=c.getProduct_id()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="QuantityIncDecServlet?action=dec&id=<%=c.getProduct_id()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%=c.getProduct_id()%>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>