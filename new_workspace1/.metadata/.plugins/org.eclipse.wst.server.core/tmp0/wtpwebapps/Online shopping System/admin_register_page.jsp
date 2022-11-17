<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register page</title>
</head>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  //background-color:skyblue;
  background-image:url("../regjpg.jpg");
	background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%;
	color:white;
  color:white;
}
div {
  border-radius: 5px;
  //background-color: #f2f2f2;
  padding:25px;
  //border:1px solid white;
  width:40%;
  height:500px;
  margin-top:10px;
  margin-left:33.33%;
}
table tr td{
font-size:25px;
padding:10px;
padding-top:0px;
padding-left:50px;
}
input[type=text],input[type=password],input[type=email],input[type=tel],input[type=radio]]{
  width:100%;
  padding:5px 10px;
  margin-left:2px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit],input[type=button] {
  width: 50%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 10px 0 0 100px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

</style>
<body>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h1 align=center style="color:red;">registerd successfully</h1>
<%} %>
<%
if("invalid".equals(msg)){
%>
<h1 align=center style="color:red;">Something Went Wrong Try Again </h1>
<%}%>
<header>
<h1 align="center">Admin Register Page</h1>
</header>
<div>
<table>
<form action="AdminRegisterServlet" method="post">
<tr>
<td>Fullname:</td>
<td><input type="text" name="uname" placeholder="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="pass" placeholder="password"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="email" placeholder="email"></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" name="gender" value="Male" >Male
<input type="radio" name="gender" value="Female">Female</td>
</tr>
<tr>
<td>Mobile No</td>
<td><input type="tel" pattern="[0-9]{10}" name="mobile" placeholder="mobile"></td>
</tr>
<br>
<tr >
<td align="center"><input type="submit" value="submit" ></td>
<td><a href="adminlogin.jsp" style="color:white"><input type="button" value="login"></a></td>
</tr>
</form>
</table>
</div>
</body>
</html>