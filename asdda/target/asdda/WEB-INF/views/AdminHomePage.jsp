<%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<title>Admin</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" 
		integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" 
		crossorigin="anonymous">
  	<link rel="stylesheet" type="text/css"	href="resources/css/ButtonStyle.css">
  	<link rel="stylesheet" type="text/css"	href="resources/css/InputStyle.css">
</head>
<body>

<br><br><br><br>

	<div class="container" align="center">
    	<a href="manage_categories" class="btn btn-lg btn-primary">
    		<i class="fas fa-box"></i>    Manage Categories</a>
    	<a href="manage_products" class="btn btn-lg btn-primary">
    		<i class="fas fa-boxes"></i>    Manage Products</a>
  	</div>  


	<c:if test="${isAdminClickedManageProducts==true}">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedManageCategories==true}">
		<jsp:include page="category.jsp"></jsp:include>
	</c:if>


</body>
</html>
<%@include file="Footer.jsp" %>