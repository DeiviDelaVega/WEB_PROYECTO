<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>        
     <form action="ServletRegistrar" method="post">
   
        <label for="nombre">Nombre completo:</label>
        <input type="text" name="nombre" id="nombre" required><br><br>
        
        <label for="correo">Correo electrónico:</label>
        <input type="email" name="correo" id="correo" required><br><br>
        
        <label for="clave">Contraseña:</label>
        <input type="password" name="clave" id="clave" required><br><br>
        
        <button type="submit">Registrarse</button>
    </form>
    
    <p>¿Ya tienes cuenta? <a href="login.jsp">Inicia sesión aquí</a></p>
 
</body>
</html>