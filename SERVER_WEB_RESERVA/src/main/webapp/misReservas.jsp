<%@page import="modelo.Reserva"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Importar clases en JSP -->
<%@page import="java.util.List" %>
<%@page import="modelo.Departamento" %> 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Lista de Reservas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Lista de Reservas</h2>

        <!-- Formulario de búsqueda mejorado con card de Bootstrap -->
        <div class="card mb-4">
            <div class="card-header">
                <h5>Buscar Reserva</h5>
            </div>
            <div class="card-body">
                <form action="ReservaServlet" method="post">
                    <!-- Campo oculto que pasa la opción 'buscar' al servlet -->
                    <input type="hidden" name="opcion" value="buscarReservasCliente">
                    <div class="row justify-content-center">
                        <div class="col-md-6">
                            <div class="input-group">
                                <label for="IdBuscar" class="input-group-text">ID Departamento:</label>
                                <input type="number" id="IdBuscar" name="txtIdBuscar" class="form-control" placeholder="Ingrese el ID del departamento a buscar" min="1">
                            </div>
                        </div>
                        <div class="col-md-2">
                            <button type="submit" name="buscar" class="btn btn-primary w-100">Buscar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <hr>

        <%
        @SuppressWarnings("unchecked") // Ignorar advertencia de conversión explicita (es opcional)
        // Obtener la lista de reservas que se pasó desde el Servlet
        List<Reserva> listaReservas = (List<Reserva>) request.getAttribute("listaReservas");
        Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
        if (esBusqueda == null) esBusqueda = false; // Fallback por seguridad
        %>

        <!-- Tabla de resultados mejorada con Bootstrap -->
        <table class="table table-bordered table-hover table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID Solicitud</th>
                    <th>ID Departamento</th>
                    <th>Fecha inicio</th>
                    <th>Fecha fin</th>
                    <th>Método pago</th>
                    <th>Monto total</th>
                    <th>Estado reserva</th>
                </tr>
            </thead>
            <tbody>
            <%
            // Verificar si la lista de reservas no es null y no está vacía
            if(listaReservas != null && !listaReservas.isEmpty()) {
                // Recorrer la lista de reservas y mostrar cada una en una fila
                for(Reserva reserva : listaReservas) {
            %>
                <tr>
                    <td><%= reserva.getIdSolicitud() %></td>
                    <td><%= reserva.getIdDepartamento() %></td>
                    <td><%= reserva.getFechaInicioReserva() %></td>
                    <td><%= reserva.getFechaFinReserva() %></td>
                    <td><%= reserva.getMetodoPago() %></td>
                    <td><%= reserva.getMontoTotal() %></td>
                    <td><%= reserva.getEstadoReserva() %></td>
                </tr>
            <%       } 
            } else { %>
                <tr>
                    <td colspan="7" class="text-center">No se encontraron reservas</td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
