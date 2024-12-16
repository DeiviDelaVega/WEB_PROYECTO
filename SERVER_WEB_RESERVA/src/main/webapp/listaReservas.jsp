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
	<style>
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
<!-- Barra de navegación -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="inicioEmpleado.jsp"><img alt=""
				src="images/poloMonterrico.png" class="imagenlogo"></a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active"
						href="inicoEmpleado.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link"
						href="listadoCliente.jsp">Mant. cliente</a></li>
					<li class="nav-item"><a class="nav-link"
						href="ListadoDepartamento.jsp">Mant. Departamento</a></li>
					<li class="nav-item"><a class="nav-link"
						href="listaReservas.jsp">Mant. de Reservas</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Reportes</a>
						<!-- Submenú -->
						<ul class="submenu">
							<li><a class="submenu-link" href="cliente?opcion=listarReporteCliente">Clientes que mas reservan</a></li>
							<li><a class="submenu-link" href="#">Reporte 2</a></li>
						</ul></li>
                        
					<li class="nav-item"><a class="nav-link" href="login.jsp">Salir</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
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