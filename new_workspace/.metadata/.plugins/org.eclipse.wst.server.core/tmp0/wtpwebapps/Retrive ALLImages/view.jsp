<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.productdb.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.model.*" %>
    <%@page import="java.sql.*" %>
<%
ProductDao pcon=new ProductDao();
List<Product> p=pcon.view_All();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
for(Product img:p)
{%>
<h1><%=img.getPid()%></h1>
<h1><img src="data:image/jpg;Base64,<%=img.getImage()%>" width="300px" height="300px"></h1>
<%
}
%>
</body>
</html>