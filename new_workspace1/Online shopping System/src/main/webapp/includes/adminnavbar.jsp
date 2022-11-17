<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
 <head><link rel="stylesheet" href="./css/adminstyle.css"></head>
 <%String uname=(String)session.getAttribute("uname"); %>
<h1 style="padding-left:500px; color:red">Welcome to Admin Page</h1>
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="admin_home_page.jsp"><%out.println(uname); %></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="All_products.jsp">All Products & Edit Products</a>
  </li>
  <li class="nav-item">
    <a class="nav-link "href="Add_product.jsp">Add Product</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Customer Details</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="custome_all_details.jsp">All Customer Details</i>
      <a class="dropdown-item"href="selected_customer.jsp">Selected Customer</a>
      <a class="dropdown-item" href="update_details.jsp">Update Customer Details</a>
      <a class="dropdown-item" href="deleted_customer.jsp">Delete Customer</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="LogOutServlet">Signout</a>  </li>
</ul>
<%@include file="/includes/footer.jsp"%>