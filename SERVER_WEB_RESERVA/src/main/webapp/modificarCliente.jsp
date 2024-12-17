<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificación Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Estilos CSS -->
<style>
/* General styles */
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

/* Container for the form */
.container {
	width: 50%; /* Reducido el tamaño */
	margin: 0 auto;
	padding: 20px; /* Menos espacio para hacerlo más compacto */
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

form {
	display: flex;
	flex-direction: column;
	gap: 15px; /* Reducido el espacio entre los campos */
}

label {
	font-weight: bold;
	color: #333;
}

input[type="text"], input[type="email"], input[type="password"] {
	padding: 8px; /* Menos padding */
	font-size: 14px;
	border-radius: 5px;
	border: 1px solid #ccc;
	width: 100%;
	box-sizing: border-box;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus
	{
	border-color: #007bff;
	outline: none;
}

input[type="submit"] {
	background-color: #28a745;
	color: white;
	border: none;
	padding: 10px;
	font-size: 14px; /* Botón más pequeño */
	cursor: pointer;
	border-radius: 5px;
}

input[type="submit"]:hover {
	background-color: #218838;
}

input[type="button"] {
	background-color: #6c757d;
	color: white;
	border: none;
	padding: 10px;
	font-size: 14px; /* Botón más pequeño */
	cursor: pointer;
	border-radius: 5px;
}

input[type="button"]:hover {
	background-color: #5a6268;
}

/* Spacing for form elements */
.form-group {
	margin-bottom: 15px; /* Reducido el espacio entre los campos */
}

.form-group input {
	width: 100%;
}

/* Espacio adicional entre botones */
.form-group input[type="submit"], .form-group input[type="button"] {
	margin-top: 10px;
}
    .botoncito{
    width: 100%;
    }
</style>
</head>
<body>

	<h2>Modificación Empleado</h2>

	<div class="container">
		<form action="cliente" method="post">
			<!-- Campo oculto para el ID del cliente -->
			<input type="hidden" id="idCliente" name="idCliente"
				value="${cliente.getId_Cliente()}">
			<!-- Campo oculto para pasar la opción 'guardar' al servlet -->
			<input type="hidden" name="opcion" value="guardar">

			<!-- Nombre -->
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text" id="nombre"
					name="nombre" value="${cliente.getNombre()}">
			</div>

			<!-- Apellido -->
			<div class="form-group">
				<label for="apellido">Apellido:</label> <input type="text"
					id="apellido" name="apellido" value="${cliente.getApellido()}">
			</div>

			<!-- Nº Documento -->
			<div class="form-group">
				<label for="nro_documento">Nº Documento:</label> <input type="text"
					id="nro_documento" name="nro_documento"
					value="${cliente.getNro_Documento()}">
			</div>

			<!-- Teléfono -->
			<div class="form-group">
				<label for="telefono">Teléfono:</label> <input type="text"
					id="telefono" name="telefono" value="${cliente.getTelefono()}">
			</div>

			<!-- Dirección -->
			<div class="form-group">
				<label for="direccion">Dirección:</label> <input type="text"
					id="direccion" name="direccion" value="${cliente.getDireccion()}">
			</div>

			<!-- Correo -->
			<div class="form-group">
				<label for="correo">Correo:</label> <input type="email" id="correo"
					name="correo" value="${cliente.getCorreo()}">
			</div>

			<!-- Clave -->
			<div class="form-group">
				<label for="clave">Clave:</label> <input type="password" id="clave"
					name="clave" value="${cliente.getClave()}">
			</div>

			<!-- Botones de acción -->
			<div class="form-group">
				<button  onclick="window.location='cliente?opcion=buscar'" type="submit" class="btn btn-success botoncito">
						Guardar Cambios
				</button>
				<input type="button" value="Cancelar"
					onclick="window.location.href='cliente?opcion=buscar'">
			</div>
		</form>
	</div>

</body>
</html>
