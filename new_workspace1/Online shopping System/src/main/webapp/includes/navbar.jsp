<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<div class="container-fluid p-3 bg-primary text-white text-center">
<form  method="post">
  <input type="search"  name="search" placeholder="Search "><button type="submit"formaction="search.jsp"><i class="bi bi-search"></i>Search</button></
  </form>
 <a href="products.jsp" class="text-white p-3">Home</a>
 <%String email=(String)session.getAttribute("uname");
 if(email==null){
 %>
 <a href="loginpage.jsp"class="text-white p-3">Login</a>
 <%} else{ %>
 <a href="" style="color:white"><%out.println(email);%></a>
<a href="LogOutServlet"class="text-white p-3">logout</a>
<a href="cart.jsp" class="text-white p-3 text-decoration:none">Cart <span class="badge badge-danger">${cartProduct.size()}</span></a><i class="bi bi-cart-fill"></i>
<a href="order.jsp"class="text-white p-3">Orders</a>
<%} %>
</div>
<nav>
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active"  href="products.jsp"><i class="bi bi-house"></i>Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="grocery.jsp">Grocery</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="mobiles.jsp">Mobiles</a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Fashion</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="fashion.jsp">All</a>
      <a class="dropdown-item" href="#">Men's Top Wear</a>
      <a class="dropdown-item" href="#">Men's Bottom Wear</a>
      <a class="dropdown-item" href="#">Women Ethnic</a>
      <a class="dropdown-item" href="#">>Women Western</a>
      <a class="dropdown-item" href="#">men's Footwear</a>
      <a class="dropdown-item" href="#">Womens Footwear</a>
      </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Eletronics</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="electonics.jsp">All</a>
      <a class="dropdown-item" href="#">Ear phones</a>
      <a class="dropdown-item" href="#">Speakers</a>
      <a class="dropdown-item" href="#">Laptop Accessories</a>
      <a class="dropdown-item" href="#">Computer Peripherals</a>
      <a class="dropdown-item" href="#">MobileAccessory</a>
      <a class="dropdown-item" href="#">Powerbank</a>
      </div>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="furinture.jsp">Furniture</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="applince.jsp">Home Appliances</a>
  </li>
 </ul>
 </nav>
 <%@include file="/includes/footer.jsp"%>