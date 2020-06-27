<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un produit - FruitsMarket</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	
	<style>
    	<%@ include file="/css/adminEditProduct.css" %>
	</style>
	
	<aside id="pop_up" class="popup" aria-hidden="true" role="dialog" aria-labelledby="add_product">
		<div class="mx-auto contenu-popup">
			<span class="popup-close">
				<a href="admin?page=index" class="close">
					<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-x-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
					  <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
					  <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
					</svg>
				</a>
			</span>
			<h1>Modifier un produitt</h1>
			<form method="post" action="admin">
			
			<input type="hidden" name="page" value="edit_product">
			<input type="hidden" name="id" value="<c:out value="${p.getId() }"/>">
			
			<div class="form-row">
				<div class="form-group">
			 		<label>Nom</label>
			 		<input type="text" name="name" value="<c:out value="${p.getName() }"></c:out>" required>
				  </div>
			</div>
			<div class="form-row">
				  <div class="form-group ">
			 		<label>Prix</label>
			 		<input type="number" name="price" step="0.01" value="<c:out value="${p.getPrice() }"></c:out>" required>
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group">
			 		<label>Categorie</label>
			 		<input type="text" name="category" value="<c:out value="${p.getCategory() }"></c:out>" required>
			    </div>
			   </div>
			   <div class="form-row">
			    <div class="form-group">
					<label>En vedette</label>
					<input type="text" name="featured" value="<c:out value="${p.getFeatured() }"></c:out>" required>
			    </div>
			  </div>
			  <div class="form-group">
		 		 <label> Image du produit</label>
				 <img style="height: 30%;width: 30%;" src="<c:out value="${p.getImage() }"></c:out>">
			  </div>
			  
			  <button type="submit" class="btn btn-success">Modifier</button>
			</form>
		</div>
	</aside>
	
</body>
</html>