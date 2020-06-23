<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Insérer un produit - Fruits Market</title>
  </head>
<body>
        <h1 class="text-logo"><span class="glyphicon glyphicon-cutlery"></span> FruitsMarket<span class="glyphicon glyphicon-cutlery"></span></h1>
         <div class="container admin">
            <div class="row">
                <h1><strong>Ajouter un produit</strong></h1>
                <br>
                <form class="form" method="post" action="insert" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="nom">Nom:</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" required>
                        <span class="help-inline"></span>
                    </div>
                    <div class="form-group">
                        <label for="portion">Portion:</label>
                        <input type="text" class="form-control" id="portion" name="portion" placeholder="Portion (Les 100 gr, la pièce...)" required>
                        <span class="help-inline"></span>
                    </div>
                    <div class="form-group">
                        <label for="prix">Prix: (en €)</label>
                        <input type="number" step="0.01" class="form-control" id="prix" name="prix" placeholder="Prix" required>
                        <span class="help-inline"></span>
                    </div>
                    <div class="form-group">
                        <label for="categorie">Catégorie:</label>
                        <select class="form-control" id="categorie" name="categorie" required>
                        	<option value="fruits"> fruits </option>
                        	<option value="légumes"> légumes </option>
                        	<option value="salades"> salades </option>
                        </select>
                        <span class="help-inline"></span>
                    </div>
                    <div class="form-group">
                        <label for="image">Sélectionner une image:</label>
                        <input type="file" id="image" name="image" required> 
                        <span class="help-inline"></span>
                    </div>
                    <br>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span> Ajouter</button>
                        <a class="btn btn-primary" href="index"><span class="glyphicon glyphicon-arrow-left"></span> Retour</a>
                   </div>
                </form>
            </div>
        </div>   
</body>
</html>