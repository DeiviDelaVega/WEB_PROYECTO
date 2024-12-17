
<%@page import="java.util.List"%>
<%@page import="modelo.ReporteDepartamento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departamentos mas Reservados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
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

h1 {
	text-align: center;
}

.department-card {
	display: flex;
	flex-wrap: nowrap;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 20px;
	margin: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.department-card img {
	width: 200px;
	height: auto;
	border-radius: 8px;
	margin-right: 20px;
}

.department-details {
	flex-grow: 1;
}

.department-details h5 {
	font-size: 1.25rem;
	font-weight: bold;
}

.department-details p {
	font-size: 1rem;
	margin: 5px 0;
}

.price {
	font-size: 1.2rem;
	color: #007bff;
	margin-top: 10px;
}

.reserve-button {
	margin-top: 15px;
}

.search-bar {
	margin-bottom: 20px;
}
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
					<li class="nav-item"><a class="nav-link active" href="#">Reportes</a>
						<!-- Submenú -->
						<ul class="submenu">
							<li ><a class="submenu-link" href="cliente?opcion=listarReporteCliente">Clientes que mas reservan</a></li>
							<li ><a class="submenu-link" href="departamento?opcion=listarReporteDepartamento"> Departamentos mas reservados</a></li>
						</ul></li>
                        
					<li class="nav-item"><a class="nav-link" href="login.jsp">Salir</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

</head>

<body>
	<div class="container">
<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8 text-center">
				<h1 class="display-4">Departamentos mas reservados</h1>
			</div>
		</div>
	</div>
		<input type="hidden" name="opcion" value="listarReporteDepartamento">
		<div class="row">
			<%
			@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
			// Obtener la lista de departamentos que se pasó desde el Servlet
			List<ReporteDepartamento> listaReporteDepartamento = (List<ReporteDepartamento>) request.getAttribute("listaDeReporte");
			Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
			if (esBusqueda == null)
				esBusqueda = false; // Fallback por seguridad
			%>

			<%
			if (listaReporteDepartamento != null && !listaReporteDepartamento.isEmpty()) {
			%>
			<%
			for (ReporteDepartamento reporteDepartamento : listaReporteDepartamento) {
			%>
			<div class="col-md-12">
				<div class="department-card">
					<div class="department-details">
						<h5><%=reporteDepartamento.getNombre()%></h5>
						<p>
							<strong>ID Departamento:</strong>
							<%=reporteDepartamento.getID_Departamento()%>
						</p>
						<p>
							<strong>Total Reservas:</strong>
							<%=reporteDepartamento.getTotal_Reservas()%>
						</p>
					</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			} else if (listaReporteDepartamento == null || listaReporteDepartamento.isEmpty()) {
			%>
			<div class="col-12">
				<div class="alert alert-warning text-center">No se encuentran Departamentos reservados</div>
			</div>
			<%
			}
			%>
			</div>
			</div>
</body>
</html>