<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookingServlet" method="post">
<table>
<tr><td>passenger name</td>
<td><input type="text" name="pname"></td>
</tr>
<tr><td>passenger address</td>
<td><input type="text" name="address"></td>
</tr>
<tr><td>Ticket Number</td>
<td><input type="text" name="ticketno"></td>
</tr>
<tr><td>Train number</td>
<td><select name="trainno">  
<option required>select</option>
<option value="10245">10245</option>  
<option value="10246">10246</option>  
<option value="10247">10247</option> 
</select>
</td>
</tr>
<tr><td>Train name</td>
<td><select name="trainname"> 
<option required>select</option> 
<option value="mumbai">Mumbai express</option>  
<option value="Vijawada">vijayawada express</option>  
<option value="hyd">Hyd</option> 
</select>
</td>
</tr>
<tr><td>From</td>
<td><select name="from">
<option required>select</option>
<option value="hyd">hyd</option>  
<option value="vijayawada">vijayawada</option>  
<option value="mumbai">Mumbai</option> 
</select>
</td>
</tr>
<tr><td>To</td>
<td><select name="to">
<option required>select</option>
<option value="vijayawada">vijayawada</option>  
<option value="hyd">hyd</option>  
<option value="mumbai">Mumbai</option> 
</select>
</td>
</tr>
<tr><td>Coach</td>
<td><select name="coach">
<option required>select</option>
<option value="sl">sleeper</option>  
<option value="3AC">3AC</option>  
<option value="2ac">2AC</option> 
</select>
</td>
</tr>
<td><input type="hidden" name="price" value="500"></td>
</tr>
<tr>
<td><input type="submit"></td>
</tr>
</table>
</form>
</body>
</html>