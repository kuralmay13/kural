<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Register</title>
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
								<label>First Name</label>
								<form:input path="firstname" type="text" placeholder="First Name" class="form-control" />
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<form:input path="lastname" type="text" placeholder="Last Name" class="form-control" />
							</div>
						</div>					
						<div class="form-group">
							<label>Address</label>
							<form:input path="address" />
							<textarea placeholder="Address" rows="3" class="form-control"></textarea>
						</div>	
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label>
								<form:input path="city" type="text" placeholder="City" class="form-control" />
							</div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<form:input path="state" type="text" placeholder="State" class="form-control" />
							</div>	
							<div class="col-sm-4 form-group">
								<label>Pincode</label>
								<form:input path="pincode" type="text" placeholder="Pincode" class="form-control" />
							</div>		
						</div>					
					<div class="form-group">
						<label>Phone Number</label>
						<form:input path="phonenumber" type="text" placeholder="Phone Number" class="form-control" />
					</div>		
					<div class="form-group">
						<label>Email Address</label>
						<form:input path="email" type="text" placeholder="Email Address" class="form-control" />
					</div>	
					<div class="form-group">
						<label>Password</label>
						<form:input path="password" type="text" placeholder="Password" class="form-control" />
					</div>
					<div class="form-group">
						<label>Confirm Password</label>
						<form:input path="confirmpassword" type="text" placeholder="Confirm Password" class="form-control" />
					</div>
					<button type="button" href="Register" class="btn btn-lg btn-info">Submit</button>				
					</div>
				</form:form> 
				</div>
				</div>
				</div>

</body>
</html>