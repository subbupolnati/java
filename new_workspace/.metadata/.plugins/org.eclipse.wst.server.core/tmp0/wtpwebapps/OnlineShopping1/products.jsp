<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.product.*" %>
<%@ page import="com.customer.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.databaseconnection.*" %>   
<%
	ProductConn pcon=new ProductConn();
	List<Product> products=pcon.all_Product_Details();
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp"%>
<title>Home</title>
<style>
*{
margin:0;
padding:0;
box-sizing: border-box;
}
body {
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color:#fff;
  box-sizing: border-box;
}
.topnav{
	 color: #fff;
	 text-align:center;
}
.topnav ul{
	display:inline-flex;
	list-style: none;
	color:#fff;
}
.topnav ul li {
	width:150px;
	margin:5px;
	padding:10px;
	}
.topnav ul li a {
  color:black;
  text-align: center;
  text-decoration: none;
  font-size: 17px;

}

.topnav a:hover {
  background-color:#04AA6D;
  color: white;
  border-radius: 3px;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
.sub-menu1{
	display:none;
}
.topnav ul li:hover .sub-menu1{
	display:block;
	position: absolute;
	background:#fff;
	margin-top: 15px;
	margin-left: -30px;
}
.topnav ul li:hover .sub-menu1 ul{
	display:block;
	margin:-10px;
}
.topnav ul li:hover .sub-menu1 ul li{
	 width:150px;
	 padding:5px;
	 background: transparent;
	 //border-radius: 3px;
	 text-align: left;
}
.topnav ul li:hover .sub-menu1 ul li :last-child{
	border-bottom: none;
	}
.topnav ul li:hover .sub-menu1 ul li a:hover{
	//color:blue;
	
	}
.sub-menu2{
	display:none;
}
.hover-me:hover .sub-menu2{
	position:absolute;
	display:block;
	margin-top:-20px;
	margin-left:140px;
	background:#fff;
}
.img img{
	width:100%;
  background-size:cover;
  //border: 1px solid red;
  display:block;
}
.img img1{
  background-size:cover;
  //border: 1px solid red;
  display:block;
}
</style>


</style>
</head>
<body>
<%@ include file="/includes/navbar.jsp"  %>
<nav class="topnav">
<ul>
<li><a class="active" href="products.jsp"><i class="bi bi-house"></i>Home</a></li>
<li><a href="grocery.jsp">Grocery</a></li>
<li><a href="">Mobiles</a></li>
<li><a href="">Fashion <i class="bi bi-arrow-down-short"></i></a>
	<div class="sub-menu1">
		<ul>
		<li class="hover-me"><a href="#">Men's Top Wear<i class="bi bi-arrow-right-short"></i></a>
			<div class="sub-menu2">
			<ul>
				<li><a href="fashion.jsp">All</a></li>
				<li><a href="#">Shirts</a></li>
				<li><a href="#">Tea Shirts</a></li>
			</ul>
			</div>
		</li>
		<li class="hover-me"><a href="#">Men's Bottom Wear <i class="bi bi-arrow-right-short"></i></a>
		<div class="sub-menu2">
			<ul>
				<li><a href="fashion.jsp">All</a></li>
				<li><a href="#">jeans</a></li>
				<li><a href="#">tracks</a></li>
				<li><a href="#">boxers</a></li>
			</ul>
			</div>
		
		</li>
		<li><a href="#">Women Ethnic</a></li>
		<li><a href="#">Women Western</a></li>
		<li><a href="#">men's Footwear</a></li>
		<li><a href="#">Womens Footwear</a></li>
		</ul>
	</div>
</li>
<li><a href="electonics.jsp">Eletronics <i class="bi bi-arrow-down-short"></i></a>
	<div class="sub-menu1">
		<ul>
		<li class="hover-me"><a href="#">audio<i class="bi bi-arrow-right-short"></i></a>
			<div class="sub-menu2">
			<ul>
				<li><a href="electonics.jsp">All</a></li>
				<li><a href="#">Ear phones</a></li>
				<li><a href="#">Speakers</a></li>
			</ul>
			</div>
		</li>
		<li><a href="#">Laptop Accessories</a></li>
		<li><a href="#">Computer Peripherals</a></li>
		<li><a href="#">Gaming</a></li>
		<li><a href="#">Powerbank</a></li>
		<li><a href="#">MobileAccessory</a></li>
		</ul>
	</div>
</li>
<li><a href="furinture.jsp">Furniture</a></li>
<li> <a href="applince.jsp">Home Appliances</a></li>
</ul>
</nav>
<div class="container-fluid">
	<%String msg=request.getParameter("msg"); 
		if("done".equals(msg)){
	%>
	<h3>Cart Added Successfully</h3>
	<%} %>
	<%if("notexist".equals(msg)){
		%>
		<h3>item is not available to cart</h3>
		<%} %>
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="./images/<%=p.getImage() %>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getProduct_name()%></h5>
						<h6 class="price">Price: $<%=p.getProduct_price() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="Add_To_Cart?id=<%=p.getProduct_id()%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getProduct_id()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
<%@include file="/includes/footer.jsp"%>
</body>
</html>
 