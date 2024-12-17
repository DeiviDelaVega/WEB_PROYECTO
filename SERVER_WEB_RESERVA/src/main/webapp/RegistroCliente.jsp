<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>REGISTRO CLIENTE</title>
    <!-- Importando Bootstrap para los estilos -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .form-container {
            max-width: 600px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-container label {
            font-weight: bold;
        }

        .form-container button {
            width: 100%;
            margin-top: 20px;
        }

        .form-container .message {
            text-align: center;
            margin-top: 20px;
            font-weight: bold;
        }
        
        .btn-secundary {
    color: white;
    background-color: red;
    border-color: red;
}
    </style>
</head>
<body>

<div class="form-container">
    <h2>Registrar Cliente</h2>
     
        <% String mensaje = request.getParameter("mensaje");
    if(mensaje != null) { %>
        <div class="message text-danger">
            <p><%= mensaje %></p>
        </div>
    <% } %>
     
    <form action="cliente" method="post">
        <input type="hidden" name="opcion" value="registrar">
        
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>

        <div class="mb-3">
            <label for="apellido" class="form-label">Apellido:</label>
            <input type="text" class="form-control" id="apellido" name="apellido" required>
        </div>

        <div class="mb-3">
            <label for="nro_documento" class="form-label">Nº Documento:</label>
            <input type="text" class="form-control" id="nro_documento" name="nro_documento" required>
        </div>

        <div class="mb-3">
            <label for="direccion" class="form-label">Direccion:</label>
            <input type="text" class="form-control" id="direccion" name="direccion" required>
        </div>

        <div class="mb-3">
            <label for="telefono" class="form-label">Telefono:</label>
            <input type="text" class="form-control" id="telefono" name="telefono" required>
        </div>

        <div class="mb-3">
            <label for="correo" class="form-label">Correo:</label>
            <input type="email" class="form-control" id="correo" name="correo" required>
        </div>

        <div class="mb-3">
            <label for="clave" class="form-label">Clave:</label>
            <input type="password" class="form-control" id="clave" name="clave" required>
        </div>
        
                   <button type="submit" class="btn btn-primary" >Registrar</button>
           
           <button class="btn btn-secundary" onclick="window.location.href='cliente?opcion=buscar'">Cancelar</button>
                 
       
          
    </form>

 
</div>

<!-- Importando Bootstrap JS (opcional para interactividad) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
