<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>   
<%
ProductConn pcon=new ProductConn();
Product product=new Product();
String search=request.getParameter("search");
product.setProduct_name(search);
product.setProduct_category(search);

%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/includes/navbar.jsp" %>
<div class="container">
		<div class="row">
		<%List<Product> products=new ArrayList();
		Connection con=pcon.dbconnection();
		String sql="select * from products where product_name like '%"+product.getProduct_name()+"%' or category like '%"+product.getProduct_category()+"%'and active='yes'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next()) {
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_category(rs.getString("category"));
			product.setActive(rs.getString("active"));
			product.setProduct_price(rs.getFloat("price"));
			product.setImage(rs.getString("image"));
			products.add(product);
		} 
		%>
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=p.getImage() %>"
						alt="Card image cap">
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
</html>