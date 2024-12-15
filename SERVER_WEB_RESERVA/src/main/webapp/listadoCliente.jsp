<%@page import="modelo.Cliente"%>
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
	<input type="button" value="Agregar Cliente" onclick="window.location.href='RegistroCliente.jsp'">
	<hr>
	<form action="cliente" method="post">
	<input type="hidden" name="opcion" value="buscar">
	
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
List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>
	<table class = "table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Numero de documento</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Correo</th>
				
			</tr>
		</thead>
		<tbody>
<%
	//Verificar si la lista de departamentos: no es null y no está vacía
	if(listaClientes != null && !listaClientes.isEmpty()) {
	// Recorrer la lista de departamentos y mostrar cada uno en una fila
		for(Cliente cliente : listaClientes) {
%>
			<tr>
				<td><%=cliente.getId_Cliente()%></td>
				<td><%=cliente.getNombre()%></td>
				<td><%=cliente.getApellido()%></td>
				<td><%=cliente.getNro_Documento()%></td>
				<td><%=cliente.getDireccion()%></td>
				<td><%=cliente.getTelefono()%></td>
				<td><%=cliente.getCorreo()%></td>
					<td> <a href="cliente?opcion=detalle&idCliente=<%=cliente.getId_Cliente()%>" class="btn btn-success">Ver detalle</a> </td>
				<td>
        			<a href="cliente?opcion=eliminar&id=<%=cliente.getId_Cliente()%>&correo=<%=cliente.getCorreo()%>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este Empleado?');">Eliminar</a>
    				<a href="cliente?opcion=modificar&id=<%=cliente.getId_Cliente()%>" class="btn btn-primary">Modificar</a>
    			</td>	
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
	else if (listaClientes != null && listaClientes.isEmpty()) {
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