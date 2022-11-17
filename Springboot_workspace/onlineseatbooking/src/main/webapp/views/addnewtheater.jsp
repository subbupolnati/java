<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Theater register page</h1>
<form action="theaterreg" method="post">
<table>
<tr>
<td>Theater_Id</td>
<td><input type="text" name="theaterid"></td>
</tr>
<tr>
<td>Theater Name</td>
<td><input type="text" name="theatername"></td>
</tr>
<tr>
<td>Movie Name</td>
<td><input type="text" name="moviename"></td>
</tr>
<tr>
<td>Theater Location</td>
<td><input type="text" name="location"></td>
</tr>
<tr>
<td>Ticket Price</td>
<td><input type="text" name="price"></td>
</tr>
</table>
<input type="submit" value="register"/>
</form>
</body>
</html>