<!DOCTYPE html>
<html>
<style>
.findme{  
    float: center;
    text-align: center;
    color: green;
  }
}
table,th,td {
  border : 1px solid black;
  border-collapse: collapse;
}
th,td {
  padding: 5px;
}
</style>
<body>


<div class="findme">

<button type="button" onclick="loadXMLDoc()"> proche de moi </button>
<br><br>
<table id="demo"></table>

<script>
function loadXMLDoc() {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      myFunction(this);
    }
  };
  xmlhttp.open("GET", "ecotrajet", true);
  xmlhttp.send();
}
function myFunction(xml) {
  var i;
  var xmlDoc = xml.responseXML;
  var table="<tr><th>nom</th><th>prix</th><th>note</th></tr>";
  var x = xmlDoc.getElementsByTagName("conducteur");
  for (i = 0; i <x.length; i++) { 
    table += "<tr><td>" +
    x[i].getElementsByTagName("NOM")[0].childNodes[0].nodeValue +
    "</td><td>" +
     x[i].getElementsByTagName("PRIX")[0].childNodes[0].nodeValue +
    "</td><td>" +
    x[i].getElementsByTagName("NOTE")[0].childNodes[0].nodeValue +
    "</td></tr>";
  }
  document.getElementById("demo").innerHTML = table;
}
</script>
</div>
</body>
</html>
