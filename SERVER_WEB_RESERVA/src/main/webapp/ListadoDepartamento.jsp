<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- Importar clases en JSP -->
<%@page import="java.util.List" %>
<%@page import="modelo.Departamento" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Departamentos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  	<h2>Lista de Departamentos</h2>
	<hr>
	<input type="button" value="Agregar departamento" onclick="window.location.href='RegistrarDepartamento.jsp'">
	<hr>
	<form action="buscarDepartamento" method="post">
		<label for="IdBuscar">ID:</label>
		<input type="number" id="IdBuscar" name="txtIdBuscar" placeholder="Ingrese el ID del departamento a buscar." min="1">
		<input type="submit" value="Buscar">
	</form>
	<hr>
<%
@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
// Obtener la lista de departamentos que se pasó desde el Servlet
List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDeDepartamentos");
// Verificar si la lista de departamentos: no es null y no está vacía
if(listaDepartamentos != null && !listaDepartamentos.isEmpty()) {
%>
	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Capacidad</th>
				<th>Numero de habitaciones</th>
				<th>Descripcion</th>
				<th>Servicios incluidos</th>
				<th>Disponibilidad</th>
				<th>Precio por noche</th>
			</tr>
		</thead>
		<tbody>
<%
	// Recorrer la lista de departamentos y mostrar cada uno en una fila
	for(Departamento departamento : listaDepartamentos) {
%>
			<tr>
				<td><%=departamento.getIdDepartamento()%></td>
				<td><%=departamento.getNombre()%></td>
				<td><%=departamento.getCapacidad()%></td>
				<td><%=departamento.getNroHabitaciones()%></td>
				<td><%=departamento.getDescripcion()%></td>
				<td><%=departamento.getServiciosIncluidos()%></td>
				<td><%=departamento.getDisponibilidad()%></td>
			</tr>
<%	} // Llave de cierre del bucle for%>
		</tbody>
	</table>
<%} // Llave de cierre de la estructura if%>
</body>
</html>