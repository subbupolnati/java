<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/adminstyle.css">
<meta charset="ISO-8859-1">
<style>
.card{
 margin-top:5%;

}
.div1{
	margin-left:40%;

}
input[type=submit],input[type=button] {
  width: 20%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
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
</head>
<body>
<h1 style="padding-left:500px; color:red">Welcome to Admin Page</h1>
<nav class="topnav">
<ul>
<li><a class="active" href="products.html"><i class="bi bi-house"></i>Home</a></li>
<li><a href="#">All Products</a></li>
<li><a href="#">Add Product</a></li>
<li><a href="">Update Product</i></a></li>
<li><a href="">Delete Product</i></a></li>
<li><a>Customer Details</a>
	<div class="sub-menu1">
	<ul>
		<li><a href="custome_all_details.jsp">All Customer Details</i></a>
		<li><a href="selected_customer.jsp">Selected Customer</a></li>
		<li><a href="update_details.jsp">Update Customer Details</a></li>
		<li><a href="deleted_customer.jsp">Delete Customer</a></li>
	</ul>
	</div>
</li>
<li><a href="LogOutServlet" >Signout</a></li>
</ul>
</nav>
<div class="div1">
<h1>Selected Customer Details</h1>
<form action="selected_customer.jsp" method="post">
Enter UserName:<input type="text" name="uname" ><br>
<input type="submit" value="submit">
</form>
</div>
<%@page import="javax.servlet.*" %>
<%@page import="java.sql.*" %>
<%@ page import="com.databaseconnection.CustomerConn" %>
<%@ page import="com.customer.*" %>
<div align="center" class="card">
<table border="1px">
<%
	String uname=request.getParameter("uname");
	Customer customer=new Customer();
	//customer.setUsername(uname);
	CustomerConn custcon=new CustomerConn();
	ResultSet rs=custcon.selectedCustomer(customer);
	
	out.println("<tr><th>First_Name</th><th>Last_Name</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>mobileNumber</th></tr>");
	while(rs.next()){
		out.println("<tr><td>"+rs.getString("first_name")+"</td>"+"<td>"+rs.getString("last_name")+"</td>"+
				"<td>"+rs.getString("username")+"</td>"+"<td>"+rs.getString("password")+"</td>"+
				"<td>"+rs.getString("email")+"</td>"+"<td>"+rs.getString("gender")+"</td>"+"<td>"+rs.getLong("mobilenumber")+"</td></tr>");
	}
	
%>
</table>
</div>
</body>
</html>