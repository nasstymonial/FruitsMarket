<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S'inscrire - FruitsMarket</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<style>
   	<%@ include file="/css/inscription.css" %>
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
	    <div class="mx-auto">
	        <h1>Créer un compte</h1>
	        <form method="POST" action="Controller">
	         	<input type="hidden" name="page" value="sign-up-form">
	         	
	         	<!-- Validations errors -->
	 			<font color="#F24638"><c:out value="${msg }"></c:out></font>
	 			
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="text" name="name" class="form-control" placeholder="Votre nom et prénom" value="<c:out value="${name }"></c:out>" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="email" name="email"  class="form-control"placeholder="Votre adresse éléctronique" value="<c:out value="${email }"></c:out>" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="text" name="username"  class="form-control" placeholder="Votre nom d'utilisateur" value="<c:out value="${username }"></c:out>" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="text" name="address" class="form-control" placeholder="Votre adresse" value="<c:out value="${address }"></c:out>" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="password"  class="form-control" name="password_1" placeholder="Entrez un mot de passe" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <input type="password" class="form-control" name="password_2" placeholder="Confirmez votre mot de passe" required>
	                </div>
	            </div>
	            <div class="form-group row">
	                <div class="col-sm-10">
	                <button type="submit" name="login" class="btn btn-success">S'inscrire</button>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>
	
		<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
</body>
</html>