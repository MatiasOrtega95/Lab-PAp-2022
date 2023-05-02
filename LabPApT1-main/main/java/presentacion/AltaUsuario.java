package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.FechaInvalidaEx;
import excepciones.NoExisteInstitucionDepEx;
import excepciones.NoExistenUsuariosEx;
import excepciones.UsuarioRepetidoEx;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interfaces.IControladorUsuario;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import datatypes.DtFecha;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import datatypes.DtClase;

import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class AltaUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icon;//

	private JTextField txtNickname;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtSitioWeb;
	private JTextArea txtrBiografia;
	private JTextArea txtrDescripcion;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
	private JLabel lblFechaDeNacimiento;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAnio;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAnio;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JComboBox<String> comInst;
	private JLabel lblInstitucion;
	private JTextField txtContrasea;
	private JTextField txtImagenDePerfil;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { AltaInstitucionDep frame = new
	 * AltaInstitucionDep(icon); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 * 
	 * 
	 * Create the frame.
	 */

	public AltaUsuario(IControladorUsuario iCU) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		//
		this.icon = iCU;
		setResizable(false);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar un Usuario");
		setBounds(100, 100, 482, 351);
		getContentPane().setLayout(null);
		//
		txtNickname = new JTextField();
		txtNickname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNickname.getText().equals("")) {
					txtNickname.setForeground(Color.GRAY);
					txtNickname.setText("Nickname");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtNickname.getForeground().equals(Color.GRAY)) // si esta en gris, basicamente esta vacio
					txtNickname.setText("");
				txtNickname.setForeground(Color.black);
			}
		});
		txtNickname.setForeground(Color.GRAY);
		txtNickname.setText("Nickname");
		txtNickname.setBounds(24, 10, 164, 20);
		getContentPane().add(txtNickname);
		txtNickname.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNombre.getText().equals("")) {
					txtNombre.setForeground(Color.GRAY);
					txtNombre.setText("Nombre");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtNombre.getForeground().equals(Color.GRAY)) 
					txtNombre.setText("");
				txtNombre.setForeground(Color.black);
			}
		});
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBounds(24, 41, 164, 20);
		getContentPane().add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtApellido.getText().equals("")) {
					txtApellido.setForeground(Color.GRAY);
					txtApellido.setText("Apellido");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtApellido.getForeground().equals(Color.GRAY)) 
					txtApellido.setText("");
				txtApellido.setForeground(Color.black);
			}
		});
		txtApellido.setText("Apellido");
		txtApellido.setForeground(Color.GRAY);
		txtApellido.setColumns(10);
		txtApellido.setBounds(24, 72, 164, 20);
		getContentPane().add(txtApellido);

		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setForeground(Color.GRAY);
					txtEmail.setText("Email");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getForeground().equals(Color.GRAY)) 
					txtEmail.setText("");
				txtEmail.setForeground(Color.black);
			}
		});
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(24, 103, 164, 20);
		getContentPane().add(txtEmail);

		txtSitioWeb = new JTextField();
		txtSitioWeb.setEnabled(false);
		txtSitioWeb.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSitioWeb.getText().equals("")) {
					txtSitioWeb.setForeground(Color.GRAY);
					txtSitioWeb.setText("Sitio web (opcional)");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtSitioWeb.getForeground().equals(Color.GRAY)) 
					txtSitioWeb.setText("");
				txtSitioWeb.setForeground(Color.black);
			}
		});
		
		txtContrasea = new JTextField();
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtContrasea.getText().equals("")) {
					txtContrasea.setForeground(Color.GRAY);
					txtContrasea.setText("Contraseña");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtContrasea.getForeground().equals(Color.GRAY)) 
					txtContrasea.setText("");
				txtContrasea.setForeground(Color.black);
			}
		});
		txtContrasea.setForeground(Color.GRAY);
		txtContrasea.setText("Contraseña");
		txtContrasea.setBounds(24, 135, 164, 18);
		getContentPane().add(txtContrasea);
		
		
		
		txtContrasea.setColumns(10);
		txtSitioWeb.setText("Sitio web (opcional)");
		txtSitioWeb.setForeground(Color.GRAY);
		txtSitioWeb.setColumns(10);
		txtSitioWeb.setBounds(246, 111, 164, 20);
		getContentPane().add(txtSitioWeb);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 142, 164, 50);
		getContentPane().add(scrollPane);
		
				txtrBiografia = new JTextArea();
				scrollPane.setViewportView(txtrBiografia);
				txtrBiografia.setLineWrap(true);
				txtrBiografia.setEnabled(false);
				txtrBiografia.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						if (txtrBiografia.getText().equals("")) {
							txtrBiografia.setForeground(Color.GRAY);
							txtrBiografia.setText("Biografia (opcional)");
						}
					}

					@Override
					public void focusGained(FocusEvent e) {
						if (txtrBiografia.getForeground().equals(Color.GRAY)) 
							txtrBiografia.setText("");
						txtrBiografia.setForeground(Color.black);
					}
				});
		txtrBiografia.setColumns(10);
		txtrBiografia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrBiografia.setText("Biografia (opcional)");
		txtrBiografia.setForeground(Color.GRAY);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 250, 277, 50);
		getContentPane().add(scrollPane_1);
		
				txtrDescripcion = new JTextArea();
				scrollPane_1.setViewportView(txtrDescripcion);
				txtrDescripcion.setLineWrap(true);
				txtrDescripcion.setEnabled(false);
				txtrDescripcion.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						if (txtrDescripcion.getText().equals("")) {
							txtrDescripcion.setForeground(Color.GRAY);
							txtrDescripcion.setText("Descripcion");
						}
					}

					@Override
					public void focusGained(FocusEvent e) {
						if (txtrDescripcion.getForeground().equals(Color.GRAY))
							txtrDescripcion.setText("");
						txtrDescripcion.setForeground(Color.black);
					}
				});
		txtrDescripcion.setText("Descripcion");
		txtrDescripcion.setForeground(Color.GRAY);
		txtrDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrDescripcion.setColumns(10);

		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				//txtInstitucion.setEnabled(false);
				comInst.setEnabled(false);
				lblInstitucion.setForeground(Color.LIGHT_GRAY);
				txtrDescripcion.setEnabled(false);
				txtrBiografia.setEnabled(false);
				txtSitioWeb.setEnabled(false);

			}
		});
		rdbtnSocio.setSelected(true);
		rdbtnSocio.setBounds(246, 22, 67, 23);
		getContentPane().add(rdbtnSocio);

		rdbtnProfesor = new JRadioButton("Profesor/a");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(false);
				rdbtnProfesor.setSelected(true);
				//txtInstitucion.setEnabled(true);
				comInst.setEnabled(true);
				lblInstitucion.setForeground(Color.GRAY);
				txtrDescripcion.setEnabled(true);
				txtrBiografia.setEnabled(true);
				txtSitioWeb.setEnabled(true);

			}
		});
		rdbtnProfesor.setBounds(315, 22, 95, 23);
		getContentPane().add(rdbtnProfesor);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioAceptarActionPerformed(e);
			}
		});
		btnNewButton.setBounds(24, 243, 98, 23);
		getContentPane().add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuarioCancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(24, 277, 98, 23);
		getContentPane().add(btnCancelar);

		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(Color.GRAY);
		lblFechaDeNacimiento.setBounds(24, 157, 153, 14);
		getContentPane().add(lblFechaDeNacimiento);

		spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(24, 185, 44, 20);
		getContentPane().add(spinnerDia);

		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(78, 185, 44, 20);
		getContentPane().add(spinnerMes);

		spinnerAnio = new JSpinner();
		spinnerAnio.setModel(new SpinnerListModel(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926",
				"1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939",
				"1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952",
				"1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965",
				"1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978",
				"1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991",
				"1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004",
				"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
				"2018", "2019", "2020", "2021", "2022" }));
		spinnerAnio.setBounds(133, 185, 55, 20);
		getContentPane().add(spinnerAnio);

		lblDia = new JLabel("Dia");
		lblDia.setForeground(Color.GRAY);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDia.setBounds(24, 171, 44, 14);
		getContentPane().add(lblDia);

		lblMes = new JLabel("Mes");
		lblMes.setForeground(Color.GRAY);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMes.setBounds(78, 171, 44, 14);
		getContentPane().add(lblMes);

		lblAnio = new JLabel("Año");
		lblAnio.setForeground(Color.GRAY);
		lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAnio.setBounds(133, 171, 44, 14);
		getContentPane().add(lblAnio);
		
		comInst = new JComboBox<String>();
		comInst.setEnabled(false);
		comInst.setBounds(246, 76, 164, 22);
		getContentPane().add(comInst);
		
		lblInstitucion = new JLabel("Institucion:");
		lblInstitucion.setForeground(Color.LIGHT_GRAY);
		lblInstitucion.setBounds(246, 57, 164, 14);
		getContentPane().add(lblInstitucion);
		
		txtImagenDePerfil = new JTextField();
		txtImagenDePerfil = new JTextField();
		txtImagenDePerfil.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtImagenDePerfil.getText().equals("")) {
					txtImagenDePerfil.setForeground(Color.GRAY);
					txtImagenDePerfil.setText("Imagen de perfil");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (txtImagenDePerfil.getForeground().equals(Color.GRAY)) 
					txtImagenDePerfil.setText("");
				txtImagenDePerfil.setForeground(Color.black);
			}
		});
		txtImagenDePerfil.setForeground(Color.GRAY);
		txtImagenDePerfil.setText("Imagen de perfil");
		txtImagenDePerfil.setBounds(24, 217, 386, 18);
		getContentPane().add(txtImagenDePerfil);
		txtImagenDePerfil.setColumns(10);

	}

	protected void altaUsuarioCancelarActionPerformed(ActionEvent e) {
		limpiarFormulario();
		setVisible(false);
	}

	protected void altaUsuarioAceptarActionPerformed(ActionEvent e) {
		String nickname = this.txtNickname.getText();
		String nombre = this.txtNombre.getText();
		String apellido = this.txtApellido.getText();
		String email = this.txtEmail.getText();
		String contrasenia = this.txtContrasea.getText();
		String pfp = this.txtImagenDePerfil.getText();

		int dia = (int) spinnerDia.getValue();
		int mes = (int) spinnerMes.getValue();
		String anioString = (String) spinnerAnio.getValue();
		int anio = Integer.parseInt(anioString);
		DtFecha fecha = null;
		try {
			fecha = new DtFecha(anio, mes, dia);
		} catch (FechaInvalidaEx ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Fecha", JOptionPane.ERROR_MESSAGE);
		}

		String descripcion = this.txtrDescripcion.getText();
		String sitioWeb = "";
		String biografia = "";
		if(!this.txtSitioWeb.getForeground().equals(Color.GRAY))
			sitioWeb = this.txtSitioWeb.getText();
		if(!this.txtrBiografia.getForeground().equals(Color.GRAY))
			biografia = this.txtrBiografia.getText();

		DtUsuario dtU = null;

		if (checkFormulario()) {
			ArrayList<DtClase> clasesVacia = new ArrayList<DtClase>(); 
			if (rdbtnSocio.isSelected()) {
				dtU = new DtSocio(nickname, nombre, apellido, email, contrasenia, pfp, fecha, clasesVacia);
			} else if (rdbtnProfesor.isSelected()) {
				
				DtInstitucionDeportiva dtInstDep = icon.getDtinstitucionDeportiva((String)comInst.getSelectedItem());
				
				dtU = new DtProfesor(nickname, nombre, apellido, email, contrasenia, pfp, fecha, descripcion, biografia, sitioWeb,
						dtInstDep, clasesVacia);
			}
			
			try {
				this.icon.altaUsuario(dtU);
				JOptionPane.showMessageDialog(this, "El usuario se ha registrado con éxito", "Agregar Usuario",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			} catch (UsuarioRepetidoEx ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			} catch (NoExisteInstitucionDepEx ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Usuario", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	private void limpiarFormulario() {
		txtNombre.setText("Nombre");
		txtNickname.setText("Nickname");
		txtApellido.setText("Apellido");
		txtEmail.setText("Email");
		//txtInstitucion.setText("Institucion");
		txtSitioWeb.setText("Sitio Web (opcional)");
		txtrDescripcion.setText("Descripcion");
		txtrBiografia.setText("Biografia (opcional)");
		spinnerDia.setValue(1);
		spinnerMes.setValue(1);
		spinnerAnio.setValue("1920");

		txtNombre.setForeground(Color.GRAY);
		txtNickname.setForeground(Color.GRAY);
		txtApellido.setForeground(Color.GRAY);
		txtEmail.setForeground(Color.GRAY);
		//txtInstitucion.setForeground(Color.GRAY);
		txtSitioWeb.setForeground(Color.GRAY);
		txtrDescripcion.setForeground(Color.GRAY);
		txtrBiografia.setForeground(Color.GRAY);

	}

	private boolean checkFormulario() {
		if (this.txtNickname.getForeground().equals(Color.GRAY) || this.txtNombre.getForeground().equals(Color.GRAY)
				|| this.txtApellido.getForeground().equals(Color.GRAY) || this.txtEmail.getForeground().equals(Color.GRAY) 
				|| this.txtContrasea.getForeground().equals(Color.GRAY) || this.txtEmail.getForeground().equals(Color.GRAY)) {
			JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (rdbtnProfesor.isSelected()) {
			if (this.txtrDescripcion.getForeground().equals(Color.GRAY)
					|| this.comInst.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comInst.setModel(modelo);
	}
}
