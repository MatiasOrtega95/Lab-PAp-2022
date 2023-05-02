<link rel="stylesheet" href="styles.css" />

<link rel="stylesheet" href="bootstrap/bootstrap.min.css">

<link rel="stylesheet" href="bootstrap/docs.css">

<% 
HttpSession sesion2 = request.getSession();
String tipoUsuario = (String)sesion2.getAttribute("tipoUsuario");

if(tipoUsuario == null){
	tipoUsuario = "Visitante";
}
%>

    <nav class="navbar sticky-top navbar-expand-lg bg-light" style="box-shadow: 0px 4px 4px rgba(75, 7, 7, 0.39);">
        <div class="container-fluid" style="padding-left: 28px; padding-right: 0;">
            <div style="order: 1">
                <button class="navbar-toggler" style="border: none;padding: 0;background: none; margin-right: 28px;" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="index.jsp" ><img id="imgLogo" style="height: 30px;" src="imagenes/logo.png" alt="logo"></a>
            </div>
            	
    

                <div class="btn-group dropstart" style="order: 4" id="perfilIc">   
                    <button class="btn dropdown-toggle" style="padding: 0;" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="imagenes/perfil.png" class="iconoPerfil" style="filter: drop-shadow(3px 5px 2px #7a14143d);" alt="perfil">
                    </button>
                    <ul class="dropdown-menu">
                    	<%if(!tipoUsuario.equals("Visitante")){ %> 
                        <li><a class="dropdown-item" href="ConsultaUsuario.jsp">Ver perfil</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <%} %>
                        <%if(tipoUsuario.equals("Visitante")){ %> 
                        <li><a class="dropdown-item" href="IniciarSesion.jsp">Iniciar sesion</a></li>
                        <li><a class="dropdown-item disabled" href="#">Crear cuenta</a></li>
                        <%} %>
                        <%if(!tipoUsuario.equals("Visitante")){ %> 
                        <li>
                        <form action="CerrarSesion" method="post">
					    	<input class="dropdown-item" type="submit" name="cerrarSesion" value="Cerrar Sesion" />
						</form>
                        </li>
                        <%} %>
                    </ul>              
                </div>
                
                <%if(!tipoUsuario.equals("Visitante")){ %> 
                <div class="collapse navbar-collapse" id="navbarNav" style="order: 3">
                    <ul class="navbar-nav">
                    	
                        <li class="nav-item"><a class="nav-link" aria-current="page" href="ConsultaActividadDeportiva.jsp">Actividades Deportivas</a></li>
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Clases</a> <!-- aaaa -->
                            <ul class="dropdown-menu">
                            	<%if(tipoUsuario.equals("Profesor")){ %> 
                                <li><a class="dropdown-item" href="ConsultaDictadoClase.jsp">Ver clases</a></li>
                                <li><a class="dropdown-item" href="AltaDictadoClase.jsp">Nueva clase</a></li>
                                <%} %>
                                <%if(tipoUsuario.equals("Socio")){ %> 
                                <li><a class="dropdown-item" href="RegistroDictadoClase.jsp">Registrarse a una clase</a></li>
                                <%} %>
                                </ul>
                        </li>
                    </ul>
                </div>
                <%} %>

        </div>
    </nav>

