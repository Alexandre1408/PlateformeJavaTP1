<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une nouvelle promotion</title>
    </head>
    <body>
        <form method="post" action="CreationPromotion">
            <fieldset>


                <label for="nompromotion">Nom de la nouvelle promotion<span class="requis"> </span></label>
                <input type="text" id="nompromotion" name="nompromotion" value="" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nompromotion']}</span>

         
                <br />
				
     			<c:forEach items="${list}" var="value">
  					<label><input type='checkbox' name="matiere" value="${value}"/>${value}</label>
  					<br>
 				</c:forEach>
			<br><br>

				
                <input type="submit" value="Créer la nouvelle promotion" class="sansLabel" />
                <br />
            
              
            </fieldset>
        </form>
    </body>
</html>