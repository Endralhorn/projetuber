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

	<div class="login">
		<h1>Bienvenue</h1>
		<img src="ecotrajet.jpg" width="300px">


		<form>

			<label for="nom">nom d'utilisateur :</label><input type="text"
				id="Iduser" /><br /> <label for="Mdp">Mot de Passe :</label><input
				type="text" id="Mdp" /><br /> <label for="Statut">Passager
				ou Conducteur :</label><select id="Statut"><option>Passager</option>
				<option>Conducteur</select> <br></br> <input type="reset"
				name="Reset" id="button" value="Annuler" /> <input name="login"
				type="submit" value="Connection" />

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