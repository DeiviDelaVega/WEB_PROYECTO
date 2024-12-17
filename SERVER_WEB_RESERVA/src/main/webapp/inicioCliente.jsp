<%@page import="modelo.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio - Mi Página Web</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<style>
.imagenlogo {

width: 100px;
height: auto;
}
</style>
<body>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="inicioCliente.jsp"><img alt="" src="images/poloMonterrico.png" class="imagenlogo"></a>
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="home.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ReservaHabitaciones.jsp" onclick="document.getElementById('listadoForm').submit(); return false;">Reserva Habitaciones</a>
                    </li>
                    <li class="nav-item">
                          <a class="nav-link" href="ReservaServlet?opcion=buscarReservasCliente">Tus reservas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Salir</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Formulario oculto -->
    <form id="listadoForm" action="InicioCliente" method="post" style="display: none;">
        <input type="submit" value="Reserva Habitaciones">
    </form>
    
    
<form id="listadoMisReservas" action="ReservaMostrarCliente" method="post" style="display: none;">
        <input type="submit" value="MisReservas">
    </form>

    <!-- Contenido principal -->
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1 class="display-4">¡Bienvenido, Cliente!</h1>
                <p class="lead">Explora nuestras habitaciones y haz tus reservas de manera sencilla y rápida.</p>
            </div>
        </div>
    </div>




    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
