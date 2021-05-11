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
				    <br/><br/><br/>
				    
			        <table border="1">
	            	<tr>
	            		<th> Nom de l'étudiant </th>
            			<th> Moyenne générale </th>
	            	</tr>
						<c:forEach items="${entry.value}" var="item" >
			            	<tr>      
			            		<td> <label><input type='checkbox' name="etudiant" value="${item.nomEtu}"/>${item.nomEtu} </label></td> <td> <label>Moyenne generale ${item.moyenneGeneral}</label><td>
		                	</tr>
						</c:forEach>
				    </table>
					
           	 	</fieldset>            
			</c:forEach>
			<br><br>
	        <input type="submit" value="Supprimer les élèves selectionnés"/>
   	 	</form>
   	 	
   	 	<br>
   	 	
   		<form method="get" action="NewPromotion">
	        <input type="submit" value="Créer une nouvelle promotion" class="sansLabel" />
	    </form>
   	 	
        <br>		        
   	    <form method="post" action="Deconnexion">
	        <input type="submit" value="Deconnexion" class="sansLabel" />
	    </form>
	    

    </body>
</html>