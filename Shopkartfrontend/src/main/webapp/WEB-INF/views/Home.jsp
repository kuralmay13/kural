<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@ include file="Drop.jsp" %>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
height: 500px;
max-height: 500px;
width:100%;
margin:auto;
}

body {
  background-image: url(resources/images/laptop.jpg);
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed;
   background-size: cover;
}

h3{
	color: white;
}

</style>
</head>
<body>
<h3>${loginMsg}</h3>
<h3>${logoutMsg}</h3>
<div id="Carousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#Carousel" data-slide-to="dell" class="active"></li>
    <li data-target="#Carousel" data-slide-to="acer"></li>
    <li data-target="#Carousel" data-slide-to="hp"></li>
    <li data-target="#Carousel" data-slide-to="lenovo"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src=<c:url value="resources/images/dell.jpg"/> alt="dell">
    </div>

    <div class="item">
      <img src=<c:url value="resources/images/acer.jpg"/> alt="acer">
    </div>

    <div class="item">
      <img src=<c:url value="resources/images/hp.jpg"/> alt="hp">
    </div>

 <div class="item">
      <img src=<c:url value="resources/images/lenovo.jpg"/> alt="lenovo">
    </div>
    
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#Carousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#Carousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</body>
	<%@ include file="footer.jsp" %>
</html>
  