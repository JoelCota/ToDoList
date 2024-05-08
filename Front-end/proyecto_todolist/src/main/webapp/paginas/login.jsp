<%-- 
    Document   : login
    Created on : 24 jun. 2023, 5:18:14 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar sesión</title>
        <link href=".\estilos\login_styles.css" rel="stylesheet" />
    </head>
    <body>
        <div class="banner">
            <div class="logo">
                <img src="./iconos/tu_logo.png" alt="Logo">
            </div>
        </div>
        <div class="container" >
            <h2 id="titulo-inicio-sesion">Iniciar sesión</h2>
            <form id="formulario-inicio-sesion" action="./usuario?action=iniciar-sesion" method="post">
                <input type="text" placeholder="Correo electrónico" id="correo-electronico">
                <input type="password" placeholder="Contraseña" id="contrasena">
                <input type="submit" value="Iniciar sesión">
            </form>
            <div class="links">
                <a href="#">¿Olvidaste tu contraseña?</a>
                <a href="registro.html">¿No tienes una cuenta? Regístrate</a>
            </div>
        </div>
    </body>
</html>
