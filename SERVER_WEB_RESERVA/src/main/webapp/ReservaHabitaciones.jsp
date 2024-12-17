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
        
        .imagenlogo {

width: 100px;
height: auto;
}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="inicioCliente.jsp"><img alt="" src="images/poloMonterrico.png" class="imagenlogo"></a>
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="home.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ReservaHabitaciones.jsp" onclick="document.getElementById('listadoForm').submit(); return false;">Reserva Habitaciones</a>
                    </li>
                    <li class="nav-item">
                          <a class="nav-link" href="ReservaServlet?opcion=buscarReservasCliente">Tus reservas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Salir</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <h2 class="my-4">Lista de Departamentos</h2>
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
