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

input[type=submit],input[type=reset] {
  width: 50%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 10px 0 0 50px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=button]{
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
<div class="div1">
<h1>Update customer details</h1>
<table align="center">
<form action="Update_customer" method="post">
<tr>
<td>Username:</td>
<td><input type="text" name="uname" placeholder="username"></td>
</tr>
<tr>
<td>Firstname:</td>
<td><input type="text" name="fname" placeholder="firstname"></td>
</tr>
<tr>
<td>Lastname:</td>
<td><input type="text" name="lname" placeholder="lastname"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="email" name="email" placeholder="email"></td>
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
<tr>
<td><a href="admin_home_page.jsp"><input type="button" value="back to home"></a></td>
</tr>
</form>
</table>
</div>
</body>
</html>