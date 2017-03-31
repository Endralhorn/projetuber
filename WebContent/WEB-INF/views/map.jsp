
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
	var isPassenger = FALSE;

	$(document).ready(function(){
		if (isPassenger){
	    	$("#isconducteur").hide();
	    	$("#ispassager").show();
	        }
	    else 
	    {
	    	$("#ispassager").hide();
	    	$("#isconducteur").show();
	    }
	    
	});
</script>


<meta charset="utf-8">
<link rel="stylesheet">
<title>Ecotrajet</title>

<style>
body {
	margin: 0;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>

<body>

	<div class="topnav">
		<a class="active" href="#home">accueil</a> <a href="#news">profil</a>
		<a href="#contact">historique</a> <a href="#about">deconexion</a>
	</div>

	<table width="44%">
		<tr>

			<td><iframe src="monadresse" width="100%" height="300%">

				</iframe> <br /> <span> <iframe id="isconducteur"
						src="listepassager" width="100%" height="300%"> </iframe> <iframe
						id="ispassager" src="listeconducteur" width="100%"
						height="300%"> </iframe>

			</span> <br /></td>
			<span id="map" style="width: 55.5%; height: 900px; float: right";></span>

			<script>
				function myMap() {
	 				var currUser = new google.maps.LatLng(50.6056026,3.1564853999999998) ;
	 				var users = [new google.maps.LatLng(50.60,3.156),
				 		new google.maps.LatLng(50.606,3.15),
				 		new google.maps.LatLng(50.603,3.154) ];

	  var myCenter = new google.maps.LatLng(50.6056026,3.1564853999999998); // a remplacer par la longitude et la lattitude de l'utilisateur qu'on chopera via fonction getlocate
	  var mapCanvas = document.getElementById("map");
	  var mapOptions = {center: myCenter, zoom: 13};
	  var map = new google.maps.Map(mapCanvas, mapOptions);

	  var marker_user = new google.maps.Marker({position:myCenter, animation: google.maps.Animation.BOUNCE, map: map});

	 var marker, i;

	    for (i = 0; i < users.length; i++) {  
	    	marker = new google.maps.Marker({
				position: users[i],	
				map: map

			});
		}

	}
	</script>

			<script
				src="https://maps.googleapis.com/maps/api/js?AIzaSyA4rhUkKEKOJ9u3CQa1JLx4j0M6Z6_vYqg&callback=myMap"></script>


		</tr>
	</table>

</body>
</html>
