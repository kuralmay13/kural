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
<title>Product</title>
<script>
$(document).on('ready', function() {
    $("#input-6").fileinput({
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });
});
</script>
</head>
<body>
<div class="col-sm-12">
<div class="row">
<form:form action="Product" commandName="product"  method="post" enctype="multipart/form-data" >
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group"> 
			<label>Name</label>
				<form:input path="name" type="text" class="form-control" required="true"/>
		</div></div></div>
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
			<label>Description</label>
				<form:input path="description" type="text" class="form-control" required="true"/>
		</div></div></div>
		
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
			<label>Price</label>
				<form:input path="price" type="number" class="form-control" required="true"/>
		</div></div></div>
		
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
					<form:label path="category">Category</form:label>
					<form:select path="category.name" class="form-control" items="${categoryList}" 
					itemLabel="name" itemValue="name" />
		</div></div></div>
		
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
			<label>Supplier</label>
				<form:input path="supplier" type="text" class="form-control" required="true"/>
		</div></div></div>
		
		<div class="col-sm-12">
		<div class="row">
		<div class="col-sm-4 form-group">
		  <label for="file" >File to upload:</label>
		  <form:input type="file" id="file" path="file" class="form-contorl" />	
		</div></div></div>
		
		
		<div class="col-sm-12">
		<div class="row">
<div>
<div class="col-sm-4 form-group">
<button type="submit" class="btn btn-primary btn-lg btn-block">Add product</button></a>
</div></div></div></div><br>
<div class="col-sm-12">
<div class="row">
<div>
<div class="col-sm-4 form-group">
<a href="ProductList" button type="submit" class="btn btn-primary btn-lg btn-block">View product</button></a>
</div></div></div></div>

         
			
</form:form>
</div>
</div>

</body>
</html>