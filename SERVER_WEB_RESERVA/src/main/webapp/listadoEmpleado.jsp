<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="modelo.Empleado" %> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<hr>
	<input type="button" value="Agregar empleado" onclick="window.location.href='RegistroEmpleado.jsp'">
	<hr>
	<form action="buscarEmpleado" method="post">
		<div class="d-flex justify-content-center">
			<label for="IdBuscar">ID:</label>
			<input type="number" id="IdBuscar" name="txtIdBuscar" class="w-50 form-control" placeholder="Ingrese el ID del empleado a buscar" min="1">
			<input type="submit" value="Buscar">
		</div>
	</form>
	<hr>
<%
@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
// Obtener la lista de departamentos que se pasó desde el Servlet
List<Empleado> listaEmpleados = (List<Empleado>) request.getAttribute("listadoEmpleados");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>
	<table class = "table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Asignacion</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Numero de documento</th>
				<th>Telefono</th>
				<th>Correo electronico</th>
				<th>Fecha de contrato</th>
				
			</tr>
		</thead>
		<tbody>
<%
	//Verificar si la lista de departamentos: no es null y no está vacía
	if(listaEmpleados != null && !listaEmpleados.isEmpty()) {
	// Recorrer la lista de departamentos y mostrar cada uno en una fila
		for(Empleado empleado : listaEmpleados) {
%>
			<tr>
				<td><%=empleado.getId_Empleado()%></td>
				<td><%=empleado.getId_Asignacion()%></td>
				<td><%=empleado.getNombre()%></td>
				<td><%=empleado.getApellido()%></td>
				<td><%=empleado.getNro_Documento()%></td>
				<td><%=empleado.getTelefono()%></td>
				<td><%=empleado.getCorreo_Electronico()%></td>
				<td><%=empleado.getFecha_Contratación()%></td>
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
	else if (listaEmpleados != null && listaEmpleados.isEmpty()) {
%>
		<tr>
            <td colspan="8" class="text-center text-warning">No se encuentran empleado registrados</td>
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