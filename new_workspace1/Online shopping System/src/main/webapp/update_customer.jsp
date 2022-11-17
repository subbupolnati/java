<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<%@include file="/includes/head.jsp" %>
<link rel="stylesheet" href="css/adminstyle.css">
<meta charset="ISO-8859-1">
<style>
.card{
 margin-top:5%;

}
.div1 {
  border-radius: 5px;
  //background-color: #f2f2f2;
  padding:25px;
  //border:1px solid white;
  width:40%;
  height:500px;
  margin-top:10px;
  margin-left:33.33%;
}
</style>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<div class="div1">
<h1>Update customer details</h1>
<table align="center">
<form action="Update_customer" method="post">
<tr>
<td>Fullname:</td>
<td><input type="text" name="uname" placeholder="username"></td>
</tr>
<tr>
<td>Mobile No</td>
<td><input type="tel" pattern="[0-9]{10}" name="mobile" placeholder="mobile"></td>
</tr>
<br>
<tr >
<td align="center"><input type="submit" value="submit" ></td>
<td aligin="center"><input type="reset" value="reset"></td>
</tr>
</form>
</table>
</div>
</body>
</html>