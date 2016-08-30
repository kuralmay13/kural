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
  
<title>CategoryTable</title>
</head>
<body ng-app="catapp" ng-controller="catCtrl">
	<tr>
            <td align="right">Search :</td>
            <td><input ng-model="query" /></td>
     </tr>
      
<table class="table table-striped" border="1">
	
	<thead>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Description</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	</thead>
	
	<tbody >
	 
	<tr ng-repeat="cat in category" ng-repeat="cat in category | filter:query">
	<td>{{cat.id}}</td>
	<td>{{cat.name}}</td>
	<td>{{cat.description}}</td>
	<td><a href="editcat?id={{cat.id}}">Edit</a></td>
	<td><a href="delete?id={{cat.id}}" >Delete</a></td>
	</tr>
	</tbody>
</table>
<script type="text/javascript">
var categorys=${catlis};
var catapp=angular.module("catapp",[]);
catapp.controller("catCtrl", function($scope,$http){
	$scope.category=categorys;
});
</script>
</body>
 