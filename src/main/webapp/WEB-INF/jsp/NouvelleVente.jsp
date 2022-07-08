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

  <link href="ressources/css/NouvelleVente.css" rel="stylesheet">
    <title>Nouvelle vente</title>
</head>
<body>
		<header>
				<div class="navItem">
					<h2>Eni-Encheres</h2>
				</div>
				<div class="navItem">
				<h3>Nouvelle Vente</h3>
				</div>
				
<div class="container">
	<div class="row">
		<div class="article">
					<div id="img">
					<img src="ressources/unArticle.png"/>
					</div>
		</div>			
			</div>
			

			
<div class="container"/>
	<div class="row">
		<div class="item">
				<label for="nomArticle">Article: </label> <input type="text" name="nomArticle" id="nomArticle" />
		</div>
			
			 <form>
			 <div class="item"> 
			 	<label for="nomArticle">Description: </label>
      			<textarea name="description" rows="12" cols="35">Décrire l'article à mettre en vente</textarea><br>
      			</div>
    		</form>
    		
    		<form action="Accueil" method="post" class="formulaire">
						<div class="item">
							<label for="categorie" id="categorie">Catégorie : </label> 
							<select name="categorie">
								<option>Toutes
								<option>Informatique
								<option>Ameublement
								<option>Vêtement
								<option>Sport&Loisirs
							</select>
						</div>
			</form>
			
			
				<div class="item">
				<label for="image">Photo: </label> <input type="text" name="photo" id="photo" />
				<br>
				il faudra faire une servlet pour pouvoir upload une image
				</div>
			
				<div class="item" id="prix_vente">
						<label for="prix_vente">Mise à prix : </label> <input type="number" name="prix_vente" id="prix_vente" >
					</div>
			
				<div class="item" id="date_debut">
						<label for="date_debut">Début de l'enchère : </label> <input type="date" name="date_debut" id="date_debut" >
					</div>
			
				<div class="item" id="date_fin">
						<label for="date_fin">Fin de l'enchère : </label> <input type="date" name="date_fin" id="date_fin" >
					</div>
				
				
				<div class="container2">	
				<div class="column">
				<div class="item">
				<label for="retrait">Retrait:</label>
				<br>
				
				<label for="rue">Rue : </label>
				<input type="text" name="rue" id="rue" />
				</div>
				
				<div class="item">
				<label for="code_postal">Code Postal :  </label>
				<input type="text" name="code_postal" id="code_postal" />
    			</div>
    			
    			<div class="item">
				<label for="ville">Ville :  </label>
				<input type="text" name="ville" id="ville" />
    			</div>
    			
    			
    			</div>
    			</div>
   
</div>
</div>	

		</header>
		<br>
		<br>
<footer>
		<div class="container">
		<div class= "item2">
		<input id="enregistrer"type="submit" value="Enregistrer" /> 
		</div>
						
		<div class= "item2">
		<div id="hidden">
		<a href="Accueil"><input id="annuler" type="reset" value="Annuler" /></a>
		</div>
		</div>
	</div>	
		</footer>