<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--  --> 
<h2>Modificacion Empleado</h2>
	<form action="cliente" method="post">
    	<!-- Campo oculto para el ID del departamento -->
    	<input type="hidden" id="idCliente" name="idCliente" value="${cliente.getId_Cliente()}">
		<!-- Campo oculto que pasa la opción 'guardar' al servlet -->
    	<input type="hidden" name="opcion" value="guardar">
    
        <br>
        
         <label for="nombre">Nombre:</label><br>
          <input type="text" id="nombre" name="nombre"  value="${cliente.getNombre()}"><br><br>


          <label for="apellido">Apellido:</label><br>
          <input type="text" id="apellido" name="apellido"  value="${cliente.getApellido()}"><br><br>

          <label for="nro_documento">Nº Documento:</label><br>
          <input type="text" id="nro_documento" name="nro_documento"  value="${cliente.getNro_Documento()}"><br><br>
          
          <label for="telefono">Telefono:</label><br>
          <input type="text" id="telefono" name="telefono"  value="${cliente.getTelefono()}"><br><br>
          
          <label for="direccion">Fecha de contrato:</label><br>
          <input type="text" id="direccion" name="direccion"  value="${cliente.getDireccion()}"><br><br>
          
          <label for="correo">Correo:</label><br>
          <input type="email" id="correo" name="correo"  value="${cliente.getCorreo()}"><br><br>
          
           <label for="clave">Clave:</label><br>
          <input type="password" id="clave" name="clave"  value="${cliente.getClave()}"><br><br>

    	<input type="submit" value="Guardar" name="opcion" value="guardar">
    	<input type="button" value="Cancelar" onclick="window.location.href='listadoCliente.jsp'">
	</form>
</body>
</html>