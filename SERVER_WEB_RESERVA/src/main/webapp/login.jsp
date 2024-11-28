<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="usuario" method="post">

  <label for="usuario">Usuario:</label><br>
  <input type="text" id="usuario" name="usuario" ><br>
  
  <label for="lname">Clave:</label><br>
  <input type="password" id="clave" name="clave" ><br><br>
  
  <input type="submit" value="Ingresar">
</form> 
		<%String mensaje = request.getParameter("mensaje");
		if(mensaje!=null) {
	%>
	<p><%= mensaje%></p>
	<% } %>



</body>
</html>