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

  <link href="ressources/css/styleProfilModification.css" rel="stylesheet">
    <title>Modification utilisateur</title>
</head>
<body>
		<header>
			<h1>Eni-Enchêres</h1>
		</header>
		
		
	<div id="parent">
		<section id="globale">
		<h3>Mon profil</h3>
			<div class="insertion">
				
				<c:if test = "${not empty listeCodesErreur}">
					<p style="color: red;">Erreur :</p>
					
					<c:forEach var="codeErreur" items="${listeCodesErreur}">
						<p>${LecteurMessage.getMessageErreur(codeErreur)}
					</c:forEach>
					
				</c:if>
				
				</br>
				</br>
				
			</div>
				
				<form action="ProfilCreation" method="post">
					<div class="container">
						<div class="item">
							<label for="pseudo">Pseudo : </label> <input type="text" name="pseudo" id="pseudo" value ="${utilisateur.pseudo}">
							
						</div>
						<div class="item">
							<label for="nom">Nom: </label> <input type="text" name="nom" id ="nom" value ="${utilisateur.nom}">
							
						</div>
						<div class="item">
							<label for="prenom">Prenom : </label> <input type="text" name="prenom" id="prenom" value ="${utilisateur.prenom}" />
						</div>
						<div class="item">
							<label for="email">Email : </label> <input type="email" name="email" id="email" value ="${utilisateur.email}">
						</div>
						<div class="item">
							<label for="telephone"> Telephone : </label> <input type="text"	name="telephone" id="telephone" value ="${utilisateur.telephone}">
						</div>
						<div class="item">
							<label for="rue">Rue : </label> <input type="text" name="rue" id="rue" value ="${utilisateur.rue}">
						</div>
						<div class="item">
							<label for="code_postal"> Code postal : </label> <input type="text"	name="code_postal" id="code_postal" value ="${utilisateur.codePostal}">
						</div>
						<div class="item">
							<label for="ville">Ville : </label> <input type="text" name="ville" id="ville" value ="${utilisateur.ville}">
						</div>
						<div class="item" id="actuel">
							<label for="motDePasse">Mot de passe actuel : </label> <input type="password" name="motDePasse" id="motDePass" value ="${utilisateur.motDePasse}">
						</div>
						<div class="item" id="vide">
							
						</div>
						<div class="item" id="new">
							<label for="motDePasse">Nouveau Mot de passe : </label> <input type="password" name="motDePasse" id="motDePass">
						</div>
						<div class="item">
							<label for="verifMDP">Confirmation : </label> <input type="password" name="verifMDP" id="verifMDP">
						</div>
					</div>
					<div class="item" id="credits">
						<label for="credit">Crédit : </label> <output type="number" name="credit" id="credit" value ="${utilisateur.credit}">
					</div>
					
					
					
					</br>
					</br>
					
					<div class="container2">
						<div class= "item2">
						<input id="enregistrer"type="submit" value="Enregistrer" /> 
						</div>
						
							<div class= "item2" >
								<a href="ProfilSuppression">supprimer </a>
							</div>
					
						<div class= "item2">
							<div id="hidden">
								<a href="Accueil"><input id="annuler" type="reset" value="Annuler" /></a>
							</div>
						</div>
					</div>
						
				</form>
			</section>
		</div>
</body>
</html>