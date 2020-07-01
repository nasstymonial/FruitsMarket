<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - FruitsMarket</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
  	<style>
    	<%@ include file="/css/style.css" %>
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
	              <a class="nav-link mr-5" href="admin?page=index">Produits</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link mr-5" href="admin?page=order">Commandes</a>
	            </li>
	          </ul>
 	  
	        </div>
	      </nav>
	
	    </div>
	</header>
	
	<h1>
		Bienvenue admin !
	</h1>
	
	 <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3308/fruitsmarket?useSSL=false&serverTimezone=UTC" var="ds"/>
	 
	  <sql:query var="result" dataSource="${ds }">
 
		 select * from `order`
		 
	   </sql:query>
	   
	  
	
	<div class="container">
		
      <div class="container admin">
          <font color="#28a745"><c:out value="${msgSuccess }"></c:out></font>
          
          <div class="row">
              <h1><strong>Liste des commandes </strong></h1>
              
              
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Date</th>
                    <th>Total</th>
                    <th>Nom du client</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${result.rows }" var="row">
	                    <tr>
		                    <td><c:out value="${row.id }"></c:out></td>
		                    <td><c:out value="${row.date_order }"></c:out></td>
		                    <td><c:out value="${row.total }"></c:out></td>
		                    <td><c:out value="${row.name_user }"></c:out></td>
		                    <td width="20%">
			                     <a class="btn btn-danger" href="<%= request.getContextPath() %>/admin?page=delete_order&id=${row.id}"><span class="glyphicon glyphicon-remove"></span> Supprimer</a>
		                    </td>
	                    </tr>
	                </c:forEach>
                </tbody>
              </table>
          </div>
      </div>
      </div>
	
</body>
</html>