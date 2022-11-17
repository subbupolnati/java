<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String email=(String)session.getAttribute("uname"); %>
<div class="container-fluid p-3 bg-primary text-white text-center">
<form  method="post">
  <input type="search"  name="search" placeholder="Search "><button type="submit"formaction="search.jsp"><i class="bi bi-search"></i>Search</button></
  </form>
 <a href="products.jsp" class="text-white p-3">Home</a>
 <a href="loginpage.jsp"class="text-white p-3">Login</a>
 <a href="" style="color:white"><%out.println(email);%></a>
<a href="LogOutServlet"class="text-white p-3">logout</a>
<a href="cart.jsp" class="text-white p-3 text-decoration:none">Cart <span class="badge badge-danger">${cartProduct.size()}</span></a><i class="bi bi-cart-fill"></i>
<a href="order.jsp"class="text-white p-3">Orders</a>
</div>
