<%@page import="modelo.Usuario"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Empleado".equals(usuario.getRol())) {
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
  <h2>Bienvenido, Empleado</h2>
    <p>Usuario: <%= usuario.getNombre() %></p>
    <a href="logout.jsp">Cerrar sesión</a>
</body>
</html>