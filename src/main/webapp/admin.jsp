<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Admin View</title>
    </head>
    <body>

		
		<c:forEach items="${form.listeEtuParPromo}" var="entry"> 
		
    		<h1>Promotion : ${entry.key.nomPromotion} , Moyenne de la promotion ${entry.key.moyennePromotion} </h1>
		    
		    <c:forEach items="${entry.value}" var="item" varStatus="loop">
		        ${item.nomEtu} Moyenne generale ${item.moyenneGeneral} <br>
		    </c:forEach>
		    
		</c:forEach>
 

    </body>
</html>