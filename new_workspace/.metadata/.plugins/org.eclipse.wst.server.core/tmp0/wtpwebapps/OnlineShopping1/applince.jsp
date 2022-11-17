<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
.column {
  float: left;
  width: 25%;
  padding: 2px;
  padding-left:25px;
  padding-right: 50px;
  padding-top: 100px;
  padding-bottom: 25px;
}

/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}
	img {
	  width: 100%;
	  height:300px;
	}
header{
	border: 2px solid black;
	background-color:#bbb;
}		
</style>
</head>
<body>
<header align="center"><h1>Home Appliances</h1>

</header>
<h3 align="right"><a href="products.jsp"  class="btn btn-success text-white " style="color:black">Go To Home</a></h3>
<br>
<div class="container-fluid mt-8">
<div class="row">
	<div class="card col-sm-3">
    <img class="card-img-top" src="images/lg.jpeg"  alt="image1">
    <div class="card-body">
      <h4 class="card-title">LG 108 cm (43 inch) Ultra HD (4K) LED Smart TV</h4>
	     <h5 class="card-text">>36000 RS</h5>
	     <a href="#" class="btn btn-primary">add Cart</a>
	   </div>
	   </div>
	   <div class="card col-sm-3">
	     <img class="card-img-top"src="images/wm.jpeg" alt="image1">
	   	 <div class="card-body">
      		<h4 class="card-title">SAMSUNG 6 kg 5-star Inverter with Hygiene Steam Fully Automatic Front Load with In-built Heater Silver</h4>
	   	 <h5 class="card-text">24000 RS</h5>
	   	 <a href="#" class="btn btn-primary">add Cart</a>
	   	 </div>
	   </div>
	   <div class="card col-sm-3">
	     <img class="card-img-top"src="images/sam.jpeg" alt="image1">
	   	 <div class="card-body">
      <h4 class="card-title">SAMSUNG 253 L Frost Free Double Door 3 Star Refrigerator  (Elegant Inox, RT28A3453S8/HL)</h4>
	   	 <h5 class="card-text">24490 RS</h5>
	   	  <a href="#" class="btn btn-primary">add Cart</a>
	   </div>
	   </div>
	   <div class="card col-sm-3">
	     <img class="card-img-top"src="images/kent.jpeg" alt="image1">
	   	 <div class="card-body">
      <h4 class="card-title">KENT Ace 8 L RO + UV + UF + TDS Water Purifier  (White)</h4>
	   	 <h5 class="card-text">10999 RS</h5>
	   	 <a href="#" class="btn btn-primary">add Cart</a>
	   </div>
	   </div>
	
</div>
</div>
</body>
</html>