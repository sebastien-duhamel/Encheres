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
		<nav id="nav">
				<div class="navItem">
					<h2>
						<jsp:include page="/WEB-INF/fragments/fragmentLogo.jsp"></jsp:include>
					</h2>				
				</div>
			</nav>
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
				
				<br/>
				<br/>
				
			</div>
				
				<form action="ProfilModification" method="post">
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
							<label for="mdpActuel">Mot de passe actuel : </label> <input type="password" name="mdpActuel" id="mdpActuel" value ="">
						</div>
						<div class="item" id="vide">
							
						</div>
						<div class="item" id="new">
							<label for="mdpFutur">Nouveau Mot de passe : </label> <input type="password" name="mdpFutur" id="mdpFutur">
						</div>
						<div class="item">
							<label for="verifMDP">Confirmation : </label> <input type="password" name="verifMDP" id="verifMDP">
						</div>
					</div>
					<div class="item" id="credits">
						<label for="credit">Crédit : ${utilisateur.credit}</label>
					</div>
					
					
					
					<br/>
					<br/>
					
					<div class="container2">
						<div class= "item2">
						<input id="enregistrer"type="submit" value="Enregistrer" /> 
						</div>
						
							<div class= "item2" >
								<a href="ProfilSuppression"><button id="supprimer">Supprimer mon compte</button></a>
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