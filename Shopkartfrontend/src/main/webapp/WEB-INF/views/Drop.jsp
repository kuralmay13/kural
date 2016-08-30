<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Drop</title>
<script>
    $(document).ready(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>
</head>
<body>
	
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Shopkart</a>
			</div>
			
			<ul class="nav navbar-nav">
				<li class="active"><a href="Home">Home</a></li>
				
					<li class="dropdown">
						<a 	href="#" class="dropdown-toggle" data-toggle="dropdown">Category
						<span class="caret"></span></a>
						
						<ul class="dropdown-menu" role="menu">
							<li><a href="dell?catname=Dell">Dell</a></li>
							<li><a href="#">HP</a></li>
							
						</ul>
					</li>
			</ul>
	
	<c:choose>
		<c:when test="${empty logUser}">
     <ul class="nav navbar-nav navbar-right">
      <li><a href="Register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    	</c:when>
    	
    	<c:when test="${not empty logUser}">
    	 <ul class="nav navbar-nav navbar-right">
      		<li><a href="Logoutuser"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    	 </ul>
    	</c:when>
    	
    </c:choose>
    	
  </div>
</nav>
</body>
</html>