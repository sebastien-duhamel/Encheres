<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.teamA.encheres.messages.LecteurMessage"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link href="ressources/css/styleSeConnecter.css" rel="stylesheet">
  
<title>Se connecter</title>
</head>
<body>
	<header>
		<h2>Eni-Encheres</h2>
	</header>
	
		<div id="erreur">
			<c:if test = "${not empty listeCodesErreur}">
				
				<p style="color: red;">Erreur :</p>
				
				<c:forEach var="codeErreur" items="${listeCodesErreur}">
					<p>${LecteurMessage.getMessageErreur(codeErreur)}
				</c:forEach>
			</c:if>
		</div>
	
	<div class="principale">
		<form method="post" class="formulaire">
			<div class="item">
				<label for="identifiant" class="champs">Identifiant :</label> 
				<input type="text"id="identifiant" name="identifiant" placeholder="email ou pseudo"/> 
			</div>
			<div class="item">
				<label for="motDePasse" class="champs">Mot	de passe :</label> 
				<input type="password" id="motDePasse" name="motDePasse" />
			</div>
			<div id="container">
				<div>
					<button type="submit" id="connexion">Connexion</button>
				</div>
				<div id="souvenir">
					<div>
						<input type="checkbox" id="cocher" name="cocher"> <label for="cocher">Se souvenir de moi</label>
					</div>
					<div>
						<a href="#">Mot de passe oublié</a>
					</div>
				</div>
			</div>
		</form>
		
		<div id="creer">
			<a href="ProfilCreation"><button type="submit">Créer un compte</button></a>
		
		</div>
		
	</div>
</body>
</html>