package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import datatypes.DtClase;
import datatypes.DtFecha;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.FechaInvalidaEx;

import interfaces.IControladorUsuario;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ModificarDatosUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icon;
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtSitioWeb;
	private JTextField txtEmail;
	private JTextField txtNickname;
	private JSpinner spinnerAnio;
	private JSpinner spinnerMes;
	private JSpinner spinnerDia;
	private JTextField txtInstitucion;
	private JComboBox<String> comUsr;
	private JTextArea txtrBiografia;
	private JTextArea txtrDescripcion;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private DtUsuario dtUsuario;
	private JTextField txtContrasea;
	private JTextField txtpfp;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosUsuario frame = new ModificarDatosUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ModificarDatosUsuario(IControladorUsuario iCU) {
		//this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Modificar datos del usuario");
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		setClosable(true);
		setBounds(100, 100, 450, 401);
		getContentPane().setLayout(null);
		
		this.icon = iCU;
		
		comUsr = new JComboBox<String>();
		comUsr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarDatosUsuario();
			}
		});
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(128, 128, 128));
		lblUsuario.setBounds(18, 5, 121, 14);
		getContentPane().add(lblUsuario);
		comUsr.setBounds(18, 21, 164, 22);
		getContentPane().add(comUsr);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setForeground(new Color(128, 128, 128));
		lblNickname.setBounds(18, 54, 131, 14);
		getContentPane().add(lblNickname);
		
		txtNickname = new JTextField();
		txtNickname.setEnabled(false);
		txtNickname.setForeground(Color.BLACK);
		txtNickname.setColumns(10);
		txtNickname.setBounds(18, 68, 164, 20);
		getContentPane().add(txtNickname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(128, 128, 128));
		lblEmail.setBounds(18, 99, 131, 14);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(18, 114, 164, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(128, 128, 128));
		lblNombre.setBounds(18, 145, 131, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setColumns(10);
		txtNombre.setBounds(18, 158, 164, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(128, 128, 128));
		lblApellido.setBounds(18, 189, 131, 14);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 0, 0));
		txtApellido.setColumns(10);
		txtApellido.setBounds(18, 203, 164, 20);
		getContentPane().add(txtApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(Color.GRAY);
		lblFechaDeNacimiento.setBounds(18, 232, 153, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setForeground(Color.GRAY);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDia.setBounds(18, 246, 44, 14);
		getContentPane().add(lblDia);
		
		spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(18, 260, 44, 20);
		getContentPane().add(spinnerDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setForeground(Color.GRAY);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMes.setBounds(72, 246, 44, 14);
		getContentPane().add(lblMes);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(72, 260, 44, 20);
		getContentPane().add(spinnerMes);
		
		JLabel lblAnio = new JLabel("Año");
		lblAnio.setForeground(Color.GRAY);
		lblAnio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAnio.setBounds(127, 246, 44, 14);
		getContentPane().add(lblAnio);
		
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
		spinnerAnio.setBounds(127, 260, 55, 20);
		getContentPane().add(spinnerAnio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioAceptarActionPerformed(e);
			}
		});
		
		JLabel lblInstitucion = new JLabel("Institucion:");
		lblInstitucion.setForeground(Color.GRAY);
		lblInstitucion.setBounds(241, 5, 131, 14);
		getContentPane().add(lblInstitucion);
		
		txtInstitucion = new JTextField();
		txtInstitucion.setForeground(Color.BLACK);
		txtInstitucion.setEnabled(false);
		txtInstitucion.setColumns(10);
		txtInstitucion.setBounds(241, 21, 164, 20);
		getContentPane().add(txtInstitucion);
		
		JLabel lblSitioWebopcional = new JLabel("Sitio web (opcional):");
		lblSitioWebopcional.setForeground(Color.GRAY);
		lblSitioWebopcional.setBounds(241, 54, 131, 14);
		getContentPane().add(lblSitioWebopcional);
		
		txtSitioWeb = new JTextField();
		txtSitioWeb.setEnabled(false);
		txtSitioWeb.setForeground(new Color(0, 0, 0));
		txtSitioWeb.setColumns(10);
		txtSitioWeb.setBounds(241, 68, 164, 20);
		getContentPane().add(txtSitioWeb);
		
		JLabel lblBiografiaopcional = new JLabel("Biografia (opcional):");
		lblBiografiaopcional.setForeground(Color.GRAY);
		lblBiografiaopcional.setBounds(241, 99, 131, 14);
		getContentPane().add(lblBiografiaopcional);
		
		txtrBiografia = new JTextArea();
		txtrBiografia.setEnabled(false);
		txtrBiografia.setLineWrap(true);
		txtrBiografia.setForeground(new Color(0, 0, 0));
		txtrBiografia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrBiografia.setColumns(10);
		txtrBiografia.setBounds(241, 114, 162, 64);
		getContentPane().add(txtrBiografia);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.GRAY);
		lblDescripcion.setBounds(241, 189, 131, 14);
		getContentPane().add(lblDescripcion);
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setEnabled(false);
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setForeground(new Color(0, 0, 0));
		txtrDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrDescripcion.setColumns(10);
		txtrDescripcion.setBounds(241, 203, 162, 77);
		getContentPane().add(txtrDescripcion);
		btnAceptar.setBounds(84, 338, 98, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(241, 338, 98, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setForeground(Color.GRAY);
		lblContrasea.setBounds(18, 292, 153, 14);
		getContentPane().add(lblContrasea);
		
		txtContrasea = new JTextField();
		txtContrasea.setForeground(new Color(0, 0, 0));
		txtContrasea.setBounds(18, 308, 164, 18);
		getContentPane().add(txtContrasea);
		txtContrasea.setColumns(10);
		
		JLabel lblpfp = new JLabel("Foto de perfil:");
		lblpfp.setForeground(Color.GRAY);
		lblpfp.setBounds(241, 292, 153, 14);
		getContentPane().add(lblpfp);
		
		txtpfp = new JTextField();
		txtpfp.setForeground(new Color(0, 0, 0));
		txtpfp.setColumns(10);
		txtpfp.setBounds(241, 308, 164, 18);
		getContentPane().add(txtpfp);
		
	

	}
	
	protected void modificarUsuarioAceptarActionPerformed(ActionEvent e) {
		String nickname = this.txtNickname.getText();
		String nombre = this.txtNombre.getText();
		String apellido = this.txtApellido.getText();
		String contrasenia = this.txtContrasea.getText();
		String pfp = this.txtpfp.getText();

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
		if(!this.txtSitioWeb.getText().isEmpty())
			sitioWeb = this.txtSitioWeb.getText();
		if(!this.txtrBiografia.getText().isEmpty())
			biografia = this.txtrBiografia.getText();

		DtUsuario dtU = null;
		
		

		if (checkFormulario()) {
			ArrayList<DtClase> clasesVacia = new ArrayList<DtClase>(); 
			if (dtUsuario instanceof DtSocio) {
				dtU = new DtSocio(nickname, nombre, apellido, null, contrasenia, pfp, fecha, clasesVacia);
			} else if (dtUsuario instanceof DtProfesor) {
				
				
				dtU = new DtProfesor(nickname, nombre, apellido, null, contrasenia, pfp, fecha, descripcion, biografia, sitioWeb,
						null, clasesVacia);
			}
			

				this.icon.modificarUsuario(dtU);
				JOptionPane.showMessageDialog(this, "El usuario se ha modificado con éxito", "Modificar Usuario",
						JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				this.setVisible(false);


		}

	}
	
	private boolean checkFormulario() {
		if (this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtContrasea.getText().isEmpty() || this.txtpfp.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (dtUsuario instanceof DtProfesor) {
			if (this.txtrDescripcion.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No puede haber campos no opcionales vacíos", "Agregar Usuario",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void inicializarComboBoxUsuarios() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		String[] usuarios = icon.mostrarUsuarios();
		for (String u : usuarios) {
			modelo.addElement(u);
		}
		comUsr.setModel(modelo);
	}
	
	public void cargarDatosUsuario() {
		String usuarioSeleccionado = (String)comUsr.getSelectedItem();
		if(comUsr.getSelectedItem() != null) {
			limpiarFormulario();
			DtUsuario dtu = icon.consultaUsuario(usuarioSeleccionado);
			dtUsuario = dtu;
			//datos comunes
			txtNickname.setText(dtu.getNickname());
			txtEmail.setText(dtu.getEmail());
			txtNombre.setText(dtu.getNombre());
			txtApellido.setText(dtu.getApellido());
			txtContrasea.setText(dtu.getContrasenia());
			txtpfp.setText(dtu.getpfp());
			spinnerDia.setValue(Integer.valueOf(dtu.getFecha().getDia()));
			spinnerMes.setValue(Integer.valueOf(dtu.getFecha().getMes()));
			spinnerAnio.setValue(String.valueOf(dtu.getFecha().getAnio()));
			
			//datos especificos de profesor
			if(dtu instanceof DtProfesor) {
				txtInstitucion.setText(((DtProfesor)dtu).getInstitucion().getNombre());
				txtSitioWeb.setText(((DtProfesor)dtu).getSitioWeb());
				txtSitioWeb.setEnabled(true);
				txtrBiografia.setEnabled(true);
				txtrDescripcion.setEnabled(true);
				txtrBiografia.setText(((DtProfesor)dtu).getBiografia());
				txtrDescripcion.setText(((DtProfesor)dtu).getDescripcion());
			}
		}
	}
	
	public boolean hayUsuarios() {
		String[] usuarios = icon.mostrarUsuarios();
		if(usuarios.length != 0) return true;
		else {
			JOptionPane.showMessageDialog(this, "No hay usuarios", "",
							JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void limpiarFormulario() {
		txtSitioWeb.setEnabled(false);
		txtrBiografia.setEnabled(false);
		txtrDescripcion.setEnabled(false);
		txtNickname.setText("");
		txtEmail.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtContrasea.setText("");
		txtpfp.setText("");
		spinnerDia.setValue(Integer.valueOf(1));
		spinnerMes.setValue(Integer.valueOf(1));
		spinnerAnio.setValue("1920");
		txtInstitucion.setText("");
		txtSitioWeb.setText("");
		txtrBiografia.setText("");
		txtrDescripcion.setText("");
		
	}
}
