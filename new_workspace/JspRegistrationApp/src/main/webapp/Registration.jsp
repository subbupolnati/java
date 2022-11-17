<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
</head>
<body>
<header>
<h1 align="center"> registration page</h1>
</header>
<div>

<form action="response_reg.jsp" method="post">
<table>
<tr>
<td>Username:</td>
<td><input type="text" name="t1" placeholder="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="p1" placeholder="password"></td>
</tr>
<tr>
<td>ReenterPassword</td>
<td><input type="password" name="rp1" placeholder="reenter password"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="email" name="m1" placeholder="email"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address" placeholder="enter Address"></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" name="r1" value="Male" >Male
<input type="radio" name="r1" value="Female">Female</td>
</tr>
<tr>
<tr>
<td>Qualification</td>
<td><select name="qul">
<option>select</option>
<option value="mca">MCA</option>
<option value="btech">Btech</option>
<option value="mtech">MTech</option>
</select>
</td>
</tr>
</table>
<br>
<input type="submit" value="submit" >
<input type="reset" value="reset" >

</form>


</body>
</html>