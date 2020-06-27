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
<body>

	<header>
		<h1>
			Bienvenue admin !
		</h1>
	</header>
	
	 <sql:setDataSource user="root" password="" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3308/fruitsmarket?useSSL=false&serverTimezone=UTC" var="ds"/>
	 
	  <sql:query var="result" dataSource="${ds }">
 
		 select * from product
		 
	   </sql:query>
	   
	  
	
	<div class="container">
		
      <div class="container admin">
          <font color="#28a745"><c:out value="${msgSuccess }"></c:out></font>
          
          <div class="row">
              <h1><strong>Liste des produits  </strong><a href="admin?page=addproduct" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-plus"></span> Ajouter</a></h1>
              
              
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Image</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Catégorie</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach items="${result.rows }" var="row">
	                    <tr>
		                    <td><c:out value="${row.id }"></c:out></td>
		                    <td><img src="${row.image}" width="30%" ></td>
		                    <td><c:out value="${row.name }"></c:out></td>
		                    <td><c:out value="${row.price }"></c:out></td>
		                    <td><c:out value="${row.category}"></c:out></td>
		                    <td width="20%">
			               
			                     <a class="btn btn-primary" href="<%= request.getContextPath() %>/admin?page=edit&id=${row.id}"><span class="glyphicon glyphicon-pencil"></span> Modifier</a>
			                    
			                     <a class="btn btn-danger" href="<%= request.getContextPath() %>/admin?page=delete&id=${row.id}"><span class="glyphicon glyphicon-remove"></span> Supprimer</a>
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