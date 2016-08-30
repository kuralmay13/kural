<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Admin.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Supplier</title>
</head>
<body>
<div class="col-sm-12">
<div class="row">
<form:form action="Supplier" commandName="supplier"  method="post" >
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
			<label>Name</label>
				<form:input path="name" type="text" class="form-control" required="true"/>
		</div></div></div>
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
			<label>Address</label>
				<form:input path="address" type="text" class="form-control" required="true"/>
		</div></div></div>
		
		<div class="col-sm-12">
		<div class="row">
<div>
<div class="col-sm-4 form-group">
<button type="submit" class="btn btn-primary btn-lg btn-block">Add supplier</button></a>
</div></div></div></div><br>
<div class="col-sm-12">
<div class="row">
<div>
<div class="col-sm-4 form-group">
<a href="SupplierList" button type="submit" class="btn btn-primary btn-lg btn-block">View supplier</button></a>
</div></div></div></div>
</form:form>
</div>
</div>
</body>
</html>