<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ShoppersHub</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="resources/css/HeaderStyle.css"/>
	
</head>


<body>

<br><br><br><br>

<div class="container">

<table align="center" class="table table-striped table-bordered" >
	<tr><td colspan='6'> <center>Your Cart</center></td></tr>
	<tr>
		<td><strong>Product Name</strong></td>
		<td><strong>Price</strong></td>
		<td><strong>Quantity</strong></td>
		<td><strong>SubTotal</strong></td>
		<td></td>
		<td><strong>Operations</strong></td>
	</tr>
		
		<c:if test="${not empty listCartItems}">
		<c:forEach items="${listCartItems}" var="cart">
		<form action="<c:url value="/updateCartItem/${cart.cartId}"/>" method="get">
		<tr>
			<td>${cart.productName}</td>
			<td>&#8377;${cart.price}</td>
			<td><input class="form-control" type="text" name="quantity" value="${cart.quantity}"/></td>
			<td>&#8377;${cart.price * cart.quantity}</td>
			<td><img src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="50" height="50"/></td>
			<td>
			<a href="<c:url value="/deleteCartItem/${cart.cartId}"/>" class="btn btn-sm btn-danger">
			<i class="fas fa-trash"></i> Delete</a>
			<button type="submit" class="btn btn-warning"><i class="far fa-edit"></i> Update</button>
			</td>
		</tr>
		</form>
		</c:forEach>
		</c:if>
		<c:if test="${empty listCartItems}">
			<tr><td colspan="6"><center><strong>You Have No Items in Cart</strong></center></td></tr>
		</c:if>
		<tr>
			<td colspan="3"><strong>Total Cost</strong></td>
			<td colspan="3"><strong>&#8377;${totalCost}</strong></td>
		</tr>
	
</table>

		<div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <a href="<c:url value="/products"/>" class="btn btn-lg btn-block btn-info text-uppercase">Continue Shopping</a>
                </div>
                <c:if test="${totalCost!=0}">
                <div class="col-sm-12 col-md-6 text-right">
                    <a href="<c:url value="/confirmOrder"/>" class="btn btn-lg btn-block btn-success text-uppercase">Checkout</a>
                </div>
                </c:if>
            </div>
        </div>
</div>

</body>
<%@include file="Footer.jsp"%>