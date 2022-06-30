<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="fr.teamA.encheres.messages.LecteurMessage"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
</head>
<body>
	<c:if test = "${not empty listeCodesErreur}">
		
		<p style="color: red;">Erreur :</p>
		
		<c:forEach var="codeErreur" items="${listeCodesErreur}">
		<p>${LecteurMessage.getMessageErreur(codeErreur)}
		</c:forEach>
		</c:if>
	<form method="post">

		<label for="identifiant">Mail ou pseudo</label> 
		<input type="text"id="identifiant" name="identifiant" /> 
		<label for="motDePasse">Mot	de passe</label> 
		<input type="password" id="motDePasse" name="motDePasse" />
		<button type="submit">Connexion</button>

	</form>
</body>
</html>