<%@page import="fr.teamA.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="fr.teamA.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link href="ressources/css/style.css" rel="stylesheet">
    <title>Creation utilisateur</title>
</head>
<body>
		<header>
			<h2>Eni-Encheres</h2>
		</header>
		<h3>Mon profil</h3>
		

	<div class="insertion">

		<%
		int ok = 0;
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if (listeCodesErreur != null) {
			ok = 1;
		%>
		<p style="color: red;">Erreur, L'utilisateur n'a pas été ajouté :</p>
		<%
		for (int codeErreur : listeCodesErreur) {
		%>
		<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%
		}
		}
		%>

		<%
		Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
		if (utilisateur != null) {
		%>
		<p
			style="color: green; text-decoration: blink; background-color: yellow">l'utilisateur
			a été ajouté :</p>

		<%
		}
		%>
		</br>
		</br>
		</div>
		
		
		<form action="ProfilCreation" method="post">
			<div class="container">
			<div class="item">
				<label for="pseudo">Pseudo : </label> <input type="text" name="pseudo" id="pseudo">
				
			</div>
			<div class="item">
				<label for="nom">Nom: </label> <input type="text" name="nom" id ="nom">
				
			</div>
			<div class="item">
				<label for="prenom">Prenom : </label> <input type="text" name="prenom" id="prenom" />
			</div>
			<div class="item">
				<label for="email">Email : </label> <input type="email" name="email" id="email">
			</div>
			<div class="item">
				<label for="telephone"> Telephone : </label> <input type="text"	name="telephone" id="telephone">
			</div>
			<div class="item">
				<label for="rue">Rue : </label> <input type="text" name="rue" id="rue">
			</div>
			<div class="item">
				<label for="code_postal"> code_postal : </label> <input type="text"	name="code_postal" id="code_postal">
			</div>
			<div class="item">
				<label for="ville">Ville : </label> <input type="text" name="ville" id="ville">
			</div>
			<div class="item">
				<label for="motDePasse">Mot de passe : </label> <input type="password" name="motDePasse" id="motDePass">
			</div>
			<div class="item">
				<label for="verifMDP">Confirmation : </label> <input type="password" name="verifMDP" id="verifMDP">
			</div>
			
			</div>
			</br>
			</br>
			<div class="container2">
				<div class= "item2">
				<input class="valider"type="submit" value="Valider" /> 
				</div>
				<div class= "item2">
				<a href="<%=request.getContextPath()%>">
				<input class="valider" type="reset" value="Annuler" /></a>
				</div>
			</div>
				
		</form>
		


</body>
</html>