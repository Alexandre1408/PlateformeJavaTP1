<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    </head>
    <body>
        <form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Formulaire d'inscription.</p>

                <label for="username">Nom d'utilisateur<span class="requis"> </span></label>
                <input type="text" id="username" name="username" value="<c:out value="${utilisateur.username}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['username']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['password']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis"></span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />

                <label for="name">Nom de l'étudiant (non nécessaire si compte administrateur)<span class="requis"> </span></label>
                <input type="text" id="name" name="name" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['name']}</span>
                <br />
                <div>
				<input type="checkbox" id="isadmin" name ="isadmin" value="administrateur">
				<label for="isadmin">Administrateur</label> 
				</div>
				
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
        <form method="get" action="connexion">
            <fieldset>
                <input type="submit" value="Connexion" class="sansLabel" />
            </fieldset>
        </form>
    </body>
</html>