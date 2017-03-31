<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
		<h1>Bienvenue</h1>
	
	<iframe src="https://taxiriviera.herokuapp.com/" width="50%"
		height="400"> 
	</iframe>
	
	<div class="eco">
		<img src="${pageContext.request.contextPath}/resources/images/eco.gif"
			width="600px">
	</div>
	<div class="login" style="display: inline">

	<img src="${pageContext.request.contextPath}/resources/images/ecotrajet.jpg"
			width="300px">
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