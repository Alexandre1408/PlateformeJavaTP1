<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page etudiant</title>
</head>
<body>
	<h3>Nom étudiant: <c:out value="${etudiant.nomEtu}"/> </h3>
	<h4>Relevé de notes :</h4>
	<c:forEach var="e" items="${etudiant.listeNotes}">
    	${e.key.nomMatiere} : ${e.value} <br>
	</c:forEach>
	<!-- <p>azertyaa <c:out value="${etudiant.listeNotes['Anglais']}"/> afegreb</p> -->
</body>
</html>