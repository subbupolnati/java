<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp" %>
<title>ResetPassword Page</title>
<style>
body{
	background-image:url("login1.jpg");
	background-repeat: no-repeat;
  	background-attachment: fixed; 
  	background-size: 100% 100%;
	color:white;
}
</style>
</head>
<body>
<% 
String msg=request.getParameter("msg");
if("invalid".equals(msg)){
%>
<h1 align="center" style=color:red>Invalid  Details</h1>
<%} %>
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center text-dark">Reset Password Page</div>
			<div class="card-body">
				<form action="ResetPasswordServlet" method="post">
				<div class="form-group">
						<label>Email</label> 
						<input type="email" name="t1" placeholder="email" class="form-control"required >
					</div>
					<div class="form-group">
						<label>Mobile number</label> 
						<input type="tel" pattern="[0-9]{10}" name="mobile" placeholder="mobile" class="form-control"required >
					</div>
					<div class="form-group">
						<label>mobile</label> 
						<input type="password" name="t2" class="form-control" placeholder="Password" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Reset Password</button>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>