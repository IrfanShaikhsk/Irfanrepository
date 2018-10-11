<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
		isELIgnored="false" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" 
		  rel="stylesheet" id="bootstrap-css">
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css"	href="resources/css/LoginFormStyle.css">
</head>

<body>
	<div class="container-fluid">
		 <div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12"> 
			<br><br><br>
			<c:if test="${msg!=null}">
				<div class="alert alert-success">
    				${msg}
  				</div>
  			</c:if>
				<!-- form start -->
				<form role="form" action="<c:url value='login' />" 
								  method="post" class="form-container">
					<h2>LOGIN</h2>
					<hr class="colorgraph"><br>
					<div class="form-group">
						<label for="username">Username</label> 
						<input type="text" class="form-control" name="username" 
						       id="username" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" name="password" 
							   id="password" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
				</form>
				<!-- form end -->
			 </div>
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
		</div> 
	</div>
</body>
</html>
<%@include file="Footer.jsp" %>