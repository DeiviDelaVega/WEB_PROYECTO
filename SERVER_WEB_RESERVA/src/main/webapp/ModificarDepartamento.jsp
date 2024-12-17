<%@page import="modelo.Departamento"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Modificación de Departamento</title>
<!-- Importar Bootstrap para el diseño -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
		<h2 class="text-center mb-4">Modificación de Departamento</h2>

		<div class="form-container">
			<form action="departamento" method="post">
				<!-- Campo oculto para el ID del departamento -->
				<input type="hidden" id="idDepartamento" name="idDepartamento"
					value="${departamento.idDepartamento}">
				<!-- Campo oculto que pasa la opción 'guardar' al servlet -->
				<input type="hidden" name="opcion" value="guardar">

				<div class="form-group">
					<label for="nombre">Nombre:</label> <input type="text" id="nombre"
						name="nombre" class="form-control" value="${departamento.nombre}"
						required>
				</div>

				<div class="form-group">
					<label for="capacidad">Capacidad:</label> <input type="number"
						id="capacidad" name="capacidad" class="form-control"
						value="${departamento.capacidad}" min="1" required>
				</div>

				<div class="form-group">
					<label for="nroHabitaciones">Número Habitaciones:</label> <input
						type="number" id="nroHabitaciones" name="nroHabitaciones"
						class="form-control" value="${departamento.nroHabitaciones}"
						min="1" required>
				</div>

				<div class="form-group">
					<label for="descripcion">Descripción:</label> <input type="text"
						id="descripcion" name="descripcion" class="form-control"
						value="${departamento.descripcion}" required>
				</div>

				<div class="form-group">
					<label for="serviciosIncluidos">Servicios Incluidos:</label> <input
						type="text" id="serviciosIncluidos" name="serviciosIncluidos"
						class="form-control" value="${departamento.serviciosIncluidos}"
						required>
				</div>

				<div class="form-group">
					<label>Disponibilidad:</label><br> <input type="radio" id="Si"
						name="disponibilidad" value="Si"
						${departamento.disponibilidad == 'Si' ? 'checked' : ''}> <label
						for="Si">Disponible</label><br> <input type="radio" id="No"
						name="disponibilidad" value="No"
						${departamento.disponibilidad == 'No' ? 'checked' : ''}> <label
						for="No">Indisponible</label><br>
				</div>

				<div class="form-group">
					<label for="precioPorNoche">Precio por Noche:</label> <input
						type="number" id="precioPorNoche" name="precioPorNoche"
						class="form-control" value="${departamento.precioPorNoche}"
						min="0.01" step="0.01" required>
				</div>

				<div class="d-flex justify-content-between">
					<button onclick="window.location='departamento?opcion=buscarDepartamento'"
						type="submit" class="btn btn-success botoncito">Guardar
						Cambios</button>
					<input type="button" class="btn btn-secondary" value="Cancelar"
						onclick="window.location.href='departamento?opcion=buscarDepartamento'">
				</div>
			</form>
		</div>
	</div>

	<!-- Agregar el JS de Bootstrap (opcional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
