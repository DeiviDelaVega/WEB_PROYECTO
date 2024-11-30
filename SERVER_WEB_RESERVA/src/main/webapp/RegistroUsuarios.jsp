<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>        
     	<label for="nombre">Nombre:</label><br>
  		<input type="text" id="nombre" name="nombre"><br><br>
  		
  		<label for="apellido">Apellido:</label><br>
  		<input type="text" id="apellido" name="apellido"><br><br>
  		
  		<label for="correo">Correo:</label><br>
  		<input type="email" id="correo" name="correo"><br><br>
  		
  		<label for="usuario">Usuario:</label><br>
        <input type="text" id="usuario" name="usuario" ><br>
          
  		<label for="lname">Clave:</label><br>
        <input type="password" id="clave" name="clave" ><br><br>
         
          <label for="rol">Rol:</label>
         <select id="rol" name="rol">
         <option value="empleado">Empleado</option>
         <option value="usuario">Usuario</option>
         
        </select><br><br>
  		
  	   <button type="submit">Registrarte</button>


</body>
</html>