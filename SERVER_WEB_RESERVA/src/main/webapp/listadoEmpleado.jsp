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
<style>
	.botoncito{
	margin-top: 1em;
	margin-left: 1em;
	}
.imagenlogo {
	width: 100px;
	height: auto;
}
/* Submenú oculto por defecto */
.submenu {
    display: none;
    position: absolute; /* Asegura que se despliegue sobre otros elementos */
    list-style: none;
    background-color: #f8f9fa;
    padding: 0;
    margin: 0;
    border-radius: 5px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

/* Mostrar el submenú cuando se pasa el cursor sobre el elemento principal */
.nav-item:hover .submenu {
    display: block;
}

/* Estilos para los enlaces del submenú */
.submenu-link {
    display: block;
    padding: 10px;
    text-decoration: none;
    color: #000;
}

.submenu-link:hover {
    background-color: #ddd;
}

</style>

<body>
			<% HttpSession sesion= request.getSession(); 
				String rolUsuario = (String)sesion.getAttribute("rol");	%>	
<!-- Barra de navegación -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
						<a class="navbar-brand" href="<%= "inicio" + rolUsuario.substring(0, 1).toUpperCase() + rolUsuario.substring(1) + ".jsp" %>">
    <img alt="" src="images/poloMonterrico.png" class="imagenlogo">
</a>



			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
				   <%
						if(rolUsuario.equals("empleado")){
						%>
					<li class="nav-item"><a class="nav-link "
						href="inicioEmpleado.jsp">Inicio</a></li>
						  <%} %>
			      <%
						if(rolUsuario.equals("admin")){
						%>
						<li class="nav-item"><a class="nav-link "
						href="inicioAdmin.jsp">Inicio</a></li>
						<li class="nav-item"><a class="nav-link active"
						href="Empleado?opcion=buscar">Mant. Empleado</a></li>
                     <%} %>
					<li class="nav-item"><a class="nav-link"
						href="cliente?opcion=buscar">Mant. cliente</a></li>
					<li class="nav-item"><a class="nav-link"
						href="departamento?opcion=buscarDepartamento">Mant. Departamento</a></li>
					<li class="nav-item"><a class="nav-link"
						href="ReservaServlet?opcion=buscarReservas">Mant. de Reservas</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Reportes</a>
						<!-- Submenú -->
						<ul class="submenu">
							<li><a class="submenu-link" href="cliente?opcion=listarReporteCliente">Clientes que mas reservan</a></li>
							<li><a class="submenu-link" href="departamento?opcion=listarReporteDepartamento">Departmentos mas reservados</a></li>
						</ul></li>
                        
					<li class="nav-item"><a class="nav-link" href="Login?opcion=cerrarSesion">Salir</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	
	<input class="mt-4" type="button" value="Agregar empleado" onclick="window.location.href='RegistroEmpleado.jsp'">
	<hr>
	<form action="Empleado" method="post">
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
List<Empleado> listaEmpleados = (List<Empleado>) request.getAttribute("listadoEmpleados");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>  <div class="container">
	<table class = "table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
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
				<td><%=empleado.getNombre()%></td>
				<td><%=empleado.getApellido()%></td>
				<td><%=empleado.getNro_Documento()%></td>
				<td><%=empleado.getTelefono()%></td>
				<td><%=empleado.getCorreo_Electronico()%></td>
				<td><%=empleado.getFecha_Contratacion()%></td>
					<td> <a href="Empleado?opcion=detalle&idEmpleado=<%=empleado.getId_Empleado()%>" class="btn btn-success">Ver detalle</a> </td>
				<td>
        			<a href="Empleado?opcion=eliminar&id=<%=empleado.getId_Empleado()%>&correo=<%=empleado.getCorreo_Electronico()%>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este Empleado?');">Eliminar</a>
    				<a href="Empleado?opcion=modificar&id=<%=empleado.getId_Empleado()%>" class="btn btn-primary">Modificar</a>
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
	</div>
</body>
</html>