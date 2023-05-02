<%@page import="datatypes.DtFecha"%>
<%@page import="datatypes.DtFechaHora"%>
<%@page import="datatypes.DtClase"%>
<%@page import="datatypes.DtActividadDeportiva"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtSocio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintStream"%>
<%@page import="interfaces.IControladorActividadDeportiva"%>
<%@page import="interfaces.IControladorClase"%>
<%@page import="interfaces.IControladorUsuario"%>
<%@page import="interfaces.Fabrica"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Ver Clases</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />


    <%@include file="/header.jsp" %>


</head>

<body>

	<%
	
	//Todo esto está más o menos copiado del ConsultaActividadDeportiva
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorActividadDeportiva icon = fabrica.getIControladorActividadDeportiva();
	IControladorClase icC = fabrica.getIControladorClase();
	IControladorUsuario icU = fabrica.getIControladorUsuario();
	ArrayList<String> actividades = icon.getActividadesDeportivas();
	ArrayList<String> clases;
	ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
	for (String a : actividades) {
		clases = icC.listarClases(a);
		for(String b : clases){
			dtClases.add(icon.getDtClase(b));
		}
	}

	DtClase claseActiva = null;
	%>

    <div class="contenedor-total">

        <div class="contenedor">


            <div class="contenedor2">
                <div class="row" id="rowTitulo">
                    <hr class="dashed col" id="dashtop">
                    <h1 class="col" id="tituloPantalla"
                        style="font-size:50px;letter-spacing: 2px;text-shadow: 0px 3px #b34d1d; color: #FF9B55; text-align: center;">
                        Clases</h1>
                    <hr class="dashed col" id="dashbottom">
                </div>
                
	                <div id="rankingFlex" style="display: flex; justify-content:right; align-items: right;">
	                <form method="post">
	                	<input type="hidden" name="ranking" id="ranking" value="ranking">
	                    <button type="submit" class="btn btn-primary btn-lg boton2 small ranking" data-bs-toggle="tooltip"
	                        data-bs-placement="bottom" data-bs-title="Ordenar por no. de socios"
	                        data-bs-custom-class="custom-tooltip"><img class="img-ranking" src="vector/ranking.svg"
	                            style="width: 34px;">
	                            <p id="rankingTexto" style="display: none">Ordenar por número de socios</p>
	                    </button>
	                </form>
	                </div>
                
                <br><br>
                <div style="display:grid;">
                    <div class="row">
                    	<%
                    	//Este for. Se hace para cada clase, digamos
                    	String[] usuarios = icU.mostrarUsuarios();
						ArrayList<DtUsuario> socios = new ArrayList<DtUsuario>(); 
						ArrayList<DtSocio> sociosEnClase = new ArrayList<DtSocio>();
						ArrayList<DtClase> dtC = new ArrayList<DtClase>();	
                    	int cont = 0;
						
                    	String ranking = request.getParameter("ranking");
                    	if(ranking != null){
                    		dtClases =icC.rankingClases();
                    	}
                    	
                    	if(!dtClases.isEmpty()){
                    	
						for (DtClase a : dtClases) {
							socios = new ArrayList<DtUsuario>(); 
							sociosEnClase = new ArrayList<DtSocio>();
							dtC = new ArrayList<DtClase>();	
							String nombre = a.getNombre();
							String url = a.getUrl();
							DtFechaHora inicio = a.getFechaInicio();
							DtFecha registro = a.getFechaReg();
							String picture = a.getPicture();
						
							//Esto es el código para sacar los usuarios que tiene que mostrar el modal 
						
							
							//Obtengo los usuarios que son socios
							for(String j : usuarios){
								DtUsuario usuario = icU.consultaUsuario(j);
								if(usuario instanceof DtSocio){
									socios.add(usuario);
								}
							}
							
							
							//Por cada socio, obtengo sus clases
							for(DtUsuario U : socios){
								dtC = ((DtSocio)U).getClases();
								//Y las comparo con la clase "global" que se está usando (a) para saber si está anotado a la misma 
								for(DtClase C : dtC){
									if(nombre == C.getNombre()){
										//Si lo está, lo agrego a una colección de socios para mostrar luego
										sociosEnClase.add((DtSocio)U);
									}
								}
							}
							
							String curTime = String.format("%02d:%02d", inicio.getHora(), inicio.getMin());
						%>
                        <div class="col">
                            <div class="card custom-card" id="cartaVertical" style="width: 16rem; margin-bottom: 30px;">

                                <img style="height: 200px; object-fit:cover;"
                                    src="<%=picture%>"
                                    class="card-img-top" alt="..." onerror="this.onerror=null; this.src='imagenes/defClase.png'">
                                <h5 class="card-title custom-card-title"><%=nombre%></h5>
                                <div class="card-body" style="padding-top:0; padding-bottom: 0;">
                                   
        
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item"> <a class="card-text p-small" style="display: block; width:fit-content;margin:auto; color: #ee8f4c; padding-bottom: 8px;" href="https://www.google.com/"><%=url%></a></li>
                                        <li class="list-group-item" style="text-align: center;"><%=inicio.getDia()%>/<%=inicio.getMes()%>/<%=inicio.getAnio()%> <%=curTime%></li>
                                        
                                        
  										<button type="button" style="margin-top: 15px;" class="btn btn-primary btn-lg boton2 small" data-bs-toggle="modal" data-bs-target="#modalSocios<%=cont%>" data-actividad="<%=nombre%>">Ver socios</button>
  										
  										<!-- inicio Modal -->
										<div class="modal fade" id="modalSocios<%=cont%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
									        <div class="modal-dialog">
									            <div class="modal-content">
									               <div class="modal-header">
									                    <h1 class="modal-title fs-5" id="exampleModalLabel">Socios registrados a <%=nombre%></h1>
									                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
									
									                </div>
									                <div class="modal-body" style="padding:40px 80px 40px 80px ;">
									                    <ul class="list-group list-group-flush">
									                    	<%
									                    		if(!sociosEnClase.isEmpty()){
									                    		for(DtSocio H : sociosEnClase){
									                    	%>
									                        <li class="list-group-item"> <div style="display:flex ;"><div class="perfil-icono perfil-icono-chico" style="background-image: url('<%=H.getpfp()%>'), url('imagenes/defPerfil.png')"></div><div style="margin-top: auto; margin-bottom:auto"><%=H.getNickname()%></div></div></li>
									                    	<%
																}
									                    		}else{
															%>
																<p style="text-align: center">No tiene socios registrados.</p>
															<%} %>
									                    </ul>
									                </div>
									            </div>
									        </div>
									    </div> 
				  										
                                        <li class="list-group-item" style="text-align: center;font-size: 13px; color: rgb(165, 165, 165);">Registro: <%=registro%></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                        
						
						 
						     <%
						     	cont++;
    							//El for se cierra acá
								}
						
                    			}else{
							%>
							<p>No hay clases</p>
							<%} %>
                        </div>
						
                                </div>
                            </div>
                        </div>

  
<%@include file="/footer.jsp" %>

</body>

</html>