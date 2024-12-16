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
  	<h2>Lista de Departamentos</h2>
	<hr>
	<input type="button" value="Agregar departamento" onclick="window.location.href='RegistrarDepartamento.jsp'">
	<hr>
	<form action="departamento" method="post">
		<!-- Campo oculto que pasa la opción 'buscar' al servlet -->
        <input type="hidden" name="opcion" value="buscarDepartamento">
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
List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDeDepartamentos");
Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
%>
	<table class = "table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Disponibilidad</th>
				<th>Precio por noche</th>
				<th>Imagen</th>
				<th>Accion</th>
				<th>Mantenimiento</th>
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
				<td><%=departamento.getDisponibilidad()%></td>
				<td><%=departamento.getPrecioPorNoche()%></td>
				<td>
                   <img src="<%= departamento.getImagenDepartamento() %>" alt="Imagen Departamento" style="width: 100px; height: auto;" />
               </td>
				<td> <a href="departamento?opcion=detalle&idDepartamento=<%=departamento.getIdDepartamento()%>" class="btn btn-success">Ver detalle</a> </td>
				<td>
        			<a href="departamento?opcion=eliminar&id=<%=departamento.getIdDepartamento()%>" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este departamento?');">Eliminar</a>
    				<a href="departamento?opcion=modificar&id=<%=departamento.getIdDepartamento()%>" class="btn btn-primary">Modificar</a>
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
	else if (listaDepartamentos != null && listaDepartamentos.isEmpty()) {
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