<%@page import="fr.teamA.encheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création Nouvel Utilisateur</title>
</head>
<body>
	<h1>Mon profil</h1>

	<div class="contenu">



		<%
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if (listeCodesErreur != null) {
		%>
		<p style="color: red;">Erreur, le repas n'a pas pu être ajouté :</p>
		<%
		for (int codeErreur : listeCodesErreur) {
		%>
		<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%
		}
		}
		%>

		<form action="<%=request.getContextPath()%>/ServletProfilCreation"
			method="post">
			<div class="saisie">
				<label for="pseudo">Pseudo : </label> <input type="text"
					name="pseudo" value="<%=request.getParameter("pseudo")%>" />
			</div>
			<div class="saisie">
				<label for="nom">Nom: </label> <input type="text" name="nom"
					value="<%=request.getParameter("nom")%>" />
			</div>
			<div class="saisie">
				<label for="prenom">Prenom : </label> <input type="text"
					name="prenom" value="<%=request.getParameter("prenom")%>" />
			</div>
			<div class="saisie">
				<label for="email">Email : </label> <input type="text" name="email"
					value="<%=request.getParameter("email")%>" />
			</div>
			<div class="saisie">
				<label for="telephone"> Telephone : </label> <input type="text"
					name="telephone" value="<%=request.getParameter("telephone")%>" />
			</div>
			<div class="saisie">
				<label for="rue">Rue : </label> <input type="text" name="rue"
					value="<%=request.getParameter("rue")%>" />
			</div>
			<div class="saisie">
				<label for="code_postal"> code_postal : </label> <input type="text"
					name="code_postal" value="<%=request.getParameter("code_postal")%>" />
			</div>
			
			<div class="saisie">
                <label for="ville">Ville : </label>
                <input type="text" name="ville" value="<%=request.getParameter("ville")%>"/>
            </div>
            
            <div class="saisie">
                <label for="motDePasse">Mot de passe : </label>
                <input type="text" name="motDePasse" value="<%=request.getParameter("motDePasse")%>"/>
            </div>
            <div class="saisie">
                <label for="verifMDP">Confirmation : </label>
                <input type="text" name="verifMDP" value="<%=request.getParameter("verifMDP")%>"/>
            </div>
			<div>
				<input type="submit" value="Valider" /> <a
					href="<%=request.getContextPath()%>"><input type="button"
					value="Annuler" /></a>
			</div>
		</form>

	</div>
</body>
</html>