
<%@page import="interfaces.IControladorUsuario"%>
<%@page import="datatypes.DtSocio"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="interfaces.IControladorClase"%>

<%@page import="datatypes.DtProfesor"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="interfaces.IControladorUsuario"%>

<%@page import="interfaces.Fabrica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Editar perfil</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    
        
    <%@include file="/header.jsp" %>

</head>

<body onload="mostrarNotificacion();">

<%
	HttpSession sesion = request.getSession();
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorClase iconC = fabrica.getIControladorClase();
	IControladorUsuario iconU = fabrica.getIControladorUsuario();
	
	String nickname = (String)sesion.getAttribute("nombreUsuario");
	ArrayList<DtClase> clasesRegistradas = new ArrayList<DtClase>();
	if(nickname != null){
		DtUsuario dtu = iconU.consultaUsuario(nickname);
		if(dtu instanceof DtSocio){
			clasesRegistradas = ((DtSocio)dtu).getClases();
		}
	}
%>

<%
	DtUsuario dtu = iconU.consultaUsuario(nickname);
	String dia = String.format("%02d", dtu.getFecha().getDia());
	String mes = String.format("%02d", dtu.getFecha().getMes());
%>

    <div class="contenedor-total">

        <div class="contenedor">
          

            <div class="contenedor2" >
                <div class="row" id="rowTitulo">
                    <hr class="dashed col" id="dashtop">
                    <h1 class="col" id="tituloPantalla" style="font-size:50px;letter-spacing: 2px;text-shadow: 0px 3px #b34d1d; color: #FF9B55; text-align: center;">Editar&nbspPerfil</h1>
                    <hr class="dashed col" id="dashbottom">
                </div>
                <br>
                <h4 style="text-align:center ;">Modifique los datos que quiera cambiar.</h4>
                <br><br>
        <form action="ModificarUsuario" method="post">     
                <div class="form-floating mb-3">
                	<input type="hidden" value="<%=dtu.getNickname()%>" name= "nickUsuario">
                	<input type="hidden" value="<%=dtu.getEmail()%>" name= "mailkUsuario">
                    <input type="hidden" value="<%=dtu.getContrasenia()%>" name= "passUsuario">
                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" value="<%=dtu.getNombre()%>" name= "nomUsuario" required>
                    <label for="floatingInput">Nombre</label>
                </div>
                <br>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" value="<%=dtu.getApellido()%>" name="apellidoUsuario" required>
                    <label for="floatingInput">Apellido</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="date" class="form-control" id="floatingPassword" placeholder="Password" value="<%=dtu.getFecha().getAnio()%>-<%=mes%>-<%=dia%>" name="fecNacimiento" required>
                    <label for="floatingPassword">Fecha de nacimiento</label>
                </div>
                <br> <br>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" value="<%=dtu.getpfp()%>" name="imagen">
                    <label for="floatingInput">URL de imágen de perfil</label>
                </div><br>
                
                <%if((dtu instanceof DtProfesor)){
                	DtProfesor dtp = (DtProfesor)dtu;
                %>              
	                <div class="form-floating">
	                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name="descProf" style="height: 100px" required><%=dtp.getDescripcion()%></textarea>
	                    <label for="floatingTextarea2">Descripción</label>
	                </div><br><br>
	                <div class="form-floating">
	                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name="bioProf" style="height: 100px"><%=dtp.getBiografia()%></textarea>
	                    <label for="floatingTextarea2">Biografía (opcional)</label>
	                </div><br><br>
	                <div class="form-floating mb-3">
	                    <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name = "urlProf" value="<%=dtp.getSitioWeb()%>">
	                    <label for="floatingInput">Sitio web (opcional)</label>
                	</div>
                <%} %>
                
                <br> 
                <div style="display: flex; justify-content: center; align-items: center;">
                    <button id="cancelarModificar" type="button" class="btn btn-primary btn-lg boton2" style="margin-right:50px" value="Go Back" onclick="history.back()">Cancelar</button>
                    <button id="confirmarModificar" type="submit" class="btn btn-primary btn-lg boton2" >Confirmar</button>
                </div>
                 </form> 
                
                <%if(dtu instanceof DtSocio){ %>
                <br> <br> 
                <div style="display:flex ;">
                    <p style="margin:auto ; padding-right:19px ; font-size: 30px;">Eliminar registros?</p>
                    <hr class="dashed col" style="margin-top: 23px;">
                </div> <br> <br>
                
                
                
                <div id="listaPC">
                
                
                <%if(!clasesRegistradas.isEmpty()){ %>
                <div id="carouselExampleControls" style="width: 828px ; margin-left: auto;margin-right: auto;" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                    	
                    	
                    	<%
                    	int i = 1;
                    	boolean primeraVez = true;
                    	for(DtClase c : clasesRegistradas){%>
                    		
                    		<%if(i == 1){ %>
	                    		<div class="carousel-item <%if(primeraVez){%>active<%}%>"data-bs-interval="100000000000000">
	                            <div style="display:flex; column-gap: 30px;">
                    		<%}%>
                    	
				        	<div class="card custom-card" style="width: 16rem; margin-bottom: 30px;">
                            	<img style="height: 200px; object-fit:cover;"src="<%=c.getPicture()%>" onerror="this.onerror=null; this.src='imagenes/defClase.png'" class="card-img-top" alt="...">
                            	<h5 class="card-title custom-card-title"><%=c.getNombre()%></h5>
                            	<form action="EliminarRegistroDictadoClase" method="post">
                            		<input type="hidden" name="clase" id="clase" value="<%=c.getNombre() %>">
	                            	<div class="card-body" style="padding-top:0; padding-bottom: 0;">
		                            	<ul class="list-group list-group-flush">
		                                	<li class="list-group-item"> <a class="card-text p-small" style="display: block; width:fit-content;margin:auto; color: #ee8f4c; padding-bottom: 8px;" href="https://www.google.com/"><%=c.getUrl()%></a></li>
		                                	<li class="list-group-item" style="text-align: center;"><%=c.getFechaInicio()%></li>
		                                	
									    		<input class="btn btn-primary btn-lg boton2 small" type="submit" style="margin-top: 15px;" value="Eliminar" />
											
		                                	<li class="list-group-item" style="text-align: center;font-size: 13px; color: rgb(165, 165, 165);">Registro: <%=c.getFechaReg()%></li>
		                                </ul>
	                            	</div>
                            	</form>
                        	</div> 
                        	
                        	<%if(i == 3){ %>
		                        </div>
		                        </div>
                    		<%}%>

                                     	
				        <%
				        i++;
				        if(i > 3){
				        	i = 1;
				        }
				        primeraVez = false;
                    	}
                    	
                    	if(i != 1){%>
                    		</div>
		                    </div>
                    	<%}%>
                    	





                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <div style="background-color:#ee8f4c ; position: relative; right: 100px; padding: 5px; padding-right: 7px; border-radius: 50%;">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        </div>
                      <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <div style="background-color:#ee8f4c ; position: relative; right: -100px; padding: 5px; padding-left: 7px; border-radius: 50%;">
                            <span class="carousel-control-next-icon" aria-hidden="true" ></span>

                        </div>
                      <span class="visually-hidden">Next</span>
                    </button>
                  </div>
                  <%}else{ %>
                  	<p style="text-align: center">No esta registrado a ninguna clase.</p>
                  <%} %>
                  
                  </div>
                  
                  <div id="listaMovil" style="display: none;">
	                  	<%if(!clasesRegistradas.isEmpty()){ %>
	                 	<div id="nav-wrapper">
						    <ul class="nav nav-tabs">
						    
								<%for(DtClase c : clasesRegistradas){ %>
						    	
						        <li><div id="contCarta">
									<div class="card custom-card" style="width: 16rem;">
                            	<img style="height: 200px; object-fit:cover;"src="<%=c.getPicture()%>" onerror="this.onerror=null; this.src='imagenes/defClase.png'" class="card-img-top" alt="...">
                            	<h5 class="card-title custom-card-title"><%=c.getNombre()%></h5>
                            	<form action="EliminarRegistroDictadoClase" method="post">
                            		<input type="hidden" name="clase" id="clase" value="<%=c.getNombre() %>">
	                            	<div class="card-body" style="padding-top:0; padding-bottom: 0;">
		                            	<ul class="list-group list-group-flush">
		                                	<li class="list-group-item"> <a class="card-text p-small" style="display: block; width:fit-content;margin:auto; color: #ee8f4c; padding-bottom: 8px;" href="https://www.google.com/"><%=c.getUrl()%></a></li>
		                                	<li class="list-group-item" style="text-align: center;"><%=c.getFechaInicio()%></li>
		                                	
									    		<input class="btn btn-primary btn-lg boton2 small" type="submit" style="margin-top: 15px;" value="Eliminar" />
											
		                                	<li class="list-group-item" style="text-align: center;font-size: 13px; color: rgb(165, 165, 165);">Registro: <%=c.getFechaReg()%></li>
		                                </ul>
	                            	</div>
                            	</form>
                        	</div> 
								</div> </li>
						        
						        <%}%>
	
						    </ul>
						</div>
	                  
	                  	<% }else{%>
	                  		<p style="text-align: center">No esta registrado a ninguna clase.</p>
	                  <%} %>
	                  
                  </div>
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                <%} %>
                
                
        	        
            </div>
         
        </div>

    </div>
    
    
<%@include file="/footer.jsp" %>
</body>

</html>