<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="eco.css">
<title>Ecotrajet</title>
</head>
<body>
	<div class="eco">
		<img src="eco.gif" width="600px">
	</div>
	<h1>Inscription</h1>
	<div class="login">

		<img src="ecotrajet.jpg" width="300px">


		<form>

			<label for="nom">Nom :</label><input type="text" id="nom" /><br />
			<label for="prenom">Prénom :</label><input type="text" id="prenom" /><br />
			<label for="Mdp">Mot de Passe :</label><input type="text" id="Mdp" /><br />
			<label for="age">nom d'utilisateur :</label><select id="iduser"><option></option></select><br />
			<label for="Mdp">adresse :</label><input type="text" id="adresse" /><br />
			<label for="Mdp">email:</label><input type="text" id="Email" /><br />
			<input type="reset" name="Reset" id="button" value="Annuler" /> <input
				name="Cr&eacute;er" type="submit" value="Créer le profil" />
		</form>

	</div>





	<script type="text/javascript"
		src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".eco").fadeOut(2500, function() {
				$(".login").fadeIn(250);
			});
		})
	</script>
</body>
</html>