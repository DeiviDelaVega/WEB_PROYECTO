<%@page import="modelo.Reserva"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- Importar clases en JSP -->
<%@page import="java.util.List" %>
<%@page import="modelo.Departamento" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Reservas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  	<h2>Lista de Reservas</h2>

	<form action="ReservaServlet" method="post">
		<!-- Campo oculto que pasa la opción 'buscar' al servlet -->
        <input type="hidden" name="opcion" value="buscarReservas">
		<div class="d-flex justify-content-center">
			<label for="IdBuscar">ID:</label>
			<input type="number" id="IdBuscar" name="txtIdBuscar" class="w-50 form-control" placeholder="Ingrese el ID del departamento a buscar" min="1">
			<input type='submit' name='buscar'/>
		</div>
	</form>
	<hr>
<%
@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
// Obtener la lista de departamentos que se pasó desde el Servlet
List<Reserva> listaReservas = (List<Reserva>) request.getAttribute("listaReservas");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>
	<table class = "table table-bordered">
		<thead>
			<tr>
				<th>ID Solicitud</th>
				<th>ID Cliente</th>
				<th>ID Departamento</th>
				<th>Fecha inicio</th>
				<th>Fecha fin</th>
				<th>Metodo pago</th>
				<th>Monto total</th>
				<th>Estado reserva</th>
				<th>Accion</th>
			</tr>
		</thead>
		<tbody>
<%
	//Verificar si la lista de departamentos: no es null y no está vacía
	if(listaReservas != null && !listaReservas.isEmpty()) {
	// Recorrer la lista de departamentos y mostrar cada uno en una fila
		for(Reserva reserva : listaReservas) {
%>
			<tr>
				<td><%=reserva.getIdSolicitud()%></td>
				<td><%=reserva.getIdCliente()%></td>
				<td><%=reserva.getIdDepartamento()%></td>
				<td><%=reserva.getFechaInicioReserva()%></td>
				<td><%=reserva.getFechaFinReserva()%></td>
				<td><%=reserva.getMetodoPago()%></td>
				<td><%=reserva.getMontoTotal()%></td>
				<td><%=reserva.getEstadoReserva()%></td>
				<td>
		           <a href="ReservaServlet?opcion=editarEstado&id=<%=reserva.getIdSolicitud()%>" class="btn btn-primary">Modificar</a>
				
				</td>
				
			</tr>
<%		} // Llave de cierre del bucle for%>
<%	} // Llave de cierre de la estructura if
	else if (esBusqueda) {
%>
		<tr>
			<!-- 
				colspan para mostrar un mensaje que abarque toda la fila. 
				El numero 6 porque son seis columnas las que hay en la tabla.
			-->
         	<td colspan="6" class="text-center text-danger">No existe el departamento con el ID ingresado</td>
 		</tr>
<%
  	} // Llave de cierre de else if
	else if (listaReservas != null && listaReservas.isEmpty()) {
%>
		<tr>
            <td colspan="6" class="text-center text-warning">No se encuentran departamentos registrados</td>
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