<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%! String st=""; %>
<% String st=(String)request.getAttribute("msg"); %>
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
<%@include file="/includes/adminnavbar.jsp"%>
<div class="div1">
<h1>Select Customer Details</h1>
<div class="card">

</div>
<form action="Deleted_customer" method="post">
Enter UserName:<input type="text" name="uname" ><br>
<input type="submit" value="submit">
</form>
</div>

</body>
</html>