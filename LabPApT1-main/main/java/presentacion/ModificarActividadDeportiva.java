package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import interfaces.IControladorActividadDeportiva;

import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ModificarActividadDeportiva extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private IControladorActividadDeportiva icon;
	
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JSpinner spnrCosto;
	private JSpinner spnrDuracion;
	private JTextArea txtrDescripcion;
	private JComboBox<String> comActDep;
	private JLabel lblPicture;
	private JTextField textPicture;
	

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarActividadDeportiva frame = new ModificarActividadDeportiva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	  */
	/**
	 * Create the frame.
	 */
	public ModificarActividadDeportiva(IControladorActividadDeportiva iCAD) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		setClosable(true);
		setBounds(100, 100, 370, 286);
		getContentPane().setLayout(null);
		
		icon = iCAD;
		
		JLabel lblActividadDeportiva = new JLabel("Actividad Deportiva:");
		lblActividadDeportiva.setForeground(Color.GRAY);
		lblActividadDeportiva.setBounds(15, 12, 121, 14);
		getContentPane().add(lblActividadDeportiva);
		
		comActDep = new JComboBox<String>();
		comActDep.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarDatosActDep();
			}
		});
		comActDep.setBounds(15, 28, 164, 22);
		getContentPane().add(comActDep);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(15, 75, 164, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setBounds(15, 61, 131, 14);
		getContentPane().add(lblNombre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 121, 162, 66);
		getContentPane().add(scrollPane);
		
		txtrDescripcion = new JTextArea();
		scrollPane.setViewportView(txtrDescripcion);
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setForeground(Color.BLACK);
		txtrDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.GRAY);
		lblDescripcion.setBounds(15, 106, 131, 14);
		getContentPane().add(lblDescripcion);
		
		spnrDuracion = new JSpinner();
		spnrDuracion.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spnrDuracion.setBounds(220, 30, 78, 18);
		getContentPane().add(spnrDuracion);
		
		spnrCosto = new JSpinner();
		spnrCosto.setModel(new SpinnerNumberModel(Float.valueOf(1), Float.valueOf(1), null, Float.valueOf(1)));
		spnrCosto.setBounds(220, 79, 78, 18);
		getContentPane().add(spnrCosto);
		
		JLabel lblDuracion = new JLabel("Duración (minutos)");
		lblDuracion.setForeground(new Color(128, 128, 128));
		lblDuracion.setBounds(220, 12, 152, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("Costo ($ UYU)");
		lblCosto.setForeground(new Color(128, 128, 128));
		lblCosto.setBounds(220, 61, 114, 14);
		getContentPane().add(lblCosto);
		
		JLabel lblFechaDeRegistro = new JLabel("Fecha de registro:");
		lblFechaDeRegistro.setForeground(Color.GRAY);
		lblFechaDeRegistro.setBounds(220, 106, 114, 14);
		getContentPane().add(lblFechaDeRegistro);
		
		txtFecha = new JTextField();
		txtFecha.setForeground(Color.BLACK);
		txtFecha.setEnabled(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(220, 120, 78, 20);
		getContentPane().add(txtFecha);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(58, 216, 98, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarUsuarioAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(194, 216, 98, 23);
		getContentPane().add(btnAceptar);
		
		lblPicture = new JLabel("URL de imagen:");
		lblPicture.setForeground(Color.GRAY);
		lblPicture.setBounds(220, 152, 114, 14);
		getContentPane().add(lblPicture);
		
		textPicture = new JTextField();
		textPicture.setBounds(220, 169, 114, 18);
		getContentPane().add(textPicture);
		textPicture.setColumns(10);

	}
	
	protected void modificarUsuarioAceptarActionPerformed(ActionEvent e) {
		String nombre = this.txtNombre.getText();
		String descripcion = this.txtrDescripcion.getText();
		float costo = (float) spnrCosto.getValue();
		int duracion = (int) spnrDuracion.getValue();
		String picture = this.textPicture.getText();
		
		
		DtActividadDeportiva dtA = null;
		
		if(checkFormulario()) {
			ArrayList<DtClase> clasesVacia = new ArrayList<DtClase>(); 
			dtA = new DtActividadDeportiva(nombre, descripcion, duracion, costo, null, clasesVacia, picture);
		}
		
		this.icon.modificarActividadDeportiva(dtA);
		JOptionPane.showMessageDialog(this, "La actividad deportiva se ha modificado con éxito", "Modificar Actividad Deportiva",
				JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
		this.setVisible(false);
	}
	
	private boolean checkFormulario() {
		if (this.txtNombre.getText().isEmpty() || this.txtrDescripcion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Actividad Deportiva",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void inicializarComboBoxActDep() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> actDeps = icon.getActividadesDeportivas();
		for (String a : actDeps) {
			modelo.addElement(a);
		}
		comActDep.setModel(modelo);
	}
	
	public boolean hayActividadesDeportivas() {
		ArrayList<String> actDeps= icon.getActividadesDeportivas();
		if(!actDeps.isEmpty()) return true;
		else {
			JOptionPane.showMessageDialog(this, "No hay actividades deportivas", "",
							JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void cargarDatosActDep() {
		String actividadSeleccionada = (String)comActDep.getSelectedItem();
		if(comActDep.getSelectedItem() != null) {
			limpiarFormulario();
			DtActividadDeportiva dta = icon.getDtActividadDeportiva(actividadSeleccionada);

			txtNombre.setText(dta.getNombre());
			txtrDescripcion.setText(dta.getDescripcion());
			txtFecha.setText(dta.getFechaReg().toString());
			spnrCosto.setValue(dta.getCosto());
			spnrDuracion.setValue(dta.getDuracion());
			textPicture.setText(dta.getPicture());
			
		}
	}
	
	public void limpiarFormulario() {
		txtNombre.setText("");
		txtFecha.setText("");
		txtrDescripcion.setText("");
		spnrCosto.setValue(Integer.valueOf(1));
		spnrDuracion.setValue(Integer.valueOf(1));
		textPicture.setText("");
	}
	
}
