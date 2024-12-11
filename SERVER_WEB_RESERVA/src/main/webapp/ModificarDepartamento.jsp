<%@page import="modelo.Departamento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificacion de Departamento</title>
</head>
<body>
	<h2>Modificacion de Departamento</h2>
	<form action="departamento" method="post">
    	<!-- Campo oculto para el ID del departamento -->
    	<input type="hidden" id="idDepartamento" name="idDepartamento" value="${departamento.idDepartamento}">
		<!-- Campo oculto que pasa la opción 'guardar' al servlet -->
    	<input type="hidden" name="opcion" value="guardar">
    	
    	<label for="nombre">Nombre:</label><br>
    	<input type="text" id="nombre" name="nombre" value="${departamento.nombre}"><br><br>
    
    	<label for="capacidad">Capacidad:</label><br>
    	<input type="number" id="capacidad" name="capacidad" value="${departamento.capacidad}" min="1"><br><br>
    
    	<label for="nroHabitaciones">Número Habitaciones:</label><br>
    	<input type="number" id="nroHabitaciones" name="nroHabitaciones" value="${departamento.nroHabitaciones}" min="1"><br><br>
    
    	<label for="descripcion">Descripción:</label><br>
    	<input type="text" id="descripcion" name="descripcion" value="${departamento.descripcion}"><br><br>
    
    	<label for="serviciosIncluidos">Servicios Incluidos:</label><br>
    	<input type="text" id="serviciosIncluidos" name="serviciosIncluidos" value="${departamento.serviciosIncluidos}"><br><br>
    
    	<label for="disponibilidad">Disponibilidad:</label><br>
    	<input type="radio" id="Si" name="disponibilidad" value="Si" ${departamento.disponibilidad == 'Si' ? 'checked' : ''}>
    	<label for="Si">Disponible</label><br>
    	<input type="radio" id="No" name="disponibilidad" value="No" ${departamento.disponibilidad == 'No' ? 'checked' : ''}>
    	<label for="No">Indisponible</label><br><br>

   		<label for="precioPorNoche">Precio por Noche:</label><br> 
    	<input type="number" id="precioPorNoche" name="precioPorNoche" value="${departamento.precioPorNoche}" min="0.01" step="0.01"><br><br>
    	<input type="submit" value="Guardar" name="opcion" value="guardar">
    	<input type="button" value="Cancelar" onclick="window.location.href='ListadoDepartamento.jsp'">
	</form>
</body>
</html>