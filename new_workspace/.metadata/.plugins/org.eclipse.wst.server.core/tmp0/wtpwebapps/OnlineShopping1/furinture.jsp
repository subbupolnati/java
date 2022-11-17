<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>grocey</title>
<style>
* {
  box-sizing: border-box;
}
.row{
	//padding-left:25px;
  //padding-right: 50px;
	margin-left:50px;
	margin-right:50px;
}
img {
	  width: 250px;
	  height:200px;
	}
header{
	border: 2px solid black;
	background-color:#bbb;
}		
</style>
</head>
<body>
<header align="center"><h1>Furnitures products</h1>
</header>
<h3 align="right"><a href="products.jsp"  class="btn btn-success text-white " style="color:black">Go To Home</a></h3>
<br>
<div class="container-fluid mt-8">
<div class="row">
	<div class="card col-sm-3">
    <img class="card-img-top" src="images/bed.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">Perfect Homes Opus Engineered Wood Queen Box</h4>
      <p class="card-text">25000 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-3" >
    <img class="card-img-top" src="images/chair.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">chairs</h4>
      <p class="card-text">999 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
 <div class="card col-sm-3"  >
    <img class="card-img-top" src="images/sofa.jpeg" alt="image1"">
    <div class="card-body">
      <h4 class="card-title">Bharat Lifestyle Nano L shape Fabric 6 Seater Sofa</h4>
      <p class="card-text">20500 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
  <div class="card col-sm-3"  >
    <img class="card-img-top" src="images/coffe.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Crystal Furnitech Sigma Engineered Wood Coffee Table</h4>
      <p class="card-text">3550 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
</div>
</div>
</body>
</html>