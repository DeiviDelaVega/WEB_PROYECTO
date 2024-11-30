<%@page import="modelo.Usuario"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Admin".equals(usuario.getRol())) {
        response.sendRedirect("login.jsp?error=Acceso no autorizado");
    }
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>Bienvenido, Administrador</h2>
    <p>Usuario: <%= usuario.getNombre() %></p>
    <a href="logout.jsp">Cerrar sesión</a>

    <h3>Crear Empleado</h3>
    <form action="Empleado" method="post">
        <label for="nombre">Nombre del empleado:</label>
        <input type="text" name="nombre" id="nombre" required>
        
        <label for="correo">Correo del empleado:</label>
        <input type="email" name="correo" id="correo" required>
        
        <label for="clave">Contraseña del empleado:</label>
        <input type="password" name="clave" id="clave" required>
        
        <button type="submit">Crear</button>
    </form>
</body>
</html>