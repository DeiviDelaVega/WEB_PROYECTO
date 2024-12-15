<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Departamento" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Departamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
        <h2 class="my-4">Lista de Departamentos</h2>
        <hr>

        <!-- Botón para agregar un nuevo departamento -->
        <input type="button" value="Agregar departamento" class="btn btn-primary" onclick="window.location.href='RegistrarDepartamento.jsp'">
        <hr>

        <!-- Formulario de búsqueda -->
        <form action="ReservaDepartamento" method="post" class="search-bar">
            <div class="d-flex justify-content-center">
                <label for="IdBuscar">ID:</label>
                <input type="number" id="IdBuscar" name="txtIdBuscar" class="w-50 form-control" placeholder="Ingrese el ID del departamento a buscar" min="1">
                <input type="submit" value="Buscar" class="btn btn-secondary">
            </div>
        </form>
        <hr>

        <div class="row">
            <% 
            @SuppressWarnings("unchecked") 
            List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDeDepartamentos");
            Boolean esBusqueda = (Boolean) request.getAttribute("esBusqueda");
            if (esBusqueda == null) esBusqueda = false; 
            %>

            <% if(listaDepartamentos != null && !listaDepartamentos.isEmpty()) { %>
                <% for(Departamento departamento : listaDepartamentos) { %>
                    <div class="col-md-12">
                        <div class="department-card">
                            <img src="<%= departamento.getImagenDepartamento() %>" alt="Imagen Departamento" />
                            <div class="department-details">
                                <h5><%= departamento.getNombre() %></h5>
                                <p><strong>Capacidad:</strong> <%= departamento.getCapacidad() %></p>
                                <p><strong>Habitaciones:</strong> <%= departamento.getNroHabitaciones() %></p>
                                <p><strong>Descripción:</strong> <%= departamento.getDescripcion() %></p>
                                <p><strong>Servicios incluidos:</strong> <%= departamento.getServiciosIncluidos() %></p>
                                <p><strong>Disponibilidad:</strong> <%= departamento.getDisponibilidad() %></p>
                                <p class="price">S/. <%= departamento.getPrecioPorNoche() %> por noche</p>
                                <form action="ReservaServlet" method="post">
                                    <input type="hidden" name="departamentoId" value="<%= departamento.getIdDepartamento() %>">
                                    <input type="submit" value="Reservar" class="btn btn-success">
                                     <input href="ReservaServlet?opcion=irConfirmar&id=<%=departamento.getIdDepartamento()%>"   type="hidden" name="opcion" value="irConfirmar">
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                <% } %>
            <% } else if (esBusqueda) { %>
                <div class="col-12">
                    <div class="alert alert-danger text-center">No existe el departamento con el ID ingresado</div>
                </div>
            <% } else { %>
                <div class="col-12">
                    <div class="alert alert-warning text-center">No se encuentran departamentos registrados</div>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
