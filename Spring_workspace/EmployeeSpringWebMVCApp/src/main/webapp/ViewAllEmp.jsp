<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employees List</h1>  
<table border="2" width="50%" cellpadding="1">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th></tr>  
   <c:forEach var="emp" items="${emp}">   
   <tr>  
   <td>${emp.empid}</td>  
   <td>${emp.ename}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.designation}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>