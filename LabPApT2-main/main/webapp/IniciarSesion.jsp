<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Iniciar Sesion</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    
        
    <%@include file="/header.jsp" %>

</head>

<body onload="mostrarNotificacionError();">

    <div class="contenedor-total">
        <div class="contenedor">
            <div class="contenedor2" >
				<form action="IniciarSesion" method="post">

                <div class="row" id="rowTitulo">
                    <hr class="dashed col" id="dashtop">
                    <h1 class="col" id="tituloPantalla" style="font-size:50px;letter-spacing: 2px;text-shadow: 0px 3px #b34d1d; color: #FF9B55; text-align: center;">Bienvenido/a!</h1>
                    <hr class="dashed col" id="dashbottom">
                </div>
                <br>
                <h4 style="text-align:center ;">Ingrese sus datos para acceder a su cuenta.</h4>
                <br><br>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="nickname" id="floatingInput" placeholder="name@example.com" required>
                    <label for="floatingInput">Nickname</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password" required>
                    <label for="floatingPassword">Contraseña</label>
                </div>
                <br> <br> <br>
                <div style="display: flex; justify-content: center; align-items: center;">
                    <button type="submit" class="btn btn-primary btn-lg boton2" >Acceder</button>
                </div>
                				</form>
            </div>
        </div>

    </div>

  

<%@include file="/footer.jsp" %>
</body>

</html>