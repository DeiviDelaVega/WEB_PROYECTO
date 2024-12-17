<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Empleado</title>
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
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            color: #555;
            width: 100%;
            box-sizing: border-box;
        }
        input[type="submit"], input[type="button"] {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 48%;
            margin-top: 10px;
            align-self: flex-start;
        }
        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #45a049;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
        }
        .button-group input[type="button"] {
            width: 48%;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Modificar Empleado</h2>

    <form action="Empleado" method="post">
        <!-- Campo oculto para el ID del empleado -->
        <input type="hidden" id="idEmpleado" name="idEmpleado" value="${empleado.getId_Empleado()}">
        <!-- Campo oculto para pasar la opción 'guardar' al servlet -->
        <input type="hidden" name="opcion" value="guardar">

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${empleado.getNombre()}">

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" value="${empleado.getApellido()}">

        <label for="nro_documento">Nº Documento:</label>
        <input type="text" id="nro_documento" name="nro_documento" value="${empleado.getNro_Documento()}">

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" value="${empleado.getTelefono()}">

        <label for="fechaContrato">Fecha de contrato:</label>
        <input type="text" id="fechaContrato" name="fechaContrato" value="${empleado.getFecha_Contratacion()}">

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" value="${empleado.getCorreo_Electronico()}">

        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" value="${empleado.getClave()}">

        <div class="button-group">
        <button onclick="window.location='Empleado?opcion=buscar'"
						type="submit" class="btn btn-success botoncito">Guardar
						Cambios</button>
            <input type="button" value="Cancelar" onclick="window.location.href='Empleado?opcion=buscar'">
        </div>
    </form>
</div>

</body>
</html>
