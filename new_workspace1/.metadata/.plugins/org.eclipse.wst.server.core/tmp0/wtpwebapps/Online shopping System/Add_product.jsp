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
    Product p=new Product();
    ProductConn pcon=new ProductConn();
    Connection con=pcon.dbconnection();
	int pid=1;//base instilaze productid
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select max(product_id) from products");//query from max id
	while(rs.next()) {
		pid=rs.getInt(1);
		pid+=1;
		p.setProduct_id(pid);
		//System.out.println(product.getProduct_id());
	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="/includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>

<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h1 align="center" style="color:red;">Product Add Successfully</h1>
<%}%>
<%
if("invalid".equals(msg)){
%>
<h1 align="center" style="color:red;">Something Went Wrong in Product Details  </h1>
<% }%>

<form action="Add_Products" method="post" enctype="multipart/form-data">
<div class="row justify-content-md-center my-5">
<div class="card col-6">
<h1 class="card-header"> Product register page</h1>
<table class="table">
<tr>
<td>Product_Id ::<%=p.getProduct_id() %></td>
<input type="hidden" name="pid" value="<%= p.getProduct_id()%>">
</tr>
<tr>
<td>Product_Name:</td>
<td><input type="text" name="pname" placeholder="productname" required></td>
</tr>
<tr>
<td>Product_Category:</td>
<td><input type="text" name="pcat" placeholder="product category" required></td>
</tr>
<tr>
<td>Active</td>
<td><select name="active" required>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
</tr>
<tr>
<td>Product_Price</td>
<td><input type="text" name="price" placeholder="Product_price" required></td>
</tr>
<tr>
<td>Upload Image</td>
<td><input type="file" name="filename" placeholder="upload file" required></td>
</tr>
</table>
</div>
</div>
<div class="d-flex justify-content-center">
<button type="submit" class="btn btn-primary">Submit</button>
<button type="reset"  class="btn btn-primary">Reset</button>
</div>
</form>
<%@include file="/includes/footer.jsp" %>
</body>
</html>