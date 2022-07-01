<%@page import="fr.teamA.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.teamA.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link href="ressources/css/styleAccueil.css" rel="stylesheet">
    <title>Accueil</title>
</head>
<body>
		<header>
			<nav id="nav">
				<div class="navItem">
					<h2>Eni-Encheres</h2>
				</div>
				<div class="navItem">
					<a href="seconnecter">S'incrire - Se connecter</a>
				</div>
				
			</nav>
		</header>
		<h3>Liste des enchères</h3>
		

	<section>
	
		<form action="Accueil" method="post">
			<div class="container">
				<div class="item">
					<label for="contient">Filtres : </label> <input type="text" name="contient" id ="contient">
				</div>
				<div class="item">
					<label for="categorie">Catégorie : </label> 
					<select id="categorie" name="categorie">
						<option>Toutes
						<option>Informatique
						<option>Ameublement
						<option>Vêtement
						<option>Sport&Loisirs
					</select>
				</div>
				<div>
					<div class= "item2">
						<input class="valider"type="submit" value="Rechercher" /> 
					</div>
				</div>
			
			</div>
		
		</form>
		
		<c:if test = "${empty listeArticleVendu}">
			<p >Il n'y a pas d'enchère en cours, vous n'avez pas quelque chose à proposer à la vente?</p>
			
		</c:if>	
		
		<c:if test = "${not empty listeArticleVendu}">
			<div>
				<c:forEach var="ArticleVendu" items="${listeArticleVendu}">
					<div>
						<p>${ArticleVendu.nomArticle}</p>
						<p>Prix : ${ArticleVendu.miseAPrix}<p>
						<p>Fin de L'enchère: ${ArticleVendu.dateFinEncheres}<p>
						<p>vendeur : </p>
					</div>
				</c:forEach>
			</div>
		</c:if>	
				
		
		</br>
		</br>
		
	</section>
		
		
</body>
</html>