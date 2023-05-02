<script src="bootstrap/javascript/bootstrap.bundle.min.js"></script>

<script>
    const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
    const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))
</script>
<!-- 


 -->


<script>
function mostrarNotificacion() {

	<% 
	HttpSession sesion3 = request.getSession();
	String mensaje = (String)sesion3.getAttribute("mensaje");
	%>

	<%
	if(mensaje != null){
	%>


		alert('<%=mensaje%>');
		
		

	<%}%>
	<% 
	sesion3.setAttribute("mensaje", null);
	%>


}

</script>

	<% 
	HttpSession sesion4 = request.getSession();
	String mensaje2 = (String)sesion4.getAttribute("mensajeError");
	%>
    
<div class="alert alert-danger alert-dismissible fade show sticky-bottom hide" id="alertId" role="alert">
	<img src="vector/exclamacion.svg" alt="" style="height:20px; margin-right:20px; margin-left:6px" >
	<%=mensaje2 %>
  	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<script>
function mostrarNotificacionError() {
	<%if(mensaje2 != null){%>
	document.getElementById('alertId').classList.remove('hide');
	<% 
	sesion4.setAttribute("mensajeError", null);
	}
	%>
}
</script>
	
