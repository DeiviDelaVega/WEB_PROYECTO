<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro de Departamentos</title>
    <!-- Importar Bootstrap para el diseño -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f7f6;
        }
        .container {
            max-width: 800px;
            margin-top: 50px;
        }
        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-control {
            margin-bottom: 15px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-custom {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center mb-4">Registro de Departamentos</h2>

    <div class="form-container">
        <form action="departamento" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="opcion" value="AgregarDepartamento">

            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="capacidad">Capacidad:</label>
                <input type="number" id="capacidad" name="capacidad" class="form-control" min="1" required>
            </div>

            <div class="form-group">
                <label for="nroHabitaciones">Número Habitaciones:</label>
                <input type="number" id="nroHabitaciones" name="nroHabitaciones" class="form-control" min="1" required>
            </div>

            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <input type="text" id="descripcion" name="descripcion" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="serviciosIncluidos">Servicios Incluidos:</label>
                <input type="text" id="serviciosIncluidos" name="serviciosIncluidos" class="form-control" required>
            </div>

            <div class="form-group">
                <label>Disponibilidad:</label><br>
                <input type="radio" id="Si" name="disponibilidad" value="Si">
                <label for="Si">Disponible</label><br>
                <input type="radio" id="No" name="disponibilidad" value="No">
                <label for="No">Indisponible</label><br>
            </div>

            <div class="form-group">
                <label for="precioPorNoche">Precio por Noche:</label>
                <input type="number" id="precioPorNoche" name="precioPorNoche" class="form-control" min="0.01" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="imagenDepartamento">Imagen:</label>
                <input type="file" id="imagenDepartamento" name="imagenDepartamento" class="form-control" required>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-success">Registrar</button>
                <input type="button" class="btn btn-secondary" value="Volver" onclick="window.location.href='departamento?opcion=buscarDepartamento'">
            </div>
        </form>

        <% if(request.getAttribute("mensaje") != null) { 
            String mensaje = (String)request.getAttribute("mensaje");
        %>
            <div class="alert alert-info mt-3">
                <p><%= mensaje %></p>
            </div>
        <% } %>
    </div>
</div>

<!-- Agregar el JS de Bootstrap (opcional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
