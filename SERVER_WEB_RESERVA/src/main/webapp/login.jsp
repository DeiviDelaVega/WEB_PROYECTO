<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Monterrico Polo</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="images/departamento.png" type="image/x-icon">
    
    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url("images/fondoPolo.png");
            background-size: cover;
            background-position: center;
        }
        .login-card {
            max-width: 900px;
            width: 100%;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            background: white;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.9); /* Fondo blanco semitransparente */
            padding: 40px;
        }
        .login-image-container {
            text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semitransparente */
        }
        .login-image {
            max-width: 100%;
            height: auto;
        }
        .brand-label {
            font-weight: bold;
            color: #495057;
            text-align: center;
            margin-top: 45px;
            font-size: 30px;
        }
        .form-title {
            font-weight: bold;
            color: #495057;
            text-align: center;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div class="login-card d-flex">
    <!-- Imagen -->
    <div class="col-md-6 login-image-container">
        <img class="login-image" src="images/poloMonterrico.png" alt="Monterrio Polo Aparts">
    </div>
    
    <!-- Formulario -->
    <div class="col-md-6">
        <div class="form-container">
            <h2 class="form-title">Iniciar Sesión</h2>
            <form action="Login" method="post">
                <div class="mb-3">
                    <label for="correo" class="form-label">Correo Electrónico</label>
                    <input type="email" class="form-control" name="correo" id="correo" placeholder="correo@ejemplo.com" required>
                </div>
                <div class="mb-3">
                    <label for="clave" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" name="clave" id="clave" placeholder="••••••••" required>
                </div>
     
               <div class="d-grid mb-3">
                    <button type="submit" class="btn btn-primary btn-lg">Ingresar</button>
                </div>

               </form>
                <p class="text-center">
                    ¿No tienes cuenta? <a href="RegistroCliente.jsp">Regístrate aquí</a>
                </p>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
