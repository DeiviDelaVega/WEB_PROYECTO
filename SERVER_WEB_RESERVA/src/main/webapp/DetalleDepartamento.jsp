<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle de Departamento</title>
</head>
<body>
   	<h2>Detalle de Departamento</h2>
	<div class="container">
	<div class="form-container">
        <form action="departamento" method="post">
            <input type="button" value="Listado" onclick="window.location.href='ListadoDepartamento.jsp'">
        </form>
    </div>
    <div class="details-container">
        <div class="detail-row">
            <label>ID:</label>
            <div>${ eDepartamento.getIdDepartamento() }</div>
        </div>
        <div class="detail-row">
            <label>Nombre:</label>
            <div>${ eDepartamento.getNombre() }</div>
        </div>
        <div class="detail-row">
            <label>Capacidad:</label>
            <div>${ eDepartamento.getCapacidad() }</div>
        </div>
        <div class="detail-row">
            <label>Numero de habitaciones:</label>
            <div>${ eDepartamento.getNroHabitaciones() }</div>
        </div>
        <div class="detail-row">
            <label>Descripcion:</label>
            <div>${ eDepartamento.getDescripcion() }</div>
        </div>
        <div class="detail-row">
            <label>Servicios incluidos:</label>
            <div>${ eDepartamento.getServiciosIncluidos() }</div>
        </div>
        <div class="detail-row">
            <label>Disponibilidad:</label>
            <div>${ eDepartamento.getDisponibilidad() }</div>
        </div>
        <div class="detail-row">
            <label>Precio por noche:</label>
            <div>${ eDepartamento.getPrecioPorNoche() }</div>
        </div>
    </div>
</div>
</body>
</html>