<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.databaseconnection.*" %>
<%@ page import="com.servlets.*" %>
<%@ page import="java.sql.*" %>
      <%int pid =Integer.parseInt(request.getParameter("id"));
    Product p=new Product();
    p.setProduct_id(pid);
    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<style>
.card{
 margin-top:5%;
 margin-left:50%;

}
.div1{
	margin-left:40%;

}
input[type=submit],input[type=button] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 10px;
  margin: 10px 0 0 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=text]{
  width:30%;
  padding:5px 10px;
  margin-top:25px;
  margin-left:2px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
<title>Home</title>
<%@include file="/includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/adminnavbar.jsp"%>
<div class="div1">
<%! int n=0; %>
<%
ProductConn pcon=new ProductConn();
try{
	Connection con=pcon.dbconnection();
	String sql="delete from products where product_id=?";
	PreparedStatement st=con.prepareStatement(sql);
	st.setInt(1,p.getProduct_id());
	 n=st.executeUpdate();
}catch(Exception e)
{
	e.printStackTrace();
}
%>
<% if(n>0){
	%>
	<h1 align="center" style="color:red;">Product DeletedSuccessfully</h1>
<%}%>
	<%
	if(n==0){
	%>
	<h1 align="center" style="color:red;">Something Went Wrong in Product Details  </h1>
	<% }%>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>