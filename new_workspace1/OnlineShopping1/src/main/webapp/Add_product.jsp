<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/adminstyle.css">
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
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
<h1 align="center"> Product register page</h1>
<div class="div1">
<table>
<form action="Add_Products" method="post" enctype="multipart/form-data">
<tr>
<td>Product_Id</td>
<td><input type="text" name="pid" placeholder="product id"></td>
</tr>
<tr>
<td>Product_Name:</td>
<td><input type="text" name="pname" placeholder="productname"></td>
</tr>
<tr>
<td>Product_Category_Id:</td>
<td><input type="text" name="pcid" placeholder="product category id"></td>
</tr>
<tr>
<td>Availble_Quanity</td>
<td><input type="text" name="avl" placeholder="avalible_quanity"></td>
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
<tr >
<td align="center"><a href="admin_home_page.jsp"><input type="button" value="Back to Home"></a></td>
</tr>
</form>
</table>
</div>
</body>
</html>