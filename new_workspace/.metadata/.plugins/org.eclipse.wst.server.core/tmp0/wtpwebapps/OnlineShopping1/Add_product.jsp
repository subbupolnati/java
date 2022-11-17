<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.product.*" %>
     <%@ page import="java.lang.*" %>
     <%@ page import="java.sql.*" %>
     <%@ page import="com.databaseconnection.*" %>
    <% 
    Product p=new Product();
    ProductConn pcon=new ProductConn();
    Connection con=pcon.dbconnection();
	int pid=1;//base instilaze productid
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select max(product_id) from products");//query from max id
	while(rs.next()) {
		pid=rs.getInt(1);
		pid+=1;
		p.setProduct_id(pid);
		//System.out.println(product.getProduct_id());
	}
    %>
<!DOCTYPE html>
<html>

<meta charset="ISO-8859-1">
<title>Home</title>
<style>
.card{
 margin-top:5%;

}
.div1{
  border-radius: 5px;
  background-color: #f2f2f2;
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
  padding: 14px 10px;
  margin: 5px 0 0 50px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
<body>
<%@include file="/includes/adminnavbar.jsp" %>

<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
%>
<h1 align="center" style="color:red;">Product Add Successfully</h1>
<%}%>
<%
if("invalid".equals(msg)){
%>
<h1 align="center" style="color:red;">Something Went Wrong in Product Details  </h1>
<% }%>
<h1 align="center"> Product register page</h1>
<div class="div1">
<table>
<form action="Add_Products" method="post" enctype="multipart/form-data">
<tr>
<td>Product_Id ::<%=p.getProduct_id() %></td>
<input type="hidden" name="pid" value="<%= p.getProduct_id()%>">
</tr>
<tr>
<td>Product_Name:</td>
<td><input type="text" name="pname" placeholder="productname"></td>
</tr>
<tr>
<td>Product_Category:</td>
<td><input type="text" name="pcat" placeholder="product category"></td>
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
<td><input type="text" name="price" placeholder="Product_price"></td>
</tr>
<tr>
<td>Upload Image</td>
<td><input type="file" name="filename" placeholder="upload file"></td>
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