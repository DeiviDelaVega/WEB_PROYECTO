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
        <form action="cliente" method="post">
            <input type="button" value="Listado" onclick="window.location.href='listadoCliente.jsp'">
        </form>
    </div>
    <div class="details-container">
        <div class="detail-row">
            <label>ID:</label>
            <div>${ eCliente.getId_Cliente() }</div>
        </div>
        <div class="detail-row">
            <label>Nombre:</label>
            <div>${ eCliente.getNombre() }</div>
        </div>
        <div class="detail-row">
            <label>Apellido:</label>
            <div>${ eCliente.getApellido() }</div>
        </div>
        <div class="detail-row">
            <label>Nº Documento:</label>
            <div>${ eCliente.getNro_Documento() }</div>
        </div>
         <div class="detail-row">
            <label>Telefono:</label>
            <div>${ eCliente.getDireccion() }</div>
        </div>
        <div class="detail-row">
            <label>Telefono:</label>
            <div>${ eCliente.getTelefono() }</div>
        </div>
        
 
        <div class="detail-row">
            <label>Correo:</label>
            <div>${ eCliente.getCorreo }</div>
        </div>
        
        <div class="detail-row">
            <label>Clave:</label>
            <div>${ eCliente.getClave() }</div>
        </div>
    </div>
</div>
</body>
</html>
