<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Entrenamos, deporte en línea</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />

    <%@include file="/header.jsp" %>

</head>
<body onload="mostrarNotificacion();">

    <div class="contenedor-total">
        <img src="imagenes/decoracion.png" id="decoracion" style="width: 100%; z-index: 1; position: relative;" alt="decoracion">
        <!--<div style="background-image: url(imagenes/decoracion.png); width: 100%; height: 471px; background-repeat: no-repeat; background-size:contain;"></div>-->
        <div id="carouselExampleIndicators" class="carousel slide" style="width: 60%; margin-left:20% ; z-index: 2; position:relative; top: 0px; margin-top: -36%;box-shadow: 0px 4px 4px rgba(90, 13, 13, 0.356); border-radius: 40px;" data-bs-ride="true">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner" style="border-radius: 14px;">
              <div class="carousel-item active">
                <img src="imagenes/img.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="imagenes/img2.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="imagenes/img3.jpg" class="d-block w-100" alt="...">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>

        <div class="contenedor">
            <div class="contenedor2" >
                <div class="row">
                    <hr class="dashed col" style="margin-top:auto ; margin-bottom:auto">
                    <%if (tipoUsuario == "Visitante"){%>
                    	<a class="btn btn-primary btn-lg boton col" href="IniciarSesion.jsp">COMIENZA AQUI</a>
                    	
                    <%}else{%>
						<a class="btn btn-primary btn-lg boton col" href="ConsultaUsuario.jsp">COMIENZA AQUI</a>
					<%} %>
                    <hr class="dashed col" style="margin-top:auto ; margin-bottom:auto">
                </div>
            </div>
            
            
            <div style="padding-top: 35px; padding-left: 7%; padding-right: 7%;">
                <div style="display:flex;">
                    <div class="desc1">
                        <div class="header-1" style="display: flex;">
                            <h1 id="titulo">NUESTRO&nbsp</h1><h1 style="color: #FF9B55;">OBJETIVO</h1>    
                        </div>
                        <p style="width: 100%; margin: 0; padding: 0; margin-top: 16px;">La propagación del coronavirus en el mundo ha afectado considerablemente la salud de las personas tanto por los efectos del virus y los contagios, como por la suspensión de actividades deportivas en general y el cierre de clubes y gimnasios deportivos. </p>
                    </div>
                    <img class="icono" src="vector/pesa.svg" alt="" >
                    
                </div>
                <br id="breakNoMovil"> <br>
                <div style="display:flex;">
                    <img class="icono" src="vector/tenis.svg" alt="" >
                    <div class="desc1">
                        <div class="header-1" style="display: flex;">
                        </div>
                        <p style="width: 100%; margin: 0; padding: 0; margin-top: 16px;">En Entrenamos.uy pretendemos brindar una forma alternativa para la realización de actividades deportivas a través de nuestra plataforma, que permite el acceso a clases en línea dictadas por los más hábiles profesores disponibles de diversas instituciones. </p>
                    </div>
                </div>

            </div>
            
        </div>

    </div>
    


<%@include file="/footer.jsp" %>
</body>
</html>