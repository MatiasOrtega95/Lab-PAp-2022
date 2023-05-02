package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.ClaseRepetidaEx;
import excepciones.NoExistenUsuariosEx;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import interfaces.IControladorClase;

import com.toedter.calendar.JDateChooser;

import datatypes.DtFecha;
import datatypes.DtFechaHora;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class AltaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;
	private JTextField textNombre;
	private JTextField textURL;
	private JDateChooser dateFecha;
	private JDateChooser dateFechaAlta;
	private JLabel lblError;
	private JSpinner spinHora ;
	private JSpinner spinMin;
	private JLabel lblActividadDeportiva;
	private JComboBox<String> comActDep;
	private JComboBox<String> comInst;
	private JComboBox<String> comProf;
	private JLabel lblPicture;
	private JTextField textPicture;
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaInstitucionDep frame = new AltaInstitucionDep(icon);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public AltaDictadoDeClase(IControladorClase icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		//
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar una clase");
		setBounds(100, 100, 391, 365);
		getContentPane().setLayout(null);
		
		//INSTITUCION
		
		JLabel lblNewLabel = new JLabel("Institución deportiva");
		lblNewLabel.setBounds(12, 15, 165, 14);
		getContentPane().add(lblNewLabel);
		
		comInst = new JComboBox<String>();
		comInst.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxActividadesDep();
				cambiarComboBoxProfesores();
			}
		});
		comInst.setBounds(243, 11, 114, 22);
		getContentPane().add(comInst);
		
		lblActividadDeportiva = new JLabel("Actividad deportiva");
		
				lblActividadDeportiva.setBounds(12, 51, 165, 15);
				getContentPane().add(lblActividadDeportiva);
		
		comActDep = new JComboBox<String>();
		comActDep.setBounds(243, 46, 114, 24);
		getContentPane().add(comActDep);
		//		
		JLabel lblNombreDeLa = new JLabel("Nombre de la clase");
		lblNombreDeLa.setBounds(12, 84, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setBounds(243, 81, 114, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		//FECHA
		
		JLabel lblFecha = new JLabel("Fecha y hora de inicio");
		lblFecha.setBounds(12, 111, 165, 15);
		getContentPane().add(lblFecha);
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("d MM y");
		dateFecha.setBounds(61, 132, 114, 20);
		getContentPane().add(dateFecha);
		
		spinHora = new JSpinner();
		spinHora.setBounds(189, 132, 49, 20);
		getContentPane().add(spinHora);
		
		spinMin = new JSpinner();
		spinMin.setBounds(250, 132, 43, 20);
		getContentPane().add(spinMin);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(243, 137, 12, 15);
		getContentPane().add(label);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setBounds(12, 174, 70, 15);
		getContentPane().add(lblProfesor);
		
		comProf = new JComboBox<String>();
		comProf.setBounds(243, 168, 114, 22);
		getContentPane().add(comProf);
		
		//URL
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 203, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		textURL.setBounds(243, 201, 114, 19);
		getContentPane().add(textURL);
		
		//FECHA ALTA
		
		JLabel lblFechaAlt = new JLabel("Fecha de alta");
		lblFechaAlt.setBounds(12, 237, 137, 15);
		getContentPane().add(lblFechaAlt);
		
		dateFechaAlta = new JDateChooser();
		dateFechaAlta.setDateFormatString("d MM y");
		dateFechaAlta.setBounds(243, 232, 114, 20);
		getContentPane().add(dateFechaAlta);
		
		//INGRESAR
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClasePerformed(e);
			}
		});
		
		lblPicture = new JLabel("URL de imagen");
		lblPicture.setBounds(12, 264, 117, 15);
		getContentPane().add(lblPicture);
		
		textPicture = new JTextField();
		textPicture.setBounds(243, 264, 114, 18);
		getContentPane().add(textPicture);
		textPicture.setColumns(10);
		btnIngresar.setBounds(240, 299, 117, 25);
		getContentPane().add(btnIngresar);
		
		//CANCELAR
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				dispose();
			}
		});
		btnCancelar.setBounds(12, 299, 117, 25);
		getContentPane().add(btnCancelar);
		
		//ERROR
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblError.setBounds(112, 268, 227, 33);
		getContentPane().add(lblError);

	}
	
	
	
	protected void addClasePerformed(ActionEvent arg0) {
		String actDep = (String) this.comActDep.getSelectedItem();
		String nombreclase = this.textNombre.getText();
		Calendar fechaCal = this.dateFecha.getCalendar();
		int hora = (int)this.spinHora.getValue();
		int min = (int)this.spinMin.getValue();
		String URL = this.textURL.getText();
		Calendar fechaAlta = this.dateFechaAlta.getCalendar();
		String profesor = (String)this.comProf.getSelectedItem();
		String picture = this.textPicture.getText();
		
		

		if (nombreclase.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacío");
		}else if (dateFecha.getCalendar() == null) {
			this.lblError.setText("La fecha no puede estar vacia");			
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vaci0");
		}else if (dateFechaAlta.getCalendar() == null) {
			this.lblError.setText("La fecha de alta no puede estar vacia");
		}else if(this.comActDep.getSelectedItem() == null){
			this.lblError.setText("Debe especificar una actividad deportiva");
		}else if(this.comProf.getSelectedItem() == null){
			this.lblError.setText("Debe especificar un profesor");
		}else if(picture.isEmpty()) {
			this.lblError.setText("Debe especificar un url de imagen");
		}else{
			DtFechaHora fechaHoraInicio = new DtFechaHora(fechaCal, hora, min);
			DtFecha fechaAlt = new DtFecha(fechaAlta);
			try {
				try {
					this.icon.addClase(actDep, nombreclase,fechaHoraInicio,profesor,URL,fechaAlt, picture);
					JOptionPane.showMessageDialog(this, "La clase se ha registrado con éxito", "Agregar Clase",
							JOptionPane.INFORMATION_MESSAGE);
					limpiarFormulario();
					setVisible(false);
				} catch (NoExistenUsuariosEx ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage(), "Usuario", JOptionPane.ERROR_MESSAGE);
				}
			}catch(ClaseRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
		
	}
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comInst.setModel(modelo);
	}
	
	public void cambiarComboBoxActividadesDep() {
		DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
		ArrayList<String> actDeps = icon.listarActividadesDeportivas((String)comInst.getSelectedItem());
		for (String a : actDeps) {
			modelo2.addElement(a);
		}
		comActDep.setModel(modelo2);
	}
	
	public void cambiarComboBoxProfesores() {
		DefaultComboBoxModel<String> modelo3 = new DefaultComboBoxModel<String>();
		ArrayList<String> profesores = icon.listarProfesores((String)comInst.getSelectedItem());
		for (String p : profesores) {
			modelo3.addElement(p);
		}
		comProf.setModel(modelo3);
	}
	
	public boolean hayInstituciones() {
		ArrayList<String> instituciones = icon.listarInstituciones();
		if(!instituciones.isEmpty()) return true;
		else {
			JOptionPane.showMessageDialog(this, "No hay instituciones", "",
							JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	private void limpiarFormulario() {
		
		this.spinHora.setValue(0);
		this.spinMin.setValue(0);
		this.textNombre.setText("");;
		this.textURL.setText("");;
		this.dateFecha.setCalendar(null);
		this.dateFechaAlta.setCalendar(null);
		this.textPicture.setText("");
		this.lblError.setText("");	

	}
	
}
