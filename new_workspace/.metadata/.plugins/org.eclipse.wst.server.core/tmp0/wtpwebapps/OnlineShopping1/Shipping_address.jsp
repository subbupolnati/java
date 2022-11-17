<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %> 
<%
String email3=(String)request.getSession(false).getAttribute("uname");
Customer cust=new Customer();
cust.setEmail(email3);
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<%String msg=request.getParameter("msg");
if("success".equals(msg)){
%>
<h2 align="center" style="color:red">Product ordered Successfully please entered delivery Address </h2>
<%} %>
<%!String fullname,address,city,country,state;int pincode;long mobileno; %>
<div class="container my-3">
		<div class="d-flex py-3">
		<div class="input-group input-group-sm mb-3">
		<%
			Connection con=ProductConn.dbconnection();
			String sql="select * from address where email=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,cust.getEmail());
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				fullname=rs.getString("fullname");
				address=rs.getString("address");
	  			city=rs.getString("city");
	  			country=rs.getString("country");
	  			state=rs.getString("state");
	  			pincode=rs.getInt("pincode");
	  			mobileno=rs.getLong("mobileno");
			}
			%>
		  			<input type="radio" class="form-control" name="add"><h5><% out.println(fullname); %></h5>
		  		
				</div>
			
		</div>
		</div>
<a href="Add_Address.jsp">add <%out.println(email3); %></a>
</body>
</html>