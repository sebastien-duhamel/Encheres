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

  <link href="<%=request.getContextPath()%>/ressources/css/style.css" rel="stylesheet">
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
		
		
		<form action="<%=request.getContextPath()%>/ServletProfilCreation" method="post">
			<div class="container">
			<div class="item">
				<label for="pseudo">Pseudo : </label> <input type="text"
					name="pseudo"
					value="<%=listeCodesErreur != null ? request.getParameter("pseudo") : ""%>" />
			</div>
			<div class="item">
				<label for="nom">Nom: </label> <input type="text" name="nom"
					value="<%=listeCodesErreur != null ? request.getParameter("nom") : ""%>" />
			</div>
			<div class="item">
				<label for="prenom">Prenom : </label> <input type="text"
					name="prenom"
					value="<%=listeCodesErreur != null ? request.getParameter("prenom") : ""%>" />
			</div>
			<div class="item">
				<label for="email">Email : </label> <input type="email" name="email"
					value="<%=listeCodesErreur != null ? request.getParameter("email") : ""%>" />
			</div>
			<div class="item">
				<label for="telephone"> Telephone : </label> <input type="text"
					name="telephone"
					value="<%=listeCodesErreur != null ? request.getParameter("telephone") : ""%>" />
			</div>
			<div class="item">
				<label for="rue">Rue : </label> <input type="text" name="rue"
					value="<%=listeCodesErreur != null ? request.getParameter("rue") : ""%>" />
			</div>
			<div class="item">
				<label for="code_postal"> code_postal : </label> <input type="text"
					name="code_postal"
					value="<%=listeCodesErreur != null ? request.getParameter("code_postal") : ""%>" />
			</div>

			<div class="item">
				<label for="ville">Ville : </label> <input type="text" name="ville"
					value="<%=listeCodesErreur != null ? request.getParameter("ville") : ""%>" />
			</div>

			<div class="item">
				<label for="motDePasse">Mot de passe : </label> <input
					type="password" name="motDePasse"
					value="<%=listeCodesErreur != null ? request.getParameter("motDePasse") : ""%>" />
			</div>
			<div class="item">
				<label for="verifMDP">Confirmation : </label> <input type="password"
					name="verifMDP"
					value="<%=listeCodesErreur != null ? request.getParameter("verifMDP") : ""%>" />
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