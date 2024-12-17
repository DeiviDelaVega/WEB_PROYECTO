<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de Departamento</title>
    <!-- Importar Bootstrap para el estilo -->
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
            text-align: center;
            margin-bottom: 20px;
        }
        .details-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
            font-size: 1.1rem;
        }
        .detail-row label {
            font-weight: bold;
        }
        .detail-row div {
            font-weight: normal;
        }
        .btn-custom {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="text-center">Detalle de Departamento</h2>

    <div class="details-container">
        <div class="detail-row">
            <label>ID:</label>
            <div>${ eDepartamento.getIdDepartamento() }</div>
        </div>
        <div class="detail-row">
            <label>Nombre:</label>
            <div>${ eDepartamento.getNombre() }</div>
        </div>
        <div class="detail-row">
            <label>Capacidad:</label>
            <div>${ eDepartamento.getCapacidad() }</div>
        </div>
        <div class="detail-row">
            <label>Numero de habitaciones:</label>
            <div>${ eDepartamento.getNroHabitaciones() }</div>
        </div>
        <div class="detail-row">
            <label>Descripción:</label>
            <div>${ eDepartamento.getDescripcion() }</div>
        </div>
        <div class="detail-row">
            <label>Servicios incluidos:</label>
            <div>${ eDepartamento.getServiciosIncluidos() }</div>
        </div>
        <div class="detail-row">
            <label>Disponibilidad:</label>
            <div>${ eDepartamento.getDisponibilidad() }</div>
        </div>
        <div class="detail-row">
            <label>Precio por noche:</label>
            <div>${ eDepartamento.getPrecioPorNoche() }</div>
        </div>

        <!-- Botón para volver al listado -->
        <div class="text-center btn-custom">
            <a href="departamento?opcion=buscarDepartamento" class="btn btn-primary">Volver</a>
        </div>
    </div>
</div>

<!-- Agregar el JS de Bootstrap (opcional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
