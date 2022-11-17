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
if("done".equals(msg)){
%>
<h2 align="center" style="color:red">Address Added Successfully please entered Payment Mode </h2>
<%} %>

	<div class="container col-6 my-3">
		<div class="d-flex py-3"><h3>Payment Page</h3></div>
				<div class="input-group input-group-sm mb-3">
		  			<input type="radio"  name="r1" value="Credit Card">CreditCard
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="radio" name="r1" value="DebitCard">DebitCard
				</div>
				
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="radio" name="r1" value="InterNet Banking">InterNet Banking
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><input type="radio" name="r1" value="Cash On Delivery">Cash On Delivery
				</div>
				<div class="input-group input-group-sm mb-3">
		  			<td><a href="order.jsp?msg=success"class="btn btn-sm btn-success">Submit</a>
				</div>
			</form>
		</div>
</body>
</html>