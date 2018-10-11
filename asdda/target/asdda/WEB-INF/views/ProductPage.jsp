<%@include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Shopigo</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/ProductPage.css"/>
</head>


<body>
<br><br><br><br>

<div class="container">
	<div class="row">

		<c:forEach items="${listProducts}" var="product">
			<div class="col-md-4">
				<article class="col-item">

					<div class="photo">
						<a href="productDesc/${product.productId}"> 
						<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" 
								class="img-responsive" alt="Product Image" />
						</a>
					</div>
					<div class="info">
						<div class="row">
							<div class="price-details col-md-6">
								<h1>${product.productName}</h1>
								<span class="price-new">&#8377;${product.price}</span>
							</div>
						</div>
					</div>
				</article>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>

