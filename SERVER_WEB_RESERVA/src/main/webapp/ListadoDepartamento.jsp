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
		<div class="d-flex justify-content-center">
			<label for="IdBuscar">ID:</label>
			<input type="number" id="IdBuscar" name="txtIdBuscar" class="w-50 form-control" placeholder="Ingrese el ID del departamento a buscar" min="1">
			<input type="submit" value="Buscar">
		</div>
	</form>
	<hr>
<%
@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
// Obtener la lista de departamentos que se pasó desde el Servlet
List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDeDepartamentos");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>
	<table class = "table table-bordered">
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
	//Verificar si la lista de departamentos: no es null y no está vacía
	if(listaDepartamentos != null && !listaDepartamentos.isEmpty()) {
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
				<td><%=departamento.getPrecioPorNoche()%></td>
			</tr>
<%		} // Llave de cierre del bucle for%>
<%	} // Llave de cierre de la estructura if
	else if (esBusqueda) {
%>
		<tr>
			<!-- 
				colspan para mostrar un mensaje que abarque toda la fila. 
				El numero 8 porque son ocho columnas las que hay en la tabla.
			-->
         	<td colspan="8" class="text-center text-danger">No existe el departamento con el ID ingresado</td>
 		</tr>
<%
  	} // Llave de cierre de else if
	else if (listaDepartamentos != null && listaDepartamentos.isEmpty()) {
%>
		<tr>
            <td colspan="8" class="text-center text-warning">No se encuentran departamentos registrados</td>
        </tr>
<%
    } // Llave de cierre de else if
	else {
%>

<%
    } // Llave de cierre de else
%>
		</tbody>
	</table>
</body>
</html>