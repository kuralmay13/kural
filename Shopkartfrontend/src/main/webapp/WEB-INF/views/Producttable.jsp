<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Admin.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
<title>ProductTable</title>
</head>
<body ng-app="prdapp" ng-controller="prdCtrl">
<table  class="table table-striped" border="1">
	<thead>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Category</th>
	<th>Supplier</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	</thead>
	<tbody >
	<tr ng-repeat="prd in product ">
	<td>{{prd.id}}</td>
	<td>{{prd.name}}</td>
	<td>{{prd.description}}</td>
	<td>{{prd.category.id}}</td>
	<td>{{prd.supplier}}</td>
	<td><a href="editprd?id={{prd.id}}">Edit</a></td>
	<td><a href="remove?id={{prd.id}}" >Delete</a></td>
	</tr>
	</tbody>
</table>
<script type="text/javascript">
var products=${prct};
var prdapp=angular.module("prdapp",[]);
prdapp.controller("prdCtrl", function($scope,$http){
	$scope.product=products;
});
</script>
</body>
 