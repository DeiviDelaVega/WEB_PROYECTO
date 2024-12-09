<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>


    <h2>Iniciar Sesión</h2>
    <form action="Login" method="post">
        <label for="correo">Correo electrónico:</label>
        <input type="email" name="correo" id="correo" required><br><br>
        
        <label for="clave">Contraseña:</label>
        <input type="password" name="clave" id="clave" required><br><br>
        
        <button type="submit">Ingresar</button>
    </form>
    <p>¿No tienes cuenta? <a href="RegistroCliente.jsp">Regístrate aquí</a></p>
    
 
</body>
</html>