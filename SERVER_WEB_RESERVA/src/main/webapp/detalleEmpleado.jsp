<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Detalle Empleado</h2>
	<div class="container">
	<div class="form-container">
        <form action="Empleado" method="post">
            <input type="button" value="Listado" onclick="window.location.href='listadoEmpleado.jsp'">
        </form>
    </div>
    <div class="details-container">
        <div class="detail-row">
            <label>ID:</label>
            <div>${ eEmpleado.getId_Empleado() }</div>
        </div>
        <div class="detail-row">
            <label>Nombre:</label>
            <div>${ eEmpleado.getNombre() }</div>
        </div>
        <div class="detail-row">
            <label>Apellido:</label>
            <div>${ eEmpleado.getApellido() }</div>
        </div>
        <div class="detail-row">
            <label>Nº Documento:</label>
            <div>${ eEmpleado.getNro_Documento() }</div>
        </div>
        <div class="detail-row">
            <label>Telefono:</label>
            <div>${ eEmpleado.getTelefono() }</div>
        </div>
        
        <div class="detail-row">
            <label>Fecha contratacion:</label>
            <div>${ eEmpleado.getFecha_Contratacion() }</div>
        </div>
        <div class="detail-row">
            <label>Correo:</label>
            <div>${ eEmpleado.getCorreo_Electronico() }</div>
        </div>
        
        <div class="detail-row">
            <label>Clave:</label>
            <div>${ eEmpleado.getClave() }</div>
        </div>
    </div>
</div>
</body>
</html>