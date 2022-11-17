<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<style>
body{
	background-image:url("login1.jpg");
	background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%;
	color:white;
}
.login {
  border-radius: 5px;
  //background-color: #f2f2f2;
  padding:50px;
  border:1px solid black;
  width:25%;
  height:250px;
  margin-top:50px;
  margin-left:33.33%;
}
h1{
text-align:center
}
h3 a{
color:red;
text-decoration: none;
}
table tr td{
font-size:25px;
padding:15px;
}
input[type=submit] {
  width: 25%;
  background-color:blue;
  color: white;
  padding: 14px 20px;
  margin: 18px 0 0 75px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
</head>
<body>
<% 
String msg=request.getParameter("msg");
if("invalid".equals(msg)){
%>
<h1 align="center" style=color:red>Invalid login Details</h1>
<%} %>
<header>
<h1>Admin login page</h1>
</header>
<div class="login">

<form action="AdminValidateServlet" method="post">
<table>
<tr>
<td>Email</td>
<td><input type="email" name="t1" placeholder="admin email" required></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="t2" placeholder="admin password" required></td>
</tr>
</table>
<input type="submit" value="submit" >
<a href="#" style="color:white">forget password</a>
<h3>If you don't  have account
<a href="admin_register_page.jsp">register</a></h3>
</form>

</div>
</body>
</html>