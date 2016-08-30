<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Drop.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<title>Login</title>
<style>

body {
  background-image: url(resources/images/laptop-grass.jpg);
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed;
   background-size: cover;
}

h3 {
    color: white;
}


</style>

</head>
<body>
<h3>${RegSuccess}</h3>
<h3>${error}</h3>
<div class="container">

<h1 class="well">Login to Your Account</h1>
	<div class="col-lg-12 well">
	<div class="row">
  			 <form action="Login" method="post">
 					<div class="form-group">
						<label>Username</label>
						<input type="text" name="username" placeholder="Username" class="form-control" required="true"/>
					</div>	
 					<div class="form-group">
						<label>Password</label>
						<input type="password" name="password" placeholder="Password" class="form-control" required="true" />
											</div>	
 <button type="submit" href="Home" class="btn btn-sm btn-primary">Sign in</button>
			
			<!--  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" > -->
			
		</form>
  </div>
</div>
</div>
</body>
</html>