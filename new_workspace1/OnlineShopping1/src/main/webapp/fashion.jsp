<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>fashion</title>
meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
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
	  width: 200px;
	  height:200px;
	}header{
	border: 2px solid black;
	background-color:#bbb;
}		
</style>
</head>
<body>
<header align="center"><h1>Fashion products</h1></header>
<h3 align="right"><a href="products.jsp"  class="btn btn-success text-white " style="color:black">Go To Home</a></h3>
<br>
<div class="container-fluid mt-8">
<div class="row">
	<div class="card col-sm-2">
    <img class="card-img-top" src="images/shirt.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">Casual shirts</h4>
      <p class="card-text">580 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/jeans.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Slim Men Blue Jean</h4>
      <p class="card-text">899 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
 <div class="card col-sm-2"  >
    <img class="card-img-top" src="images/teashirt.jpeg" alt="image1"">
    <div class="card-body">
      <h4 class="card-title">Solid Men Hooded Neck</h4>
      <p class="card-text">480 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
  <div class="card col-sm-2"  >
    <img class="card-img-top" src="images/sarees.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">kashvi sareesPrinted Daily Wear Georgette</h4>
      <p class="card-text">500 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2">
    <img class="card-img-top" src="images/nike.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">Stride Walker Walking Shoe</h4>
      <p class="card-text">1050 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/footwear.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Slippers</h4>
      <p class="card-text">430 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/watch.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">2048-BL Blue Day and Date</h4>
      <p class="card-text">450 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/glasses.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">UV Protection Retro Square</h4>
      <p class="card-text">300 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
</div>
</div>
</body>
</html>
