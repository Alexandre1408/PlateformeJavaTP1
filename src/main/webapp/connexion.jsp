<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="admin">
            <fieldset>
                <legend>Connexion</legend>
                <label for="nom">Identifiant <span class="requis"></span></label>
                <input type="text" id="id" name="id" value="" size="20" maxlength="60" />
                <span class="erreur">${form.errors['nom']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
                <span class="erreur">${form.errors['mdp']}</span>
                <br />
                
                <input type="submit" value="Connexion" class="sansLabel" />
            </fieldset>
        </form>
        <form method="get" action="inscription">
            <fieldset>
                <input type="submit" value="Inscription" class="sansLabel" />
            </fieldset>
        </form>
    </body>
</html>