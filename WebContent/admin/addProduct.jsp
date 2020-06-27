<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un produit - FruitsMarket</title>
 <!-- Bootstrap CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
	<style>
    	<%@ include file="/css/adminAddProduct.css" %>
	</style>
	
	<aside id="popup" class="popup" aria-hidden="true" role="dialog" aria-labelledby="add_product">
		<div class="mx-auto contenu-popup js-popup-stop">
			<span class="popup-close">
				<a href="admin?page=index" class="close">
				<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-x-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
				  <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
				  <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
				</svg>
				</a>
			</span>
			<h1>Ajouter un produit</h1>
			<form method="post" action="admin" enctype="multipart/form-data">
			
			<input type="hidden" name="page" value="add_product">
			
			<div class="form-row">
				<div class="form-group">
			 		<label>Nom</label>
			 		<input type="text" name="name" placeholder="Nom du produit"  required>
				  </div>
			</div>
			<div class="form-row">
				  <div class="form-group ">
			 		<label>Prix</label>
			 		<input type="number" name="price" step="0.01" placeholder="Prix du produit" required>
				  </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group">
			 		<label>Categorie</label>
			 		<input type="text" name="category" placeholder="Categorie du produit" required>
			    </div>
			   </div>
			   <div class="form-row">
			    <div class="form-group">
					<label>En vedette</label>
					 <div class="form-check form-check-inline col-md-2">
						<input class="form-check-input" type="radio" name="featured" id="featured" value="oui" required>
						<label class="form-check-label" for="inlineRadio1">Oui</label>
					 </div>
					<div class="form-check form-check-inline col-md-2">
						<input class="form-check-input" type="radio" name="featured" id="featured" value="oui" required>
						<label class="form-check-label" for="inlineRadio2">Non</label>
					</div>
			    </div>
			  </div>
			  <div class="form-group">
		 		 <label for="fileupload"> Image du produit</label>
		 		 <input type="file" name="image" required>
			  </div>
			  
			  <button type="submit" class="btn btn-success">Ajouter un produit</button>
			</form>
		</div>
	</aside>
	
</body>
</html>