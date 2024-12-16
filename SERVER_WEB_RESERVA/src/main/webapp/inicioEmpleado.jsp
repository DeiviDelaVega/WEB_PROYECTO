<%@page import="modelo.Departamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
	
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

	<!-- Formulario oculto -->
	<form id="listadoForm" action="InicioCliente" method="post"
		style="display: none;">
		<input type="submit" value="Reserva Habitaciones">
	</form>


	<form id="listadoMisReservas" action="ReservaMostrarCliente"
		method="post" style="display: none;">
		<input type="submit" value="MisReservas">
	</form>

	<!-- Contenido principal -->
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8 text-center">
				<h1 class="display-4">¡Bienvenido, Empleado!</h1>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



</body>
</html>