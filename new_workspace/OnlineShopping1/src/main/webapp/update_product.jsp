<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.product.*" %>
     <%@ page import="java.lang.*" %>
    <% 
    Product p=new Product();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">>
.card{
 margin-top:5%;

}
.div1{
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
  margin: 10px 0 0 100px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
<body>
<%@include file="/includes/adminnavbar.jsp" %>
<h1 align="center"> Product Update page</h1>
<% int pid=Integer.parseInt(request.getParameter("id"));
	p.setProduct_id(pid);
 %>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h1 align="center" style="color:red;">Product Updated Successfully</h1>
<%}%>
<%
if("invalid".equals(msg)){
%>
<h1 align="center" style="color:red;">Something Went Wrong in Product Details  </h1>
<% }%>
<div class="div1">
<table>
<form action="Update_Product" method="post" enctype="multipart/form-data">
<tr>
<td><input type="hidden" name="id" value="<%= p.getProduct_id() %>"></td>
</tr>
<tr>
<td>Product_Name:</td>
<td><input type="text" name="pname" placeholder=""></td>
</tr>
<tr>
<td>Product_Category:</td>
<td><input type="text" name="pcat" placeholder=""></td>
</tr>
<tr>
<td>Active</td>
<td><select name="active">
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
</tr>
<tr>
<td>Product_Price</td>
<td><input type="text" name="price" placeholder=""></td>
</tr>
<tr>
<td>Upload Image</td>
<td><input type="file" name="filename" placeholder=""></td>
</tr>
<br>
<tr >
<td align="center"><input type="submit" value="submit" ></td>
<td><input type="reset" name="reset"></td>
</tr>
</form>
</table>
</div>
</body>
</html>