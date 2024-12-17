<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .form-container {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container input[type="button"] {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            max-width: 200px;
        }
        .form-container input[type="button"]:hover {
            background-color: #45a049;
        }
        .details-container {
            margin-top: 20px;
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 4px;
        }
        .detail-row label {
            font-weight: bold;
            color: #333;
            width: 30%;
        }
        .detail-row div {
            font-size: 16px;
            color: #555;
            width: 65%;
        }
        .detail-row:nth-child(even) {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Detalle Empleado</h2>

    <!-- Detalles del empleado -->
    <div class="details-container">
        <div class="detail-row">
            <label>ID:</label>
            <div>${ eEmpleado.getId_Empleado() }</div>
        </div>
        <div class="detail-row">
            <label>Nombre:</label>
            <div>${ eEmpleado.getNombre() }</div>
        </div>
        <div class="detail-row">
            <label>Apellido:</label>
            <div>${ eEmpleado.getApellido() }</div>
        </div>
        <div class="detail-row">
            <label>Nº Documento:</label>
            <div>${ eEmpleado.getNro_Documento() }</div>
        </div>
        <div class="detail-row">
            <label>Teléfono:</label>
            <div>${ eEmpleado.getTelefono() }</div>
        </div>
        <div class="detail-row">
            <label>Fecha Contratación:</label>
            <div>${ eEmpleado.getFecha_Contratacion() }</div>
        </div>
        <div class="detail-row">
            <label>Correo:</label>
            <div>${ eEmpleado.getCorreo_Electronico() }</div>
        </div>
        <div class="detail-row">
            <label>Clave:</label>
            <div>${ eEmpleado.getClave() }</div>
        </div>
    </div>
      <!-- Botón para regresar al listado -->
    <div class="form-container">
        <form action="Empleado" method="post">
            <input type="button" value="Volver" onclick="window.location.href='Empleado?opcion=buscar'">
        </form>
    </div>
</div>

</body>
</html>
