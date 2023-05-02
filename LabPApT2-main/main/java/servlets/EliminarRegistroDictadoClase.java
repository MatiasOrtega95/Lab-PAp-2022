package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtUsuario;
import excepciones.RegistroRepetidoEx;
import interfaces.Fabrica;
import interfaces.IControladorActividadDeportiva;
import interfaces.IControladorUsuario;

/**
 * Servlet implementation class EliminarRegistroDictadoClase
 */
@WebServlet("/EliminarRegistroDictadoClase")
public class EliminarRegistroDictadoClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRegistroDictadoClase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clase = request.getParameter("clase");
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorActividadDeportiva icon = fabrica.getIControladorActividadDeportiva();
		HttpSession sesion = request.getSession();
		String socio = (String)sesion.getAttribute("nombreUsuario");
		
		try {
			icon.eliminarRegistro(socio, clase);
			sesion.setAttribute("mensaje", "Registro eliminado exitosamente");
		} catch (RegistroRepetidoEx e) {
			throw new ServletException(e.getMessage());
		}
		
		response.sendRedirect(request.getContextPath() + "/ModificarDatosUsuario.jsp");
	}

}
