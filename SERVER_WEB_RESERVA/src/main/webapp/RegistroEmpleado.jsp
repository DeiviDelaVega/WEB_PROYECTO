<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<form action="Empleado" method="post">




         <label for="rol">Rol:</label>
         <select id="rol" name="rol">
         <option value="1">Creador de Reservas</option>
         <option value="2">Registro de Check-In y Check-Out</option>
        </select><br><br>
        
         <label for="nombre">Nombre:</label><br>
          <input type="text" id="nombre" name="nombre"><br><br>


          <label for="apellido">Apellido:</label><br>
          <input type="text" id="apellido" name="apellido"><br><br>

          <label for="nro_documento">Nº Documento:</label><br>
          <input type="text" id="nro_documento" name="nro_documento"><br><br>
          

          <label for="telefono">Telefono:</label><br>
          <input type="text" id="telefono" name="telefono"><br><br>

          <label for="correo">Correo:</label><br>
          <input type="email" id="correo" name="correo"><br><br>
          
           <label for="clave">Clave:</label><br>
          <input type="password" id="clave" name="clave"><br><br>
          
         <button type="submit">Registrar</button>
</form>


        <%String mensaje = request.getParameter("mensaje");
        if(mensaje!=null) {
    %>
    <p><%= mensaje%></p>
    <% } %>



</body>
</html>