<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier - FruitsMarket</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
  	<style>
    	<%@ include file="/css/cart.css" %>
	</style>
	<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<header>
	    <!-- NAVBAR-->
	    <div class="site-header sticky-top">
	
	      <nav class="navbar navbar-expand-lg navbar-light bg-light pr-5 pl-5">
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
	          <a class="navbar-brand" href="Controller?page=index"><img src="images/logo.png" width="35%" alt="FruitsMarket"></a>
	          <ul class="navbar-nav mr-auto mt-2 mt-lg-0 mx-auto">
	            <li class="nav-item">
	              <a class="nav-link mr-5" href="#">A propos</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link mr-5" href="#">Contact</a>
	            </li>
	          </ul>
	          
	          
	       	  <div class="connexionandcart">
	       	  	<c:choose>
	       	  		<c:when test="${session == null }">
			          <a class="user my-2 my-sm-0 mr-2" href="Controller?page=login">
			            <svg class="bi bi-person" width="1.5em" height="1.5em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			              <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
			            </svg>
			          </a>
		          </c:when>
				  <c:when test="${session != null}">
					<a href="Controller?page=logout" style="color: #F24638;">Déconnexion</a></li>
					<a href="#">Mon compte(<c:out value="${username }"></c:out>)</a></li>
				  </c:when>	          
	       	  	</c:choose>
		          
		          <a class="cart my-2 my-sm-0 mr-2" href="Controller?page=showcart">
		            <svg class="bi bi-cart" width="1.5em" height="1.5em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		              <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
		            </svg>
		            (<c:out value="${x}"/>)
		          </a>
	       	  </div>
	       	  
	        </div>
	      </nav>
	
	    </div>
	</header>
	
	<div class="container">
	
	<c:choose> 
		<c:when test="${x == 1}">
			<h4 style="margin-top: 40px;">Détail de votre panier(<c:out value="${x}"/> article)</h4>
			<br>
		</c:when>
		<c:when test="${x > 1}">
			<h4 style="margin-top: 40px;">Détail de votre panier(<c:out value="${x}"/> articles)</h4>
			<br>
		</c:when>
		<c:otherwise >
			<h4 style="margin-top: 40px;">Votre panier est vide</h4>
			<br>
		</c:otherwise>
	
	</c:choose>
	
		<c:set var="total" value="0"></c:set>
		<c:forEach items="${cartlist }" var="i">
			<c:forEach items="${list }" var="Product">
				<c:if test="${i == Product.getId() }">
				
				<c:set var="total" value="${total + Product.getPrice() }"></c:set>
				
			<table class="product" style="table-layout: fixed;width: 100%;">
				<tr>
					<th colspan="4"><h2><c:out value="${Product.getName()}"/></h2></th>
				</tr>
				<tr>
					<td style="width: 25%;"><img src="${Product.getImage()}" width="75%" ></td>
					<td style="width: 25%;"><c:out value="${Product.getPrice()}"/> €</td>
					<td style="width: 25%;"><c:out value="${Product.getCategory()}"/></td>
					<td style="width: 25%;"><a href="Controller?page=remove&id=<c:out value="${Product.getId()}"/>"><span class="btn btn-danger">Supprimer</span></a></td>
				</tr>
			</table>
				</c:if>
			</c:forEach>
		</c:forEach>
	
	<h4 style="margin-top: 40px;margin-bottom: 40px;">Total de la commande: <c:out value="${ total }"></c:out> €</h4>
	
	<a href="Controller?page=success"><input type="submit" value="Procéder au paiement" class="btn btn-success" style="width:100%;padding:8px;font-size:16px;"></a><br>
	<a href="Controller?page=index"><input type="button" value="Continuer à faire des achats" class="btn btn-warning" style="width:100%;padding:8px;font-size:16px;"></a>
	
	
	</div>


</body>
</html>