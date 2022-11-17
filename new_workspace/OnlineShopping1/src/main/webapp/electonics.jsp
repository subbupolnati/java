<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Electronics</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<header align="center"><h1>Electronics</h1></header>
<h3 align="right"><a href="products.jsp"  class="btn btn-success text-white " style="color:black">Go To Home</a></h3>
<br>
<div class="container-fluid mt-8">
<div class="row">
	<div class="card col-sm-2">
    <img class="card-img-top" src="images/bluetooth.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">realme Buds Wireless 2 with Dart Charge</h4>
      <p class="card-text">1500 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/buds.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Truke Buds S1 with Environmental Noise Cancellation</h4>
      <p class="card-text">2000 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
 <div class="card col-sm-2"  >
    <img class="card-img-top" src="images/boat.jpeg" alt="image1"">
    <div class="card-body">
      <h4 class="card-title">boAt Stone 190F 5 W Bluetooth Speaker
Red, Stereo Channel</h4>
      <p class="card-text">999 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  
  <div class="card col-sm-2"  >
    <img class="card-img-top" src="images/apple.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">APPLE Watch Series 3 GPS - MTF32HN/A 42 mm Space Grey Aluminium</h4>
      <p class="card-text">24450 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2">
    <img class="card-img-top" src="images/usb.jpeg"  alt="image1" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">wireless usb</h4>
      <p class="card-text">1050 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/r.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Routers</h4>
      <p class="card-text">1900 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
  <div class="card col-sm-2" >
    <img class="card-img-top" src="images/webcam.jpeg" alt="image1">
    <div class="card-body">
      <h4 class="card-title">Webcams</h4>
      <p class="card-text">1550 RS</p>
      <a href="#" class="btn btn-primary">add Cart</a>
    </div>
  </div>
</div>
</div>
</body>
</html>