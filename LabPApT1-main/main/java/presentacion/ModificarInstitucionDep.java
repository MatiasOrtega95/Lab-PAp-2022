package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtInstitucionDeportiva;
import interfaces.IControladorInstitucionDep;

public class ModificarInstitucionDep extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorInstitucionDep icon;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textUrl;
	private JComboBox<String> comboInstitucion;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarInstitucionDep frame = new ModificarInstitucionDep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public ModificarInstitucionDep(IControladorInstitucionDep icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Modificar institución deportiva");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboInstitucion = new JComboBox<String>();
		comboInstitucion.setBounds(219, 12, 163, 24);
		getContentPane().add(comboInstitucion);
		
		JLabel lblInstitucinDeportiva = new JLabel("Institución deportiva");
		lblInstitucinDeportiva.setBounds(29, 17, 172, 15);
		getContentPane().add(lblInstitucinDeportiva);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 48, 440, 2);
		getContentPane().add(separator);
		
		JLabel lblNombreInstitucin = new JLabel("Nombre institución");
		lblNombreInstitucin.setBounds(29, 62, 134, 15);
		getContentPane().add(lblNombreInstitucin);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(219, 60, 163, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(219, 105, 163, 19);
		getContentPane().add(textDescripcion);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(29, 107, 82, 15);
		getContentPane().add(lblDescripcin);
		
		textUrl = new JTextField();
		textUrl.setColumns(10);
		textUrl.setBounds(219, 150, 163, 19);
		getContentPane().add(textUrl);
		
		JLabel lblNombreInstitucin_1_1 = new JLabel("URL");
		lblNombreInstitucin_1_1.setBounds(29, 152, 134, 15);
		getContentPane().add(lblNombreInstitucin_1_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(29, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInstDepActionPerformed(e);
			}
		});
		btnAceptar.setBounds(311, 231, 117, 25);
		getContentPane().add(btnAceptar);

	}
	
	protected void updateInstDepActionPerformed (ActionEvent e){
		String nombre = (String) this.comboInstitucion.getSelectedItem();
		String desc = this.textDescripcion.getText();
		String url = this.textUrl.getText();
		if(nombre == "" || desc == "" || url == "") {
			JOptionPane.showMessageDialog(this, "No puede haber capos vacios", "Modificar institución deportiva", JOptionPane.ERROR_MESSAGE);
		}else {
			DtInstitucionDeportiva dtInstDep = new DtInstitucionDeportiva(nombre, desc, url);
			icon.updateInstDep(dtInstDep);
		}
	}
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comboInstitucion.setModel(modelo);
	}
	
	private void limpiarFormulario() {
		this.textNombre.setText("");
		this.textDescripcion.setText("");
		this.textUrl.setText("");
	}
}
