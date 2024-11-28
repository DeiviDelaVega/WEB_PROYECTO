<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Departamentos</title>
</head>
<body>
<h2>Registro de Departamentos</h2>
	<form action="departamento" method="post" enctype="multipart/form-data">
		<label for="nombre">Nombre:</label><br>
  		<input type="text" id="nombre" name="nombre"><br><br>
  		
  		<label for="capacidad">Capacidad:</label><br>
  		<input type="text" id="capacidad" name="capacidad"><br><br>
  		
  		<label for="nroHabitaciones">Número Habitaciones:</label><br>
  		<input type="text" id="nroHabitaciones" name="nroHabitaciones"><br><br>
  		
  		<label for="descripcion">Descripción:</label><br>
  		<input type="text" id="descripcion" name="descripcion"><br><br>
  		
  		<label for="serviciosIncluidos">Servicios Incluidos:</label><br>
  		<input type="text" id="serviciosIncluidos" name="serviciosIncluidos"><br><br>
  		
  		<!--  Radio botones para estado civil -->
  		<label for="disponibilidad">Disponibilidad:</label><br>
  		
  		<input type="radio" id="Si" name="disponibilidad" value="Si">
  		<label for="Si">Disponible</label><br>
  		
  		<input type="radio" id="No" name="disponibilidad" value="No">
  		<label for="No">Indisponible</label><br><br>

  		<label for="precioPorNoche">Precio por Noche:</label><br>
  		<input type="text" id="precioPorNoche" name="precioPorNoche"><br><br>
  		
  		<label for="imagenHabitacion">Imagen de la Habitacion:</label><br>
  		<input type="file" id="imagenHabitacion" name="imagenHabitacion"><br><br>

  		<input type="submit" value="Ingresar">
	</form>
</body>
</html>