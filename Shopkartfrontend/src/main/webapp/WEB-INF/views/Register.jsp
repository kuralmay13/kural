<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Drop.jsp" %>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Register</title>
<style>

body {
  background-image: url(resources/images/laptop-grass.jpg);
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed;
   background-size: cover;
}

</style>
</head>
<body>

	<div class="container">
    <h1 class="well">Registration Form</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form:form action="Register" commandName="user"  method="post" >
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>User Name</label>
								<form:input path="username" type="text" placeholder="Username" class="form-control" required="true" />
								<form:errors path="username" />
							</div>
							</div>					
						
						<div class="form-group">
							<label>Address</label>
							 <form:input path="address" type="text" placeholder="Address" rows="3" class="form-control" required="true"/>
							 <form:errors path="address" />
						</div>	
						
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label>
								<form:input path="city" type="text" placeholder="City" class="form-control" required="true"/>
								<form:errors path="city" />
							</div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<form:input path="state" type="text" placeholder="State" class="form-control" required="true"/>
								<form:errors path="state" />
							</div>	
							<div class="col-sm-4 form-group">
								<label>Pincode</label>
								<form:input path="pincode" type="text" placeholder="Pincode" class="form-control" required="true"/>
								<form:errors path="pincode" />
							</div>		
						</div>					
					<div class="form-group">
						<label>Phone Number</label>
						<form:input path="phonenumber" type="text" placeholder="Phone Number" class="form-control" required="true"/>
						<form:errors path="phonenumber" />
					</div>		
					<div class="form-group">
						<label>Email Address</label>
						<form:input path="email" type="text" placeholder="Email Address" class="form-control" required="true"/>
						<form:errors path="email" />
					</div>	
					<div class="form-group">
						<label>Password</label>
						<form:input path="password" type="password" placeholder="Password" class="form-control" required="true"/>
						<form:errors path="password" />
					</div>
					
					<button type="submit" href="Login" class="btn btn-lg btn-info">Submit</button>				
					</div>
				</form:form> 
				</div>
				</div>
				</div>
			
				

</body>
</html>