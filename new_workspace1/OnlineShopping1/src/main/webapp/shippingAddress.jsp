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
  background-image:url("regjpg.jpg");
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
<body>
<header>
<h1 align="center"> Shipping Address page</h1>
</header>
<div>
<table>
<form action="RegisterServlet" method="post">
<tr>
<td>CustomerName:</td>
<td><input type="text" name="name" placeholder="CustomerName"></td>
</tr>
<tr>
<td>Mobile No</td>
<td><input type="tel" pattern="[0-9]{10}" name="mobile" placeholder="mobile"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="Address" placeholder="Street Address"></td>
</tr>
<tr>
<td>City</td>
<td><input type="text" name="city" placeholder="City"></td>
</tr>
<tr>
<td>Country/Region</td>
<td><select name="country">
<option>select</option>
<option value="india">INDIA</option>
<option value="usa">USA</option>
<option value="uae">UAE</option>
</select>
</td>
</tr>
<tr>
<td>State</td>
<td><select name="state">
<option>select</option>
<option value="Andhra pradesh">Andhra Pradesh</option>
<option value="Telagana">Telagana</option>
<option value="Maharastra">maharastra</option>
</select>
</td>
</tr>
<tr>
<td>Zip/Pin Code</td>
<td><input type="text" name="zip" placeholder="Pincode"></td>
</tr>
<tr>
<br>
<tr >
<td align="center"><input type="submit" value="continue" ></td>
<td><a href="loginpage.html" style="color:white"><input type="button" value="login"></a></td>
</tr>
</form>
</table>
</div>
</body>
</html>