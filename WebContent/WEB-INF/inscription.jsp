<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Inscription - Fruits Market</title>
</head>
<body>
    <style>
    	<%@ include file="/css/connexion.css" %>
	</style>
	
	<div class="mx-auto">
		<h1>Créer un compte</h1>
		<form method="post" action="inscription">
		<div class="form-row">
			 <div class="form-check form-check-inline col-md-2">
				<input class="form-check-input" type="radio" name="type" id="type" value="M" required>
				<label class="form-check-label" for="inlineRadio1">Mr</label>
			 </div>
			<div class="form-check form-check-inline col-md-2">
				<input class="form-check-input" type="radio" name="type" id="type" value="F" required>
				<label class="form-check-label" for="inlineRadio2">Mme</label>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
			    <label for="inputAddress">Nom</label>
			    <input type="text" class="form-control" name="nom" id="nom" placeholder="Votre nom" required>
			  </div>
			  <div class="form-group col-md-6">
			    <label for="inputAddress">Prénom</label>
			    <input type="text" class="form-control" name="prenom" id="prenom" placeholder="Votre prénom" required>
			  </div>
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputEmail4">Email</label>
		      <input type="email" class="form-control" name="mail" id="mail" placeholder="Votre adresse électronique" required>
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">Mot de passe</label>
		      <input type="password" class="form-control" name="motdepasse" id="motdepasse" placeholder="Votre mot de passe" required>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress">Adresse</label>
		    <input type="text" class="form-control" name="adresse" id="adresse" placeholder="Votre adresse" required>
		  </div>
		  <div class="form-group">
		    <label for="inputAddress2">Complément d'adresse</label>
		    <input type="text" class="form-control" name="complement_adresse" id="complement_adresse" placeholder="Apartement, Maison, Etage" required>
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputCity">Ville</label>
		      <input type="text" class="form-control" name="ville" id="ville" placeholder="Votre ville" required>
		    </div>
		    <div class="form-group col-md-3">
		      <label for="inputZip">Code postal</label>
		      <input type="text" class="form-control" name="code_postal" id="code_postal" placeholder="Votre code postal" required>
		    </div>
		    <div class="form-group col-md-3">
		      <label for="inputZip">Téléphone</label>
		      <input type="tel" class="form-control" name="telephone" id="telephone" value maxlength="32" placeholder="Votre numéro de téléphone" required>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck" required>
		      <label class="form-check-label" for="gridCheck">
		        Message concernant la confidentialité des données clients
				<i>
					Conformément aux dispositions de la loi du n°78-17 du 6 janvier 1978,
					vous disposez d'un droit d'accès, de rectification et d'opposition sur les données nominatives vous concernant.
				</i>
		      </label>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-success">S'inscrire</button>
		</form>
	</div>
	
</body>
</html>