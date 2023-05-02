<%@page import="java.util.ArrayList"%>
<%@page import="interfaces.IControladorActividadDeportiva"%>
<%@page import="interfaces.IControladorUsuario"%>
<%@page import="interfaces.Fabrica"%>
<%@page import="datatypes.DtUsuario" %>
<%@page import="datatypes.DtProfesor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Nueva Clase</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    
        
    <%@include file="/header.jsp" %>

</head>

<body onload="mostrarNotificacionError();">

<%
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorActividadDeportiva icon = fabrica.getIControladorActividadDeportiva();
	IControladorUsuario iconU = fabrica.getIControladorUsuario();
	HttpSession sesion = request.getSession();
	String nickname = (String)sesion.getAttribute("nombreUsuario");
	ArrayList<String> actividades = new ArrayList<String>();
	if(nickname != null){
		DtUsuario dtu = iconU.consultaUsuario(nickname);
		if(dtu instanceof DtProfesor){
			actividades = icon.listarActividadesDeportivas(((DtProfesor)dtu).getInstitucion().getNombre());
		}
	}
	
%>



    <div class="contenedor-total">

        <div class="contenedor">
          

            <div class="contenedor2" >
                <div class="row" id="rowTitulo">
                    <hr class="dashed col" id="dashtop">
                    <h1 class="col" id="tituloPantalla" style="font-size:50px;letter-spacing: 2px;text-shadow: 0px 3px #b34d1d; color: #FF9B55; text-align: center;">Nueva&nbspClase</h1>
                    <hr class="dashed col" id="dashbottom">
                </div>
                <br>
                <h4 style="text-align:center ;">Ingrese los datos para crear una nueva clase.</h4>
                <br><br>
                <form action="AltaDictadoClase" method="post">    
	                <div class="form-floating mb-3">
	                    <select class="form-select" aria-label="Default select example" name="actividadDeportiva" required>
	                    	<%
	                    	for(String a : actividades){
	                    		
	                    	%>
	                       	<option value="<%=a%>"><%=a%> </option>
	
	                        <%
	                    	}
	                        %>
	                    </select>
	                    <label for="floatingInput">Actividad Deportiva</label>
	                </div>
	                <br>
	                <div class="form-floating mb-3">
	                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="nombre" required>
	                    <label for="floatingInput">Nombre de clase</label>
	                </div>
	                <br>
	                <div class="form-floating">
	                    <input type="datetime-local" class="form-control" id="floatingPassword" placeholder="Password" name="fechaInicio" required>
	                    <label for="floatingPassword">Fecha de Inicio</label>
	                </div>
	                <br> <br>
	                <div class="form-floating mb-3">
	                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="urlClase" required>
	                    <label for="floatingInput">URL de clase</label>
	                </div>
	                <br> 
	                <div class="form-floating mb-3">
	                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="urlImagen">
	                    <label for="floatingInput">URL de imagen</label>
	                </div>
	                <br> <br> <br>
	                <div style="display: flex; justify-content: center; align-items: center;">
	                    <button type="submit" class="btn btn-primary btn-lg boton2" >Crear</button>
	                    
	                </div>
                </form>
            </div>
        </div>

    </div>
    
    


<%@include file="/footer.jsp" %>
</body>

</html>