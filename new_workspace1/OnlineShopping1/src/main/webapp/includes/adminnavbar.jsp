<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h1 style="padding-left:500px; color:red">Welcome to Admin Page</h1>
<nav class="topnav">
<ul>
<li><a class="active" href="admin_home_page.jsp"><i class="bi bi-house"></i>Home</a></li>
<li><a href="All_products.jsp">All Products</a></li>
<li><a href="Add_product.jsp">Add Product</a></li>
<li><a href="update_product.jsp">Update Product</i></a></li>
<li><a href="delete_product.jsp">Delete Product</i></a></li>
<li><a style="color:black">Customer Details</a>
	<div class="sub-menu1">
	<ul>
		<li><a href="custome_all_details.jsp">All Customer Details</i></a>
		<li><a href="selected_customer.jsp">Selected Customer</a></li>
		<li><a href="update_details.jsp">Update Customer Details</a></li>
		<li><a href="deleted_customer.jsp">Delete Customer</a></li>
	</ul>
	</div>
</li>
<li><a href="LogOutServlet">Signout</a></li>
</ul>
</nav>