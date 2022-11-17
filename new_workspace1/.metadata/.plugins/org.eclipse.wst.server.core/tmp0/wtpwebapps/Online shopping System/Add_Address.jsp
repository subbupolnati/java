<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>address page</title>
<%@include file="/includes/head.jsp"%>
<style>
body{
background-color:	#b3ecff;
}
</style>
</head>
<body>
<%@ include file="/includes/navbar.jsp"%>
<%String msg=request.getParameter("msg");
if("success".equals(msg)){
%>
<h2 align="center" style="color:red">Product ordered Successfully please entered delivery Address </h2>
<%} %>
<%
if("invalid".equals(msg)){
%>
<h2 align="center" style="color:red"> entered Wrong details please re enter  </h2>
<%} %>
	<div class="container col-6 my-3">
		<div class="d-flex py-3"><h3>ADD New Address</h3></div>
			<form  method="post">
				<div class="input-group input-group-sm mb-3">
		  			<input type="hidden" class="form-control" name="email"value="<%out.println(email);%>">
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<input type="text" class="form-control" name="name" placeholder="CustomerName">
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="tel" pattern="[0-9]{10}"class="form-control" name="mobile" placeholder="mobile">
				</div>
				<div class="input-group mb-3">
				  <input type="text" name="address"class="form-control" placeholder="Street Address">
				  <input type="text"  class="form-control"  name="city" placeholder="City">
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" for="inputGroupSelect01">Country</label>
		  				<select class="form-select" id="inputGroupSelect01" name="country">
			   				<option selected>Choose...</option>
							<option value="india">INDIA</option>
							<option value="usa">USA</option>
							<option value="uae">UAE</option>
	 					</select>
	 				 <label class="input-group-text" for="inputGroupSelect01">State</label>
	  					<select class="form-select" id="inputGroupSelect01" name="state">
			   				<option selected>Choose...</option>
							<option value="Andhra pradesh">Andhra Pradesh</option>
							<option value="Telagana">Telagana</option>
							<option value="Maharastra">maharastra</option>
	 					</select>
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="text" name="pincode" placeholder="Pincode"class="form-control">
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="submit" formaction="AddressServlet" value="submit"class="btn btn-sm btn-success">
				</div>
			</form>
		</div>
</body>
</html>