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
		<h1> Liste de toutes les promotions </h1>
    
   		<form method="post" action="suppresion">
			<c:forEach items="${form.listeEtuParPromo}" var="entry"> 
            	<fieldset>            
                
					<h2>Promotion : ${entry.key.nomPromotion} , Moyenne de la promotion ${entry.key.moyennePromotion} </h2>
					
					<c:forEach items="${entry.value}" var="item" >
						<label><input type='checkbox' name="etudiant" value="${item.nomEtu}"/>${item.nomEtu} Moyenne generale ${item.moyenneGeneral}</label>
						<br>
					</c:forEach>
					
           	 	</fieldset>            
			</c:forEach>
			<br><br>
	        <input type="submit" value="Supprimer les élèves selectionnés"/>
	        
   	 	</form>
   	 	
        <br><br>		        
   	    <form method="post" action="Deconnexion">
	        <input type="submit" value="Deconnexion" class="sansLabel" />
	    </form>
    </body>
</html>