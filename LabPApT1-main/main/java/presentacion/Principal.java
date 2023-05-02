package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorActividadDeportiva;
import interfaces.IControladorInstitucionDep;
import interfaces.IControladorUsuario;
import interfaces.IControladorClase;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;

	private AltaDictadoDeClase altaDictadoDeClaseInF;

	private AltaInstitucionDep altaInstitucionDepInF;

	private AltaActividadDeportiva altaActividadDeportivaInF;

	private AltaUsuario altaUsuarioInF;

	private ConsultaUsuario consultaUsuarioInF;

	private ConsultaActividadDeportiva consultaActividadDepInF;
	
	private RegistroDictadoDeClase registroDictadoDeClaseInF;
	
	private ModificarDatosUsuario modificarDatosUsuarioInF;
	
	private ModificarActividadDeportiva modificarActividadDeportivaInf;
	
	private RankingActividadDeportiva rankingActividadDeportivaInF;
 
	private ModificarInstitucionDep modificarInstitucionDep;
	

	private RankingDictadoClases rankingDictadoClases;

	private ConsultaDictadoDeClase consultaDictadoDeClaseInF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		// indicializo icon
		Fabrica fabrica = Fabrica.getInstancia();
		IControladorClase iConClase = fabrica.getIControladorClase();
		IControladorInstitucionDep iConIntDep = fabrica.getIControladorInstitucionDep();
		IControladorActividadDeportiva iConActDep = fabrica.getIControladorActividadDeportiva();
		IControladorUsuario iConUser = fabrica.getIControladorUsuario();

		// crear una instancia de internal frame, ponerla en invisible y añadirla a
		// principal

		altaInstitucionDepInF = new AltaInstitucionDep(iConIntDep);
		altaInstitucionDepInF.setVisible(false);
		frame.getContentPane().add(altaInstitucionDepInF);

		altaUsuarioInF = new AltaUsuario(iConUser);
		altaUsuarioInF.setVisible(false);
		frame.getContentPane().add(altaUsuarioInF);

		consultaActividadDepInF = new ConsultaActividadDeportiva(iConActDep);
		consultaActividadDepInF.setVisible(false);
		frame.getContentPane().add(consultaActividadDepInF);

		consultaUsuarioInF = new ConsultaUsuario(iConUser);
		consultaUsuarioInF.setSize(450, 327);
		consultaUsuarioInF.setLocation(100, 100);
		consultaUsuarioInF.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInF);

		altaActividadDeportivaInF = new AltaActividadDeportiva(iConActDep);
		altaActividadDeportivaInF.setVisible(false);
		frame.getContentPane().add(altaActividadDeportivaInF);

		altaDictadoDeClaseInF = new AltaDictadoDeClase(iConClase);
		altaDictadoDeClaseInF.setVisible(false);
		frame.getContentPane().add(altaDictadoDeClaseInF);
		
		registroDictadoDeClaseInF = new RegistroDictadoDeClase(iConActDep);
		registroDictadoDeClaseInF.setVisible(false);
		frame.getContentPane().add(registroDictadoDeClaseInF);
		
		modificarDatosUsuarioInF = new ModificarDatosUsuario(iConUser);
		modificarDatosUsuarioInF.setVisible(false);
		frame.getContentPane().add(modificarDatosUsuarioInF);
		
		modificarActividadDeportivaInf = new ModificarActividadDeportiva(iConActDep);
		modificarActividadDeportivaInf.setVisible(false);
		frame.getContentPane().add(modificarActividadDeportivaInf);
		
		rankingActividadDeportivaInF = new RankingActividadDeportiva(iConActDep);
		rankingActividadDeportivaInF.setVisible(false);
		frame.getContentPane().add(rankingActividadDeportivaInF);

		modificarInstitucionDep = new ModificarInstitucionDep(iConIntDep);
		modificarInstitucionDep.setVisible(false);
		frame.getContentPane().add(modificarInstitucionDep);
		

		rankingDictadoClases = new RankingDictadoClases(iConClase);
		rankingDictadoClases.setVisible(false);
		frame.getContentPane().add(rankingDictadoClases);

		consultaDictadoDeClaseInF = new ConsultaDictadoDeClase(iConActDep);
		consultaDictadoDeClaseInF.setVisible(false);
		frame.getContentPane().add(consultaDictadoDeClaseInF);

		// fin crear instancia
		
		//cargaDatos(iConUser, iConIntDep, iConActDep, iConClase);//cargar datos de prueba
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Entrenamos UY - principal");

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);

		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioInF.inicializarComboBoxInstituciones();
				altaUsuarioInF.setVisible(true);
			}
		});
		mnUsuarios.add(mntmAltaUsuario);

		JMenuItem mntmConsultaUsuaro = new JMenuItem("Consulta Usuario");
		mntmConsultaUsuaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaUsuarioInF.setVisible(true);
				consultaUsuarioInF.inicializarLista();
				

			}
		});
		mnUsuarios.add(mntmConsultaUsuaro);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificarDatosUsuarioInF.hayUsuarios()) {
					modificarDatosUsuarioInF.inicializarComboBoxUsuarios();
					modificarDatosUsuarioInF.cargarDatosUsuario();
					modificarDatosUsuarioInF.setVisible(true);
				}
				
			}
		});
		mnUsuarios.add(mntmNewMenuItem);

		JMenu mnInstitucionesDeportivas = new JMenu("Instituciones Deportivas");
		menuBar.add(mnInstitucionesDeportivas);

		JMenuItem mntmAltaInstitucinDep = new JMenuItem("Alta institución dep.");
		mntmAltaInstitucinDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaInstitucionDepInF.setVisible(true);
			}
		});
		mnInstitucionesDeportivas.add(mntmAltaInstitucinDep);
		
		JMenuItem mntmModificarInsititucinDep = new JMenuItem("Modificar insititución Dep.");
		mntmModificarInsititucinDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarInstitucionDep.inicializarComboBoxInstituciones();
				modificarInstitucionDep.setVisible(true);
			}
		});
		mnInstitucionesDeportivas.add(mntmModificarInsititucinDep);

		JMenu mnActividadesDeportivas = new JMenu("Actividades Deportivas");
		menuBar.add(mnActividadesDeportivas);

		JMenuItem mntmAltaDeActividad = new JMenuItem("Alta de Actividad Deportiva");
		mntmAltaDeActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					altaActividadDeportivaInF.inicializarComboBoxInstituciones();
					altaActividadDeportivaInF.setVisible(true);
				}
			}
		});
		mnActividadesDeportivas.add(mntmAltaDeActividad);
		JMenu mnDictadoDeClases = new JMenu("Dictado de clases");
		menuBar.add(mnDictadoDeClases);

		JMenuItem mntmDictadoDeClases = new JMenuItem("Alta dictado de clase");
		mntmDictadoDeClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					altaDictadoDeClaseInF.inicializarComboBoxInstituciones();
					altaDictadoDeClaseInF.cambiarComboBoxActividadesDep();
					altaDictadoDeClaseInF.cambiarComboBoxProfesores();
					altaDictadoDeClaseInF.setVisible(true);
				}else {
					//JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
					//		JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		mnDictadoDeClases.add(mntmDictadoDeClases);
		
		JMenuItem mntmRegistroDictadoDeClase = new JMenuItem("Registro dictado de clase");
		mntmRegistroDictadoDeClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					registroDictadoDeClaseInF.inicializarComboBoxInstituciones();
					registroDictadoDeClaseInF.cambiarComboBoxActividadesDep();
					registroDictadoDeClaseInF.cambiarComboBoxClase();
					registroDictadoDeClaseInF.llenoSocios();
					registroDictadoDeClaseInF.setVisible(true);
				}
			}
		});
		
		
		mnDictadoDeClases.add(mntmRegistroDictadoDeClase);
		

		JMenuItem mntmRankingClases = new JMenuItem("Ranking de dicatos de clases");
		mntmRankingClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					rankingDictadoClases.llenarRanking();
					rankingDictadoClases.setVisible(true);			
					
				}
			}
		});
		mnDictadoDeClases.add(mntmRankingClases);

		JMenuItem mntmConsultaDictadoDeClase = new JMenuItem("Consulta dictado de clase");
		mntmConsultaDictadoDeClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					consultaDictadoDeClaseInF.inicializarComboBoxInstituciones();
					consultaDictadoDeClaseInF.cambiarComboBoxActividadesDep();
					consultaDictadoDeClaseInF.cambiarComboBoxClase();
					consultaDictadoDeClaseInF.setVisible(true);
				}
			}
		});
		mnDictadoDeClases.add(mntmConsultaDictadoDeClase);


		JMenuItem mntmConsultaActividadDep = new JMenuItem("Consulta Actividad Dep.");
		mntmConsultaActividadDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(altaDictadoDeClaseInF.hayInstituciones()) {
					consultaActividadDepInF.inicializarComboBoxInstituciones();
					consultaActividadDepInF.cambiarComboBoxActividadesDep();
					consultaActividadDepInF.cambiarComboBoxClase();
					consultaActividadDepInF.setVisible(true);
				}
			}
		});
		
		
		mnActividadesDeportivas.add(mntmConsultaActividadDep);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar Actividad Dep.");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modificarActividadDeportivaInf.hayActividadesDeportivas()) {
					modificarActividadDeportivaInf.inicializarComboBoxActDep();
					modificarActividadDeportivaInf.cargarDatosActDep();
					modificarActividadDeportivaInf.setVisible(true);
					
				}
			}
		});
		mnActividadesDeportivas.add(mntmNewMenuItem_1);
		
		JMenuItem mntmRankingDeActividades = new JMenuItem("Ranking de Actividades Dep.");
		mntmRankingDeActividades.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(modificarActividadDeportivaInf.hayActividadesDeportivas()) {
					rankingActividadDeportivaInF.inicializarLista2();
					rankingActividadDeportivaInF.setVisible(true);
				}
			}
		});
		mnActividadesDeportivas.add(mntmRankingDeActividades);

	}
	/*
	private void cargaDatos(IControladorUsuario iConUser, IControladorInstitucionDep iConIntDep, IControladorActividadDeportiva iConActDep, IControladorClase iConClase) {
		//CARGA USUARIOS
		try {
			iConUser.altaUsuario(new DtSocio("xXpepeXx", "Pedro", "Marti", "pepe@gmail.com", new DtFecha(1990,5,5), null));
			iConUser.altaUsuario(new DtSocio("superFranx", "Franco", "Moti", "franx@gmail.com", new DtFecha(1993,7,1), null));
			iConUser.altaUsuario(new DtSocio("xXjuanXx", "Juan", "pacos", "juan@gmail.com", new DtFecha(1999,10,6), null));
			iConUser.altaUsuario(new DtSocio("xXstaxXx", "Fran", "davil", "stax@gmail.com", new DtFecha(1995,1,10), null));
			iConUser.altaUsuario(new DtSocio("Marix", "Maria", "da Cruz", "maria@gmail.com", new DtFecha(1991,12,9), null));
			iConUser.altaUsuario(new DtSocio("Fionex", "Fiorella", "Benit", "fionez@gmail.com", new DtFecha(1990,10,5), null));
		} catch (UsuarioRepetidoEx | NoExisteInstitucionDepEx | FechaInvalidaEx e1) {
			e1.printStackTrace();
		}
		//CARGA INSTITUCIONES DEPORTIVAS
		try {
			iConIntDep.addInstitucionDep("institucion1", "primera institucion", "www://inst1.com");
			iConIntDep.addInstitucionDep("institucion2", "segunda institucion", "www://inst2.com");
			iConIntDep.addInstitucionDep("institucion3", "tercera institucion", "www://inst3.com");
			iConIntDep.addInstitucionDep("institucion4", "cuarta institucion", "www://inst4.com");
			iConIntDep.addInstitucionDep("institucion5", "", "");
		} catch (InstitucionDepRepetidaEx e) {
			e.printStackTrace();
		}
		//CARGA PROFESORES
		try {
			iConUser.altaUsuario(new DtProfesor("masterMaster", "Juan", "da cun", "majuda@gmail.com", new DtFecha(1980,5,5), "Muy extricto", "Alto", "", new DtInstitucionDeportiva("institucion3", "tercera institucion", "www://inst3.com"), null));
			iConUser.altaUsuario(new DtProfesor("ElPrrrofe", "Franco", "Rodriguez", "elrodir@gmail.com", new DtFecha(1975,1,7), "Muy bajito", "Bajo", "", new DtInstitucionDeportiva("institucion3", "tercera institucion", "www://inst3.com"), null));
			iConUser.altaUsuario(new DtProfesor("Carlax", "Carla", "Dianis", "carlax@gmail.com", new DtFecha(1981,3,1), "Puntual", "", "", new DtInstitucionDeportiva("institucion2", "segunda institucion", "www://inst2.com"), null));
		} catch (UsuarioRepetidoEx | NoExisteInstitucionDepEx | FechaInvalidaEx e1) {
			e1.printStackTrace();
		}
		//CARGA ACTIVIDADES DEPORTIVAS
		try {
			try {
				iConActDep.AltaActividadDeportiva("actividad1", "institucion2", "actividad divertida", 60, 500, new DtFecha(2019,12,14));
				iConActDep.AltaActividadDeportiva("actividad2", "institucion2", "actividad fugaz", 10, 100, new DtFecha(2022,9,9));
				iConActDep.AltaActividadDeportiva("actividad3", "institucion3", "actividad de larga duración", 180, 1500, new DtFecha(2022,1,10));
				iConActDep.AltaActividadDeportiva("actividad4", "institucion4", "", 30, 800, new DtFecha(2020,12,20));
				iConActDep.AltaActividadDeportiva("actividad5", "institucion3", "actividad variada", 60, 700, new DtFecha(2020,9,15));
				iConActDep.AltaActividadDeportiva("actividad6", "institucion2", "para mayores", 30, 300, new DtFecha(2019,7,10));
				iConActDep.AltaActividadDeportiva("actividad7", "institucion4", "Jovenes y niños", 60, 500, new DtFecha(2022,7,5));
				iConActDep.AltaActividadDeportiva("actividad8", "institucion2", "Alta resisencia", 60, 1000, new DtFecha(2021,4,5));
			} catch (FechaInvalidaEx e) {
				e.printStackTrace();
			}
		} catch (ActividadDepRepetidaEx e) {
			e.printStackTrace();
		}
		
		try {
			iConClase.addClase("actividad1", "Hora de divertirse", new DtFechaHora(2022,10,15,18,30,30), "Carlax", "www://clasevirtual1.com", new DtFecha(2022,9,15));
			iConClase.addClase("actividad3", "Hasta agotarnos", new DtFechaHora(2022,9,20,17,30,30), "ElPrrrofe", "www://clasevirtual2.com", new DtFecha(2022,9,14));
			iConClase.addClase("actividad5", "diversion y vaiedad", new DtFechaHora(2022,10,1,14,30,30), "masterMaster", "www://clasevirtual3.com", new DtFecha(2022,9,13));
			iConClase.addClase("actividad2", "a correr", new DtFechaHora(2022,9,28,15,30,30), "Carlax", "www://clasevirtual4.com", new DtFecha(2022,9,15));
		} catch (ClaseRepetidaEx | NoExistenUsuariosEx | HoraInvalidaEx | FechaInvalidaEx e) {
			e.printStackTrace();
		}
	}*/
}
