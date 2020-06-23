<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Admin - Fruits Market</title>
  </head>
<body>
      <h1 class="text-logo"><span class="glyphicon glyphicon-cutlery"></span> FruitsMarket <span class="glyphicon glyphicon-cutlery"></span></h1>
      <div class="container admin">
          <div class="row">
              <h1><strong>Liste des produits  </strong><a href="insert" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-plus"></span> Ajouter</a></h1>
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th>Nom</th>
                    <th>Portion</th>
                    <th>Prix</th>
                    <th>Catégorie</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                	<c:forEach var="products" items="${ products }">
	                    <tr>
		                    <td>${ products.nomProduits }</td>
		                    <td>${ products.portions }</td>
		                    <td>${ products.prix }</td>
		                    <td>${ products.type }</td>
		                    <td width=300>
			                     <a class="btn btn-default" href=""><span class="glyphicon glyphicon-eye-open"></span> Voir</a>
			               
			                     <a class="btn btn-primary" href=""><span class="glyphicon glyphicon-pencil"></span> Modifier</a>
			                    
			                     <a class="btn btn-danger" href=""><span class="glyphicon glyphicon-remove"></span> Supprimer</a>
		                    </td>
	                    </tr>
	                </c:forEach>
                </tbody>
              </table>
          </div>
      </div>
</body>
</html>