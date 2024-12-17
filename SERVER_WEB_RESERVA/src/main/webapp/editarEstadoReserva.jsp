<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Estado de Reserva</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
	<style type="text/css">
	.botoncito{
	text-decoration: none;
	color: white;
	
	}
   .botoncito:hover{
   color: white;
   }
   
   h2{
   text-align: center;
   }
	 
	</style>
</head>
<body>
	<h2>Modificar Estado de Reserva</h2>

	<form action="ReservaServlet" method="post" class="w-50 mx-auto">
		<!-- Campo oculto para pasar la opción -->
		<input type="hidden" name="opcion" value="actualizarEstado">
		<!-- Campo oculto para pasar el ID de la reserva -->
		<input type="hidden" name="idReserva"
			value="<%=request.getParameter("id")%>">

		<div class="mb-3">
			<label for="estadoReserva" class="form-label">Seleccione el
				nuevo estado:</label> <select id="estadoReserva" name="estadoReserva"
				class="form-select" required>
				<option value="Solicitado">Solicitado</option>
				<option value="Aprobado">Aprobado</option>
				<option value="Cancelado">Cancelado</option>
				<option value="Finalizado">Finalizado</option>
			</select>
		</div>

		<div class="text-center">
			<button type="submit" class="btn btn-success">
				<a class="botoncito" href="ReservaServlet?opcion=buscarReservas">Guardar Cambios</a>
			</button>
			<a href="ReservaServlet?opcion=buscarReservas"
				class="btn btn-secondary">Cancelar</a>
		</div>
	</form>
</body>
</html>
