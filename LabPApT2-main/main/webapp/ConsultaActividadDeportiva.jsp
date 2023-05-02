<%@page import="datatypes.DtFecha"%>
<%@page import="java.util.ArrayList"%>
<%@page import="interfaces.IControladorActividadDeportiva"%>
<%@page import="interfaces.Fabrica"%>
<%@page import="datatypes.DtActividadDeportiva"%>
<%@page import="datatypes.DtClase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>Actividades Deportivas</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width" />


<%@include file="/header.jsp"%>


</head>

<body>

	<%
	Fabrica fabrica = Fabrica.getInstancia();
	IControladorActividadDeportiva icon = fabrica.getIControladorActividadDeportiva();
	ArrayList<String> actividades = icon.getActividadesDeportivas();
	ArrayList<DtActividadDeportiva> dtActividades = new ArrayList<DtActividadDeportiva>();
	for (String a : actividades) {
		dtActividades.add(icon.getDtActividadDeportiva(a));
	}

	DtActividadDeportiva actividadActiva = null;
	String ranking = request.getParameter("ranking");
	if(ranking != null){
		dtActividades = icon.rankingActividadesDeportivas();
	}
	%>
	
	

	<div class="contenedor-total">

		<div class="contenedor">


			<div class="contenedor2">
				<div class="row" id="rowTitulo">
					<hr class="dashed col" id="dashtop">
					<h1 class="col" id="tituloPantalla"
						style="font-size: 50px; letter-spacing: 2px; text-shadow: 0px 3px #b34d1d; color: #FF9B55; text-align: center;">
						Actividades&nbspDeportivas</h1>
					<hr class="dashed col" id="dashbottom">
				</div>
				<%if(tipoUsuario.equals("Profesor")){ %>
				
				<div id="rankingFlex" style="display: flex; justify-content: right; align-items: right;">
					<form method="post">
						<input type="hidden" name="ranking" id="ranking" value="ranking">
						<button type="submit"
							class="btn btn-primary btn-lg boton2 small ranking"
							data-bs-toggle="tooltip" data-bs-placement="bottom"
							data-bs-title="Ordenar por no. de clases"
							data-bs-custom-class="custom-tooltip">
							<img class="img-ranking" src="vector/ranking.svg"
								style="width: 34px;">
							<p id="rankingTexto" style="display: none">Ordenar por número de clases</p>
						</button>
					</form>
				</div>
				<%} %>
				<br> <br>
				<div style="display: grid;">
					<div class="row">
						<%
						int cont = 1;
						for (DtActividadDeportiva a : dtActividades) {
							String nombre = a.getNombre();
							String descripcion = a.getDescripcion();
							Float costo = a.getCosto();
							int duracion = a.getDuracion();
							DtFecha registro = a.getFechaReg();
						%>
						<div class="col">
							<div class="card custom-card" id="cartaVertical" style="width: 16rem; margin-bottom: 30px;">
								<img style="height: 200px; object-fit: cover;" src="<%=a.getPicture() %>" onerror="this.onerror=null; this.src='imagenes/defActDep.png'" class="card-img-top" alt="...">
								<h5 class="card-title custom-card-title"><%=nombre%></h5>
								<div class="card-body">
									<ul class="list-group list-group-flush">
										<li class="list-group-item" style="padding-top: 0;">
											<p class="card-text p-small" style="text-align: center; margin-bottom: 10px;"><%=descripcion%></p>
										</li>
										<button type="button" class="btn btn-primary btn-lg boton2 small" data-bs-toggle="modal" data-bs-target="#modalClases<%=cont%>" data-actividad="<%=nombre%>">Ver clases</button>

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
																if(!a.getClases().isEmpty()){
																
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
																					href="http://<%=dtc.getUrl()%>"><%=dtc.getUrl()%></a></li>
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
																}else{
																%>
																	<p style="text-align: center">No tiene clases.</p>
																<%} %>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!-- fin modal -->

										<li class="list-group-item"
											style="text-align: center; font-size: 13px; color: rgb(165, 165, 165);">Registro:
											<%=registro%></li>
									</ul>
									<div class="container">
										<div class="row">
											<div class="col" style="text-align: left; padding: 0;">
												<p class="p-small" style="margin: 0; margin-top: 0px;"><%=duracion%>
													hrs
												</p>
											</div>

											<div class="col" style="text-align: right; padding: 0;">
												<p class="p-small" style="margin: 0; margin-top: 0px;">
													$<%=costo%></p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<%
						cont++;
						}
						%>

					</div>
				</div>

			</div>






		</div>

	</div>






	<%@include file="/footer.jsp"%>
</body>

</html>