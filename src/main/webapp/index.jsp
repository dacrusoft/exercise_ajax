<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var nombreVar = $('#nombre').val();
			var apellidoVar = $('#apellido').val();
			var edadVar = $('#edad').val();
			
			$.post('ServletAccion', {
				nombre : nombreVar,
				apellido: apellidoVar,
				edad: edadVar
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
</script>
</head>
<body>

	<h2>Ejemplo AJAX - SERVLET</h2>
	
	<form id="formulario">
		Nombre: <input type="text" id="nombre"/><br>
		Apellido: <input type="text" id="apellido"/><br>
		Edad: <input type="text" id="edad"/><br>
		<input type="button" id="submit" value="Agregar"/>
	</form>
	
	<hr>
	
	<div id="tabla">
	</div>


</body>
</html>