<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	  width: 200px;
	  height:200px;
	}
</style>
</head>

<body>
<div class="container-fluid p-3 bg-danger text-black text-center">
<h1>Grocery products</h1>
</div>
<h3 align="right"><a href="products.jsp"  class="btn btn-success text-white " style="color:black">Go To Home</a></h3>
<br>
<div class="container-fluid mt-8">
<div class="row">
	<div class="card col-sm-2">
    <img class="card-img-top" src="images/toothpaste.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">toothpaste</h4>
      <p class="card-text">135 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/original-imag.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Gold winner sunflower Oil</h4>
      <p class="card-text">130 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
 <div class="card col-sm-2"  >
    <img class="card-img-top" src="georecy_images/honey.jpeg" alt="image1"">
    <div class="card-body">
      <h4 class="card-title">Honey</h4>
      <p class="card-text">250 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
  <div class="card col-sm-2"  >
    <img class="card-img-top" src="images/coconut.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Coconut Oil</h4>
      <p class="card-text">100 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2">
    <img class="card-img-top" src="images/toothpaste.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">toothpaste</h4>
      <p class="card-text">135 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/original-imag.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Gold winner sunflower Oil</h4>
      <p class="card-text">130 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
</div>
</div>
</body>
</html>