<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="container-fluid p-3 bg-primary text-white text-center">
  <input type="search" placeholder="Search "><button type="submit"><i class="bi bi-search"></i>Search</button>
 <a href="products.jsp" class="text-white p-3">Home</a>
<a href="loginpage.jsp"class="text-white p-3">Login</a>
<a href="LogOutServlet"class="text-white p-3">logout</a>
<a href="cart.jsp" class="text-white p-3 text-decoration:none">Cart <span class="badge badge-danger">${cart_list.size()}</span></a><i class="bi bi-cart-fill"></i>
</div>
