package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DtFecha;
import datatypes.DtFechaHora;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.FechaInvalidaEx;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		 

		/*RequestDispatcher rd;
		request.setAttribute("mensaje", "Se han modificado los datos");
		rd = request.getRequestDispatcher("/notificacion.jsp"); 
		rd.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	       String nombre = request.getParameter("nomUsuario");
	        String apellido = request.getParameter("apellidoUsuario");
	        String fecha = request.getParameter("fecNacimiento");
	        String nick = request.getParameter("nickUsuario");
	        String img = request.getParameter("imagen");
	        String email = request.getParameter("mailUsuario");
	        String pass = request.getParameter("passUsuario");

	       // String[] values = reqFecha.split("-");

	       // Integer day = Integer.parseInt(values[0]);
	      //  Integer month = Integer.parseInt(values[1]);
	      //  Integer year = Integer.parseInt(values[2]);
	        
	        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			Calendar gc= new GregorianCalendar();
			try {
				gc.setTime(sdf.parse(fecha));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			DtFecha fechaNac = new DtFecha(gc);
	        
	        
	 
	        Fabrica fabrica = Fabrica.getInstancia();
	        IControladorUsuario icon = fabrica.getIControladorUsuario();
	        DtUsuario dtu = icon.consultaUsuario(nick);

	        if(dtu instanceof DtProfesor){
	            String desc = request.getParameter("descProf");
	            String bio = request.getParameter("bioProf");
	            String url = request.getParameter("urlProf");

	            DtProfesor dtp = new DtProfesor(nick, nombre, apellido, email, pass, img, fechaNac,desc,bio,url,null,null);
	            icon.modificarUsuario((DtUsuario)dtp);
	        }
	        else{
	            DtSocio dts = new DtSocio(nick, nombre, apellido, email, pass, img, fechaNac, null);
	            icon.modificarUsuario((DtUsuario)dts);
	        }
	      
	        HttpSession sesion = request.getSession();
	        sesion.setAttribute("mensaje", "Se modificaron correctamente los datos del usuario " + nick);
	        response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
