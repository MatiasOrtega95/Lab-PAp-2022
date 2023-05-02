<%@page import="interfaces.IControladorActividadDeportiva"%>
<%@page import="datatypes.DtActividadDeportiva"%>
<%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datatypes.DtProfesor"%>
<%@page import="datatypes.DtSocio"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="interfaces.IControladorUsuario"%>
<%@page import="interfaces.Fabrica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Perfil</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width" />
    
        
    <%@include file="/header.jsp" %>

</head>

<body>
<%
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorUsuario icon = fabrica.getIControladorUsuario();
	String nickname = (String)sesion2.getAttribute("nombreUsuario");
	DtUsuario dtu = icon.consultaUsuario(nickname);
	String urlimagen = dtu.getpfp();
	
	
	ArrayList<DtClase> clases = new ArrayList<DtClase>();
	if(dtu instanceof DtSocio){
		clases = ((DtSocio)dtu).getClases();
	}else if(dtu instanceof DtProfesor){
		clases = ((DtProfesor)dtu).getClases();
	}
	
%>

    <div class="contenedor-total">
        <div class="contenedor">
            <div class="contenedor2">
                <div id="flexPerfil" style="display:flex; flex-direction:row;">
                    <div id="imgPefil" class="perfil-icono perfil-icono-chico" style="width: 130px; height: 130px; background-image: url('<%=urlimagen%>'), url('imagenes/defPerfil.png')">
                         <%if(dtu instanceof DtSocio){ %>
                            <div class="icono-tipo-usr"data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Socio"data-bs-custom-class="custom-tooltip">
                                	S
                            </div>
                          <%}else{ %>
                                <div class="icono-tipo-usr"data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Profesor"data-bs-custom-class="custom-tooltip">
                                	P
                                </div>
                                <%} %>
                            
                    </div>
                    <div id="infoBasicaPerfil" style="margin-right:44px;">
                        
                        <div id="contDatosBasicos" style="width: 194px; margin: 0 auto;">
						    <ul style="display: block; overflow: auto; white-space: nowrap; border-bottom: 0; padding-left: 0;">
						   	 	<h1><%=dtu.getNickname()%></h1>
		                        <div>
		                            <p style="padding-left: 8px;font-size: 17px; margin-bottom: 0;"><%=dtu.getNombre()%> <%=dtu.getApellido()%></p>
		                            <div style="display:flex;">
		                                <img src="vector/email.svg" style="width: 23px;margin-left: 8px;" alt=""data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Email"data-bs-custom-class="custom-tooltip" >
		                                <p style="padding-left: 8px;font-size: 17px; margin-bottom: 0;"><%=dtu.getEmail() %></p>
		                            </div>
		
		                        </div>
                       		</ul>
                        </div>

                    </div>
                    <div id="infoEspecificaPerfil" style="border-left: 3px solid #FF9B55; margin-top: auto; margin-bottom: auto; padding-left: 30px; flex-grow: 4;">
                        <div id="botonEditarPerfil" style="display:flex ;flex-direction:row-reverse;position: relative; top: -30px; right: -20px;">
                            <a class="btn btn-primary btn-lg boton2 small" href="ModificarDatosUsuario.jsp">Editar Perfil</a>
                        </div>


                        <div>
                            <div style="display:flex; ">
                                <img src="vector/FechaNac.svg" style="width: 23px;margin-left: 8px;" alt="" data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Fecha de nacimiento"data-bs-custom-class="custom-tooltip">
                                <p style="padding-left: 8px;font-size: 17px; margin-bottom: 0; overflow-wrap: anywhere;"><%=dtu.getFecha() %></p>
                            </div>
                            <%if(dtu instanceof DtProfesor){ %>
	                            <div style="display:flex;">
	                                <img src="vector/institucion.svg" style="width: 23px;margin-left: 8px;" alt="" data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Institucion"data-bs-custom-class="custom-tooltip">
	                                <p style="padding-left: 8px;font-size: 17px; margin-bottom: 0; overflow-wrap: anywhere;"><%=((DtProfesor)dtu).getInstitucion().getNombre()%></p>
	                            </div>
	                            <%if(!((DtProfesor)dtu).getSitioWeb().equals("")){ %>
	                            <div style="display:flex;">
	                                <img src="vector/sitioWeb.svg" style="width: 23px;margin-left: 8px;" alt="" data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Sitio web"data-bs-custom-class="custom-tooltip">
	                                <p style="padding-left: 8px;font-size: 17px; margin-bottom: 0; overflow-wrap: anywhere;"><%=((DtProfesor)dtu).getSitioWeb()%></p>
	                            </div>
	                            <%} %>
                            <%} %>
                        </div>


                    </div>
                </div>
                <hr class="dashed"> <br> 
                <%if(dtu instanceof DtProfesor){ %>
	                
	                <p><%=((DtProfesor)dtu).getDescripcion()%></p>
	
	                <br>
	                <%if(!((DtProfesor)dtu).getBiografia().equals("")){ %>
	                <div style="display:flex ;">
	                    <p id="headingPerfil" style="margin:auto ; padding-right:19px ; font-size: 30px;">Biografía</p>
	                    <hr class="dashed col" style="margin-top: 23px;">
	                </div> <br>
	                <p><%=((DtProfesor)dtu).getBiografia()%></p>
	                <%} %>
	            <%} %>
                <div style="display:flex ;">
                    <p id="headingPerfil" style="margin:auto ; padding-right:19px ; font-size: 30px;">Mis clases</p>
                    <%if(dtu instanceof DtProfesor){ %>
                    	<hr class="dashed col" style="margin-top: 23px;">
                    <%}else{ %>
                    	<hr class="dashed col" style="margin-top: 23px; opacity: 0;">
                    <%} %>
                </div> <br> <br>
                
                
                <div id="listaPC">
	                
	                <%if(clases.isEmpty()){ %>
	                	<p style="text-align:center ">No tiene clases.</p>
	                	<br> <br>
	                <%}else{ %>
	                <div id="carouselExampleControls" style="width: 828px ; margin-left: auto;margin-right: auto;" class="carousel slide" data-bs-ride="carousel">
	                    <div class="carousel-inner">
	                    
	                    	<%
	                    	int i = 1;
	                    	boolean primeraVez = true;
	                    	for(DtClase c : clases){%>
	                    		
	                    		<%if(i == 1){ %>
		                    		<div class="carousel-item <%if(primeraVez){%>active<%}%>"data-bs-interval="100000000000000">
		                            <div style="display:flex; column-gap: 30px;">
	                    		<%}%>
	                    	
					        	<div class="card custom-card" style="width: 16rem; margin-bottom: 30px;">
	                            	<img style="height: 200px; object-fit:cover;"src="<%=c.getPicture()%>" onerror="this.onerror=null; this.src='imagenes/defClase.png'" class="card-img-top" alt="...">
	                            	<h5 class="card-title custom-card-title"><%=c.getNombre()%></h5>
	                            	<form action="RegistroDictadoClase" method="post">
	                            		<input type="hidden" name="clase" id="clase" value="<%=c.getNombre() %>">
		                            	<div class="card-body" style="padding-top:0; padding-bottom: 0;">
			                            	<ul class="list-group list-group-flush">
			                                	<li class="list-group-item"> <a class="card-text p-small" style="display: block; width:fit-content;margin:auto; color: #ee8f4c; padding-bottom: 8px;" href="https://www.google.com"><%=c.getUrl()%></a></li>
			                                	<li class="list-group-item" style="text-align: center;"><%=c.getFechaInicio()%></li>
												
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
	                  
	                  <%} %>
	                  
                  </div>
                  <div id="listaMovil" style="display: none;">
	                  	<%if(!clases.isEmpty()){ %>
	                 	<div id="nav-wrapper">
						    <ul class="nav nav-tabs">
						    
								<%for(DtClase c : clases){ %>
						    	
						        <li><div id="contCarta">
									<div class="card custom-card" style="width: 16rem;">
                            	<img style="height: 200px; object-fit:cover;"src="<%=c.getPicture()%>" onerror="this.onerror=null; this.src='imagenes/defClase.png'" class="card-img-top" alt="...">
                            	<h5 class="card-title custom-card-title"><%=c.getNombre()%></h5>
                            	<form action="RegistroDictadoClase" method="post">
                            		<input type="hidden" name="clase" id="clase" value="<%=c.getNombre() %>">
	                            	<div class="card-body" style="padding-top:0; padding-bottom: 0;">
		                            	<ul class="list-group list-group-flush">
		                                	<li class="list-group-item"> <a class="card-text p-small" style="display: block; width:fit-content;margin:auto; color: #ee8f4c; padding-bottom: 8px;" href="https://www.google.com"><%=c.getUrl()%></a></li>
		                                	<li class="list-group-item" style="text-align: center;"><%=c.getFechaInicio()%></li>
											
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
	                  		<p style="text-align: center">No tiene clases.</p>
	                  <%} %>
	                  
                  </div>
                  
                  
                  
                  
                  
                  
                  
                  <div id="flexActividad" style="display:flex ;">
                    <p id="headingPerfil" style="margin:auto ; padding-right:19px ; font-size: 30px;">Mis actividades deportivas</p>
                    <hr class="dashed col" style="margin-top: 23px;">
                </div> <br> <br>
                <%
                IControladorActividadDeportiva iconA = fabrica.getIControladorActividadDeportiva();
                ArrayList<String> actividades = iconA.getActividadesDeportivas();
                ArrayList<DtActividadDeportiva> actividadesUsuario = new ArrayList<DtActividadDeportiva>();
                boolean encontro;
                for(String a : actividades){ 
                	encontro = false;
                	for(DtClase c : clases){
                		if(a.equals(c.getActDep()) && !encontro){
                    		actividadesUsuario.add(iconA.ConsultaActividadDeportiva(a));
                    		encontro = true;
                    	}
                	}
                	
                	
                }%>
                
                
                
                <div id="listaPC">
                
	                <%if(actividadesUsuario.isEmpty()){ %>
	                	<p style="text-align:center ">No tiene actividades.</p>
	                	<br> <br>
	                <%}else{ %>
	                
	                <div id="carouselExampleControls2" style="width: 828px ; margin-left: auto;margin-right: auto;" class="carousel slide" data-bs-ride="carousel">
	                    <div class="carousel-inner">
	                    
	                    
	                    
	                    
	                    	<%
	                    	int i2 = 1;
	                    	boolean primeraVez2 = true;
	                    	int cont = 0;
	                    	for(DtActividadDeportiva a : actividadesUsuario){%>
	                    		
	                    		<%if(i2 == 1){ %>
		                    		<div class="carousel-item <%if(primeraVez2){%>active<%}%>"data-bs-interval="100000000000000">
		                            <div style="display:flex; column-gap: 30px;">
	                    		<%}%>
	                    	
					        	
					        	
					        	
					        	
					        	
					        	<div class="card custom-card" style="width: 16rem; margin-bottom: 30px;">
									<img style="height: 200px; object-fit: cover;" src="<%=a.getPicture() %>" onerror="this.onerror=null; this.src='imagenes/defActDep.png'" class="card-img-top" alt="...">
									<h5 class="card-title custom-card-title"><%=a.getNombre()%></h5>
									<div class="card-body">
										<ul class="list-group list-group-flush">
											<li class="list-group-item" style="padding-top: 0;">
												<p class="card-text p-small" style="text-align: center; margin-bottom: 10px;"><%=a.getDescripcion()%></p>
											</li>
											<button type="button" class="btn btn-primary btn-lg boton2 small" data-bs-toggle="modal" data-bs-target="#modalClases<%=cont%>" data-actividad="<%=a.getNombre()%>">Ver clases</button>
	
											<!-- inicio Modal -->
											<div class="modal fade" id="modalClases<%=cont%>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog modal-xl">
													<div class="modal-content">
														<div class="modal-header">
															<h1 class="modal-title fs-5" id="titulo"><%=a.getNombre()%></h1>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body"
															style="padding: 40px 80px 40px 80px;">
															<div style="display: grid;">
																<div class="row">
																	<%
																	for (DtClase dtc : a.getClases()) {
																	%>
																	<div class="col">
																		<div class="card custom-card"
																			style="width: 16rem; margin-bottom: 30px;">
																			<img style="height: 200px; object-fit: cover;"
																				src="<%=dtc.getPicture() %>" onerror="this.onerror=null; this.src='imagenes/defClase.png'"
																				class="card-img-top" alt="...">
																			<h5 class="card-title custom-card-title"><%=dtc.getNombre()%></h5>
																			<div class="card-body"
																				style="padding-top: 0; padding-bottom: 0;">
																				<ul class="list-group list-group-flush">
																					<li class="list-group-item"><a
																						class="card-text p-small"
																						style="display: block; width: fit-content; margin: auto; color: #ee8f4c; padding-bottom: 8px;"
																						href="<%=dtc.getUrl()%>"><%=dtc.getUrl()%></a></li>
																					<li class="list-group-item"
																						style="text-align: center;"><%=dtc.getFechaInicio()%></li>
																					<li class="list-group-item"
																						style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">Registro: <%=dtc.getFechaReg()%></li>
																					<li class="list-group-item" style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">
																						<a href="ConsultaDictadoClase.jsp" style="color: #ee8f4c; ">Ver más información</a> <!-- Completar CU  Consulta de Dictado de Clase -->
																					</li>
																				</ul>
																			</div>
																		</div>
																	</div>
																	<%
																	}
																	%>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<!-- fin modal -->
	
											<li class="list-group-item"
												style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">Registro:
												<%=a.getFechaReg()%></li>
										</ul>
										<div class="container">
											<div class="row">
												<div class="col" style="text-align: left; padding: 0;">
													<p class="p-small" style="margin: 0; margin-top: 0px;"><%=a.getDuracion()%>
														hrs
													</p>
												</div>
	
												<div class="col" style="text-align: right; padding: 0;">
													<p class="p-small" style="margin: 0; margin-top: 0px;">
														$<%=a.getCosto()%></p>
												</div>
											</div>
										</div>
									</div>
								</div>
					        	
					        	
					        	
					        	
					        	
					        	
	                        	
	                        	<%if(i2 == 3){ %>
			                        </div>
			                        </div>
	                    		<%}%>
	
	                                     	
					        <%
					        i2++;
					        if(i2 > 3){
					        	i2 = 1;
					        }
					        primeraVez2 = false;
					        cont++;
	                    	}
	                    	
	                    	if(i2 != 1){%>
	                    		</div>
			                    </div>
	                    	<%}%>
	                    	
	                    	
	                        
	                    
	                    
	                        
	                        
	                        
	                        
	                    </div>
	                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="prev" style="width: 4px;">
	                        <div style="background-color:#ee8f4c ; position: relative; right: 40px; padding: 5px; padding-right: 7px; border-radius: 50%;">
	                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                        </div>
	                      <span class="visually-hidden">Previous</span>
	                    </button>
	                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="next" style="width: 4px;">
	                        <div style="background-color:#ee8f4c ; position: relative; right: -40px; padding: 5px; padding-left: 7px; border-radius: 50%;">
	                            <span class="carousel-control-next-icon" aria-hidden="true" ></span>
	
	                        </div>
	                      <span class="visually-hidden">Next</span>
	                    </button>
	                  </div>
	                  <%} %>
	                  
                  </div>
                  
                  <div id="listaMovil" style="display: none;">
	                  	<%if(!actividadesUsuario.isEmpty()){ %>
	                 	<div id="nav-wrapper">
						    <ul class="nav nav-tabs">
						    
								<%
								int cont2 = 1;
								for(DtActividadDeportiva a : actividadesUsuario){ %>
						    	
						        <li><div id="contCarta">
									

									<div class="card custom-card" style="width: 16rem; margin-bottom: 30px;">
								<img style="height: 200px; object-fit: cover;" src="<%=a.getPicture() %>" onerror="this.onerror=null; this.src='imagenes/defActDep.png'" class="card-img-top" alt="...">
								<h5 class="card-title custom-card-title"><%=a.getNombre()%></h5>
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item" style="padding-top: 0;">
											<p class="card-text p-small" style="text-align: center; margin-bottom: 10px;"><%=a.getDescripcion()%></p>
										</li>
										<button type="button" class="btn btn-primary btn-lg boton2 small" data-bs-toggle="modal" data-bs-target="#modalClases<%=cont2%>B" data-actividad="<%=a.getNombre()%>">Ver clases</button>

										<!-- inicio Modal -->
										<div class="modal fade" id="modalClases<%=cont2%>B" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog modal-xl">
												<div class="modal-content">
													<div class="modal-header">
														<h1 class="modal-title fs-5" style="color: black;" id="titulo"><%=a.getNombre()%></h1>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body"
														style="padding: 40px 80px 40px 80px;">
														<div style="display: grid;">
															<div class="row">
																<%
																for (DtClase dtc : a.getClases()) {
																%>
																<div class="col">
																	<div class="card custom-card"
																		style="width: 16rem; margin-bottom: 30px;">
																		<img style="height: 200px; object-fit: cover;"
																			src="<%=dtc.getPicture() %>" onerror="this.onerror=null; this.src='imagenes/defClase.png'"
																			class="card-img-top" alt="...">
																		<h5 class="card-title custom-card-title"><%=dtc.getNombre()%></h5>
																		<div class="card-body"
																			style="padding-top: 0; padding-bottom: 0;">
																			<ul class="list-group list-group-flush">
																				<li class="list-group-item"><a
																					class="card-text p-small"
																					style="display: block; width: fit-content; margin: auto; color: #ee8f4c; padding-bottom: 8px;"
																					href="<%=dtc.getUrl()%>"><%=dtc.getUrl()%></a></li>
																				<li class="list-group-item"
																					style="text-align: center;"><%=dtc.getFechaInicio()%></li>
																				<li class="list-group-item"
																					style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">Registro: <%=dtc.getFechaReg()%></li>
																				<li class="list-group-item" style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">
																					<a href="ConsultaDictadoClase.jsp" style="color: #ee8f4c; ">Ver más información</a> <!-- Completar CU  Consulta de Dictado de Clase -->
																				</li>
																			</ul>
																		</div>
																	</div>
																</div>
																<%
																}
																%>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- fin modal -->

										<li class="list-group-item"
											style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">Registro:
											<%=a.getFechaReg()%></li>
									</ul>
									<div class="container">
										<div class="row">
											<div class="col" style="text-align: left; padding: 0;">
												<p class="p-small" style="margin: 0; margin-top: 0px;"><%=a.getDuracion()%>
													hrs
												</p>
											</div>

											<div class="col" style="text-align: right; padding: 0;">
												<p class="p-small" style="margin: 0; margin-top: 0px;">
													$<%=a.getCosto()%></p>
											</div>
										</div>
									</div>
								</div>
							</div>



								</div> </li>
						        
						        <%
						        cont2++;
								}%>
	
						    </ul>
						</div>
	                  
	                  	<% }else{%>
	                  		<p style="text-align: center">No tiene actividades.</p>
	                  <%} %>
	                  
                  </div>
                  
                  
                  
                  
            </div>
        </div>

    </div>




<%@include file="/footer.jsp" %>
</body>

</html>