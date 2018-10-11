<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h3 align="center" >Product Page</h3>

<c:if test="${product!=null}">
<div class="container">
<form:form method="post" action="product/save" modelAttribute="product" enctype="multipart/form-data">
	
	<div class="col-md-6 form-line">
		<div class="form-group">
			<label for="pname">Product Name</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box-open" aria-hidden="true"></i></span>
			<form:input path="productName" id="pname" cssClass="form-control" value = "${selectedProduct.productName}"/>
			</div>
		</div>
	</div>
	
	<div class="col-md-6">	
		<div class="form-group">
			<label for="pdesc">Product Desc</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-clipboard" aria-hidden="true"></i></span>
			<form:input path="prodDesc" id="pdesc" cssClass="form-control" value = "${selectedProduct.prodDesc}"/>
			</div>
		</div>	
	</div>	
	
	<div class="col-md-6">	
		<div class="form-group">
			<label for="pprice">Product Price</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-rupee-sign" aria-hidden="true"></i></span>
			<form:input path="price" id="pprice" cssClass="form-control" value = "${selectedProduct.price}"/>
			</div>
		</div>	
	</div>
	
	<div class="col-md-6">	
		<div class="form-group">
			<label for="pstock">Product Stock</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-dolly" aria-hidden="true"></i></span>
			<form:input path="stock" id="pstock" cssClass="form-control" value = "${selectedProduct.stock}"/>
			</div>
		</div>	
	</div>
			
	<div class="col-md-6">	
		<div class="form-group">
			<label for="pcat">Category</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<form:select path="categoryId" id="pcat" cssClass="form-control">
				<form:option value="0" label="--select--"/>
				<form:options items="${categoryList}"/>
			</form:select>
			</div>
		</div>
	</div>
	
	<div class="col-md-6">	
		<div class="form-group">
			<label for="pimg">Product Image</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-image" aria-hidden="true"></i></span>
			<form:input type="file" path="pimage" id="pimg" cssClass="form-control" value = "${selectedProduct.pimage}"/>
			</div>
		</div>
	</div>
		
	<div align="center">
		<button type="submit" class="btn btn-success">Submit</button>
		<button type="reset" class="btn btn-warning">Reset</button>
	</div>

</form:form>
</div>
</c:if>


<br><br>
	<h3 align="center">LIST OF PRODUCTS</h3>
	<div class="container">
	<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Added Date</th>
			<th>Category ID</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="product" items="${listProducts}">
		  <tr>
			<td>${product.productId}</td>
			<td style="width:200px;">${product.productName}</td>
			<td style="width:300px;" style="text-align: justify;">${product.prodDesc}</td>
			<td>&#8377;${product.price}</td>
			<td>${product.stock}</td>
			<td>${product.added_date}</td>
			<td>${product.categoryId}</td>
			<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50" height="50"/></td>
			<td>
			<a href="product/edit/${product.productId}" class="btn btn-sm btn-info">
				<i class="fas fa-edit"></i> Edit</a>
			<a href="product/delete/${product.productId}" class="btn btn-sm btn-danger">
				<i class="fas fa-trash"></i> Delete</a>
			</td>
		  </tr>
		</c:forEach>
	  </tbody>
	</table>
	</div>
	</div>

</body>
</html>