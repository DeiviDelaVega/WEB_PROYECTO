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
	<form action="Empleado" method="post">
    	<!-- Campo oculto para el ID del departamento -->
    	<input type="hidden" id="idEmpleado" name="idEmpleado" value="${empleado.getId_Empleado()}">
		<!-- Campo oculto que pasa la opción 'guardar' al servlet -->
    	<input type="hidden" name="opcion" value="guardar">
    
        <br>
        
         <label for="nombre">Nombre:</label><br>
          <input type="text" id="nombre" name="nombre"  value="${empleado.getNombre()}"><br><br>


          <label for="apellido">Apellido:</label><br>
          <input type="text" id="apellido" name="apellido"  value="${empleado.getApellido()}"><br><br>

          <label for="nro_documento">Nº Documento:</label><br>
          <input type="text" id="nro_documento" name="nro_documento"  value="${empleado.getNro_Documento()}"><br><br>
          
       <label for="telefono">Telefono:</label><br>
          <input type="text" id="telefono" name="telefono"  value="${empleado.getTelefono()}"><br><br>
         
          <label for="telefono">Fecha de contrato:</label><br>
          <input type="text" id="fechaContrato" name="fechaContrato"  value="${empleado.getFecha_Contratacion()}"><br><br>

          <label for="correo">Correo:</label><br>
          <input type="email" id="correo" name="correo"  value="${empleado.getCorreo_Electronico()}"><br><br>
          
           <label for="clave">Clave:</label><br>
          <input type="password" id="clave" name="clave"  value="${empleado.getClave()}"><br><br>

    	<input type="submit" value="Guardar" name="opcion" value="guardar">
    	<input type="button" value="Cancelar" onclick="window.location.href='listadoEmpleado.jsp'">
	</form>
</body>
</html>