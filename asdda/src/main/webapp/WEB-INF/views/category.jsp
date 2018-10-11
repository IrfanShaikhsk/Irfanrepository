<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<c:if test="${flag}">
<div class="container">

<form action="category/update" method="post">
<div class="col-md-6 form-line">
		<div class="form-group">
			<label for="cname">Category Name</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryName" placeholder="Category Name" 
				   id="cname" value= "${selectedCategory.categoryName}">
			</div>
		</div>
		</div>
		
		<div class="col-md-6">
		<div class="form-group">
			<label for="cdesc">Category Description</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-clipboard" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryDesc" placeholder="Category Description" 
		       id="cdesc" value = "${selectedCategory.categoryDesc}" >
		    </div>
		</div>
		</div>
		
		<div class="col-md-6 form-line">
		<div class="form-group">
			<label for="cid">Category ID</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryId" placeholder="Category id" 
				   id="cid" value= "${selectedCategory.categoryId}" disabled="disabled">
			</div>
		</div>
		</div>
		
		<div align="center">
			<button type="submit" class="btn btn-success">Submit</button>
			<button type="reset" class="btn btn-warning">Reset</button>
		</div>
		
		</form>
		</div>
		</c:if>
		
	<br><br>
	 
	<div class="container">
	<form action="category/save" method="post">
		<div class="col-md-6 form-line">
		<div class="form-group">
			<label for="cname">Category Name</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryName" placeholder="Category Name" 
				   id="cname" value= "${selectedCategory.categoryName}">
			</div>
		</div>
		</div>
		
		<div class="col-md-6">
		<div class="form-group">
			<label for="cdesc">Category Description</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-clipboard" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryDesc" placeholder="Category Description" 
		       id="cdesc" value = "${selectedCategory.categoryDesc}" >
		    </div>
		</div>
		</div>
		
		<div class="col-md-6 form-line">
		<div class="form-group">
			<label for="cid">Category ID</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="categoryId" placeholder="Category id" 
				   id="cid" value= "${selectedCategory.categoryId}" disabled="disabled">
			</div>
		</div>
		</div>
		
		<div align="center">
			<button type="submit" class="btn btn-success">Submit</button>
			<button type="reset" class="btn btn-warning">Reset</button>
		</div>
		
	</form> 
	</div>
	
	<br><br><br><br>
	<h3 align="center">LIST OF CATEGORIES</h3>
	<div class="container">
	<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
	  </thead>	
			
	  <!--   display all the categories -->
		<tbody>
		  <c:forEach var="category" items="${listCategories}">
			<tr>
				<td>${category.categoryId}</td>
				<td style="width:30%">${category.categoryName}</td>
				<td>${category.categoryDesc}</td>
				<td> 
				<a href="<c:url value="category/edit/?categoryId=${category.categoryId}"/>" class="btn btn-sm btn-info">
					<i class="fas fa-edit"></i> Edit</a>
				<a href="<c:url value="category/delete/?categoryId=${category.categoryId}"/>" class="btn btn-sm btn-danger">
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