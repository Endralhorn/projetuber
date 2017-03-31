<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&language=fr">
</script>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet">
	<title>Ecotrajet</title>
<style>
	body {margin:0;}

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
	</head>
	<body>
	

	</br>

	<form>
	<div class="search">
	  <input type="text" id="adresseDepart"/>
	  <br/>
	  <input type="text" id="adresseArrivee"/>
	  <br/>
	  <!--input type="button"  value="Trajet" onclick="TrouverAdresse(document.getElementById('adresse').value);"/-->
	<input type="button"  value="Trajet" onclick="afficherTrajet();" />
	</form>


	<span id="text_latlng"></span>


	<div id="map-canvas" style="float:right;height:80%;width:45%"></div>

<script>
				function myMap() {
	 				var currUser = new google.maps.LatLng(50.6056026,3.1564853999999998);
	 				var users = [new google.maps.LatLng(50.60,3.156),
				 		new google.maps.LatLng(50.606,3.15),
				 		new google.maps.LatLng(50.603,3.154) ];


	  var myCenter = new google.maps.LatLng(50.6056026,3.1564853999999998); // a remplacer par la longitude et la lattitude de l'utilisateur qu'on chopera via fonction getlocate
	  var mapCanvas = document.getElementById("map");
	  var mapOptions = {center: myCenter, zoom: 13};
	  var map = new google.maps.Map(mapCanvas, mapOptions);

	  var marker_user = new google.maps.Marker({position:myCenter, map: map});


	 var marker, i;


	    for (i = 0; i < users.length; i++) {  
	    	marker = new google.maps.Marker({
				position: users[i],	
				map: map
			});
		}


	  google.maps.event.addListener(marker,'click',function() {
	    var infowindow = new google.maps.InfoWindow({
	      content:"Profil, Note, Prix " //a modifier avec lien en affichage direct interractif
	    });
	  infowindow.open(map,marker);
	  });

	}
	</script>

<script type="text/javascript">
	var geocoder;
	var map;
	//var dbg=document.getElementById('dbg');
	// initialisation de la carte Google Map de départ
		function initialiserCarte() {
	 	 geocoder = new google.maps.Geocoder();
		  // Ici j'ai mis la latitude et longitude de inicio pour centrer la carte de départ
	  	var latlng = new google.maps.LatLng(50.622712, 3.1231785999999997);
	 	 var mapOptions = {
		    zoom      : 14,
	 	   center    : latlng,
	  	  mapTypeId : google.maps.MapTypeId.ROADMAP
		  }
	  // map-canvas est le conteneur HTML de la carte Google Map
		  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
		}
	 
	function TrouverAdresse(adresse) {
	 
	  //var adresse = document.getElementById('adresse').value;
	  
	  geocoder.geocode( { 'address': adresse}, function(results, status) {
	    if (status == google.maps.GeocoderStatus.OK) {
	    
	      map.setCenter(results[0].geometry.location);
	      // Récupération des coordonnées GPS du lieu tapé dans le formulaire
	      var strposition = results[0].geometry.location+"";
	      strposition=strposition.replace('(', '');
	      strposition=strposition.replace(')', '');
	      // Affichage des coordonnées dans le <span>
	 
	      // Création du marqueur du lieu (épingle)
	      var marker = new google.maps.Marker({
	          map: map,
	          position: results[0].geometry.location
	      });
	    } else {
	      alert('Adresse introuvable: ' + status);
	    }
	  });
	}

	function afficherTrajet() {
		TrouverAdresse(document.getElementById('adresseDepart').value);
		TrouverAdresse(document.getElementById('adresseArrivee').value);
	}


	// Lancement de la construction de la carte google map
	google.maps.event.addDomListener(window, 'load', initialiserCarte);
</script>
</div>
