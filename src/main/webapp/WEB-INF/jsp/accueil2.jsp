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

  <link href="ressources/css/styleAccueil2.css" rel="stylesheet">
    <title>Accueil</title>
</head>
<body>
		<header>
			<nav id="nav">
				<div class="navItem">
					<h2>Eni-Encheres</h2>
				</div>
				<div class="navItem">
				<c:choose>
					<c:when test="${utilisateur!=null}">
						<jsp:include page="/WEB-INF/fragments/fragmentConnecter.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="/WEB-INF/fragments/fragmentNonConnecter.jsp"></jsp:include>
					</c:otherwise>
				</c:choose>					
				</div>
				
			</nav>
		</header>
		<h3>Liste des enchères</h3>
		

	<section class="centrale">
	
		<form action="AccueilFiltreDeconnection" method="post" class="formulaire">
	<!-- 		<div class="container2">	 -->
				<div class="item">
					<div id="filtres">
						<div><label for="contient">Filtres : </label> </div>
						<div><input type="text" name="contient" id ="contient" placeholder="&#x1F50D; Le nom de l'article contient"></div>
						<div>
							<label for="categorie" id="categorie">Catégorie : </label> 
							<select name="categorie">
								<option>Toutes
								<option>Informatique
								<option>Ameublement
								<option>Vêtement
								<option>Sport&Loisirs
							</select>
						</div>
					</div>
				</div>
				
					<div class= "item">
						<input id="rechercher"type="submit" value="Rechercher" />
					</div>
			
			
	<!-- 	</div>		 -->	
		
		</form>
		
		<div id="vide">
		<br>
			<c:if test = "${empty listeArticleFiltre}">
				<p >Il n'y a pas d'enchère en cours, vous n'avez pas quelque chose à proposer à la vente?</p>
				
			</c:if>	
		</div>
			
		<div id="liste">
			
			<c:if test = "${not empty listeArticleFiltre}">
				
					<c:forEach var="ArticleFiltre" items="${listeArticleFiltre}">
						<div class="articles">
							<div id="img">
								<img src="ressources/unArticle.png"/>
							</div>
							<div>
								<p>${ArticleFiltre.nomArticle}</p>
								<p>Prix : ${ArticleFiltre.miseAPrix}</p>
								<p>Fin de L'enchère: ${ArticleFiltre.dateFinEncheres}</p>
								<p>vendeur : ${ArticleFiltre.vendeur.pseudo }</p>
							</div>
						</div>
					</c:forEach>
				
			</c:if>	
			
		</div>		
		
		</br>
		</br>
		
	</section>
		
		
</body>
</html>