<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br><br><br><br>
<div class="container">

<table align="center" class="table table-striped table-bordered" >
	<tr><td colspan='6' style="text-align:center;"> <strong>ORDER SUMMARY</strong></td></tr>
	<tr>
		<td><strong>Product Name</strong></td>
		<td><strong>Price</strong></td>
		<td><strong>Quantity</strong></td>
		<td><strong>SubTotal</strong></td>
		<td></td>
	</tr>
		
		<c:if test="${not empty listCartItems}">
		<c:forEach items="${listCartItems}" var="cart">
		
		<tr>
			<td>${cart.productName}</td>
			<td>&#8377;${cart.price}</td>
			<td>${cart.quantity}</td>
			<td>&#8377;${cart.price * cart.quantity}</td>
			<td><img src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="50" height="50"/></td>
		</tr>
		</c:forEach>
		</c:if>
		<tr>
			<td colspan="3"><strong>Total Cost</strong></td>
			<td colspan="2"><strong>&#8377;${totalCost}</strong></td>
		</tr>
	
</table>

<%-- <form action="paymentConfirmation" method="post">
<table align="center" width="100%">
	<tr><td colspan="2"></td><td><strong>Payment Details</strong></td></tr>
	<tr><td colspan="3"><input type="radio" name="mode" value="Cash">Cash</td>
	<td colspan="3"><input type="radio" name="mode" value="Card">Credit Card</td></tr>
	<tr><td colspan="2"><center><input type="submit" value="Proceed to Pay" class="btn btn-info btn-block"></center></td></tr>
</table>
</form> --%>

				<div class="col-sm-12 col-md-6 text-right">
                    <a href="<c:url value="/paymentConfirmation"/>" class="btn btn-lg btn-block btn-success text-uppercase">Place Order</a>
                </div>

</div>

<%@include file="Footer.jsp"%>