<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
    <meta charset="UTF-8"> 
    <title>Detalle Cliente</title> 

    <!-- Estilos CSS -->
    <style>
        /* General styles */
        
        .botoncito{
        margin-top: 1em;
        }
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 30px;
        }

        /* Container and Form styles */
        .container {
            width: 40%;
            margin: 0 auto;
            padding: 20px;
        }

        .form-container {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-container input[type="button"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }

        .form-container input[type="button"]:hover {
            background-color: #0056b3;
        }

        /* Details container */
        .details-container {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        .detail-row {
            display: flex;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #ddd;
        }

        .detail-row:last-child {
            border-bottom: none;
        }

        .detail-row label {
            font-weight: bold;
            color: #333;
        }

        .detail-row div {
            color: #555;
            font-size: 16px;
        }
        
    </style>
</head> 
<body> 

    <h2>Detalle Cliente</h2> 
    
    <div class="container">
        
        <!-- Cliente Details -->
        <div class="details-container">
            <div class="detail-row">
                <label>ID:</label>
                <div>${ eCliente.getId_Cliente() }</div>
            </div>
            <div class="detail-row">
                <label>Nombre:</label>
                <div>${ eCliente.getNombre() }</div>
            </div>
            <div class="detail-row">
                <label>Apellido:</label>
                <div>${ eCliente.getApellido() }</div>
            </div>
            <div class="detail-row">
                <label>Nº Documento:</label>
                <div>${ eCliente.getNro_Documento() }</div>
            </div>
            <div class="detail-row">
                <label>Dirección:</label>
                <div>${ eCliente.getDireccion() }</div>
            </div>
            <div class="detail-row">
                <label>Telefono:</label>
                <div>${ eCliente.getTelefono() }</div>
            </div>
            <div class="detail-row">
                <label>Correo:</label>
                <div>${ eCliente.getCorreo() }</div>
            </div>
            <div class="detail-row">
                <label>Clave:</label>
                <div>${ eCliente.getClave() }</div>
            </div>
        </div>
         <!-- Button to navigate to Listado Cliente -->
        <div class="form-container">
            <form action="cliente" method="post">
                <input class="botoncito" type="button" value="Volver" onclick="window.location.href='cliente?opcion=buscar'">
            </form>
        </div>
    </div>

</body> 
</html>
