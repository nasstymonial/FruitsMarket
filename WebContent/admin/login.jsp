<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
   	<%@ include file="/css/adminlogin.css" %>
</style>
	<div class="signup-header">
	 	<h2> Connexion Admin</h2>
	</div>

	<form method="post" action="admin">
	 
	 	<input type="hidden" name="page" value="admin-login-form">
	 
	 	<!-- Erreur -->
	 	<font color="#F24638"><c:out value="${msg }"></c:out></font>
	 
	 	<div class="signup-group">
	 		<label>Nom d'Utilisateur</label>
	 		<input type="text" name="username" placeholder="Votre nom d'utilisateur" value="<c:out value="${username }"></c:out>">
	 	</div>
	 	<div class="signup-group">
	 		<label>Mot de passe</label>
	 		<input type="password" name="password" placeholder="Votre mot de passe">
	 	</div>
	 	<div class="signup-group">
	 		<button type="submit" name="login" class="signup-btn">Connexion</button>
	 	</div>
	 </form>
</body>
</html>