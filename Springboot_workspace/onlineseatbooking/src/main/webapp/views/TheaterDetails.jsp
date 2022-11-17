<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Theaters </h1>
<table border=2>

<tr>
<th>Theater Id</th>
<th>TheaterName</th>
<th>Movie name</th>
<th>Location</th>
<th>Price</th>
</tr>
<c:forEach var="i" items="${tlist}">
<tr>
<td><c:out value="${i.theaterid}"/></td>
<td><c:out value="${i.theatername}"/></td>
<td><c:out value="${i.moviename}"/></td>
<td><c:out value="${i.location}"/></td>
<td><c:out value="${i.price}"/></td>
<td><a href="edit/${i.theaterid}">Edit</a>
</tr>
</c:forEach>
</table>
</body>
</html>