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
	<form action="departamento" method="post">
		<label for="nombre">Nombre:</label><br>
  		<input type="text" id="nombre" name="nombre"><br><br>
  		
  		<label for="capacidad">Capacidad:</label><br>
  		<input type="number" id="capacidad" name="capacidad" min=1><br><br>
  		
  		<label for="nroHabitaciones">Número Habitaciones:</label><br>
  		<input type="number" id="nroHabitaciones" name="nroHabitaciones" min=1><br><br>
  		
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
  		<input type="number" id="precioPorNoche" name="precioPorNoche" min="0.01" step="0.01"><br><br>
  		
  		<input type="submit" value="Ingresar">
  		<input type="button" value="Listado" onclick="window.location.href='ListadoDepartamento.jsp'">
	</form>
</body>
</html>