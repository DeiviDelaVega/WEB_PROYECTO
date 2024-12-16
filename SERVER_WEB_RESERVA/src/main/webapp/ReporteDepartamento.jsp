<%@page import="modelo.ReporteDepartamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departamentos mas Reservados</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
h1 {
	text-align: center;
}

.department-card {
	display: flex;
	flex-wrap: nowrap;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 20px;
	margin: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.department-card img {
	width: 200px;
	height: auto;
	border-radius: 8px;
	margin-right: 20px;
}

.department-details {
	flex-grow: 1;
}

.department-details h5 {
	font-size: 1.25rem;
	font-weight: bold;
}

.department-details p {
	font-size: 1rem;
	margin: 5px 0;
}

.price {
	font-size: 1.2rem;
	color: #007bff;
	margin-top: 10px;
}

.reserve-button {
	margin-top: 15px;
}

.search-bar {
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<div class="container">
		<h1>Departamentos mas Reservados</h1>
		<input type="hidden" name="opcion" value="listarReporteDepartamento">
		<div class="row">
			<%
			@SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
			// Obtener la lista de departamentos que se pasó desde el Servlet
			List<ReporteDepartamento> listaReporteDepartamento = (List<ReporteDepartamento>) request.getAttribute("listaDeReporte");
			Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
			if (esBusqueda == null)
				esBusqueda = false; // Fallback por seguridad
			%>

			<%
			if (listaReporteDepartamento != null && !listaReporteDepartamento.isEmpty()) {
			%>
			<%
			for (ReporteDepartamento reporteDepartamento : listaReporteDepartamento) {
			%>
			<div class="col-md-12">
				<div class="department-card">
					<div class="department-details">
						<h5><%=reporteDepartamento.getNombre()%></h5>
						<p>
							<strong>ID Departamento:</strong>
							<%=reporteDepartamento.getID_Departamento()%>
						</p>
						<p>
							<strong>Total Reservas:</strong>
							<%=reporteDepartamento.getTotal_Reservas()%>
						</p>
					</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			} else if (listaReporteDepartamento == null || listaReporteDepartamento.isEmpty()) {
			%>
			<div class="col-12">
				<div class="alert alert-warning text-center">No se encuentran Departamentos reservados</div>
			</div>
			<%
			}
			%>

		</div>
		<a href="inicioCliente.jsp">Regresar</a>
	</div>

</body>
</html>