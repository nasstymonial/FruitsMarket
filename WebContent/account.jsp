<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon compte - FruitsMarket</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<style>
   	<%@ include file="/css/account.css" %>
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
					<a href="Controller?page=account">Mon compte(<c:out value="${username }"></c:out>)</a></li>
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
	
     <div class="account">
		<c:choose>
			<c:when test="${session == null }">
				<p>Vous devez vous connectez pour accéder à cette page !</p>
				<a class="user my-2 my-sm-0 mr-2" href="Controller?page=login">
					Connectez-vous !
				</a>
	        </c:when>
			<c:when test="${session != null}">
				<h1>Mon compte(<c:out value="${username }"></c:out>)</h1>
				
			 	<font color="#28a745"><c:out value="${msgSuccess }"></c:out></font>
			 	
			 	<div>
				 	<a href="Controller?page=edit">
				 		<button type="button" class="btn btn-warning">Modifier le profil</button>
				 	</a>
				 	<br>
				 	<h5>Nom et Prénom : </h5>
				 	<c:out value="${ name }"></c:out>
				 	
				 	<br>
				 	<h5>Adresse : </h5>
				 	<c:out value="${ address }"></c:out>
				 	
				 	<br>
				 	<h5>Adresse mail: </h5>
				 	<c:out value="${ email }"></c:out>
				 	
				 	<h2>Mes dernières commandes</h2>
				 	
				  <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3308/fruitsmarket?useSSL=false&serverTimezone=UTC" var="ds"/>
	 
				  <sql:query var="result" dataSource="${ds }">
			 
					 select * from `order` where id_user = ${ id }
					 
				   </sql:query>
				   
				   <table class="table table-striped table-bordered">
                
	                <tbody>
	                	<c:forEach items="${result.rows }" var="row">
		                    <tr>
			                    <td><c:out value="${row.date_order }"></c:out></td>
			                    <td><c:out value="${row.total }"></c:out> €</td>
			                    <td><c:out value="${row.name_user }"></c:out></td>
		                    </tr>
		                </c:forEach>
	                </tbody>
	              </table>
			 	</div>
			</c:when>	          
  		</c:choose>
 	</div>
 	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
</body>
</html>