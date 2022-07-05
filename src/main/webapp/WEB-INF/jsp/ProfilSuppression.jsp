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

  <link href="ressources/css/style.css" rel="stylesheet">
    <title>Suppression utilisateur</title>
</head>
<body>
		<header>
			<h2>Eni-Encheres</h2>
		</header>
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
		
		<form action="ProfilSupression" method="post">
			<div class="container">
			<div class="item">
			
			<div class="item">
				<label for="credit">PROFIL SUPPRIME ainsi que ses articles : </label> <output type="number" name="credit" id="credit">
			</div>
			
			</div>
			
			</br>
			</br>
			
			<div class="container2">
				<div class= "item2">
				<input class="valider"type="submit" value="Enregistrer" /> 
				</div>
				<div class= "item2">
				<a href="<%=request.getContextPath()%>">
				<input class="valider" type="reset" value="Supprimer" /></a>
				</div>
			</div>
				
		</form>
		


</body>
