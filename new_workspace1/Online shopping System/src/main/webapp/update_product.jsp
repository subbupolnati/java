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
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<h1 align="center"> Product Update page</h1>
<% int pid=Integer.parseInt(request.getParameter("id"));
	p.setProduct_id(pid);
 %>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h1 align="center" style="color:red;">Product Updated Successfully</h1>
<%}%>
<%
if("invalid".equals(msg)){
%>
<h1 align="center" style="color:red;">Something Went Wrong in Product Details  </h1>
<% }%>
<form action="Update_Product?pid=<%=p.getProduct_id()%>" method="post" enctype="multipart/form-data">
<div class="row justify-content-md-center my-5">
<div class="card col-6">
<h1 class="card-header"> Product Update page</h1>
<table class="table">
<tr>
<td>Product_Name:</td>
<td><input type="text" name="pname" placeholder=""></td>
</tr>
<tr>
<td>Product_Category:</td>
<td><input type="text" name="pcat" placeholder=""></td>
</tr>
<tr>
<td>Active</td>
<td><select name="active">
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
</tr>
<tr>
<td>Product_Price</td>
<td><input type="text" name="price" placeholder=""></td>
</tr>
<tr>
<td>Upload Image</td>
<td><input type="file" name="filename" placeholder=""></td>
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