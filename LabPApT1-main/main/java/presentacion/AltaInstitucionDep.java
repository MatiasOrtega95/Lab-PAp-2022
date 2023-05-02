package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.InstitucionDepRepetidaEx;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interfaces.IControladorInstitucionDep;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class AltaInstitucionDep extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorInstitucionDep icon;//
	private JTextField textNombre;
	private JTextField textDescripcion;
	private JTextField textURL;
	private JLabel lblError;
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
	public AltaInstitucionDep(IControladorInstitucionDep icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				internalFrameClosedEvent(e);
			}
		});
		//
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Agregar una Institución deportiva");
		//
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la institución");
		lblNombreDeLa.setBounds(12, 44, 198, 15);
		getContentPane().add(lblNombreDeLa);
		
		textNombre = new JTextField();
		textNombre.setToolTipText("Nombre de la institución a añadir");
		textNombre.setBounds(243, 42, 152, 19);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(12, 94, 124, 15);
		getContentPane().add(lblDescripcin);
		
		textDescripcion = new JTextField();
		textDescripcion.setToolTipText("Una breve descripción de la institución");
		textDescripcion.setBounds(243, 92, 152, 19);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(12, 138, 70, 15);
		getContentPane().add(lblUrl);
		
		textURL = new JTextField();
		textURL.setToolTipText("Dirección web de la institución");
		textURL.setBounds(243, 145, 152, 19);
		getContentPane().add(textURL);
		textURL.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInstitucionDepActionPerformed(e);//para facilitar
			}
		});
		btnIngresar.setBounds(311, 231, 117, 25);
		getContentPane().add(btnIngresar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(12, 231, 117, 25);
		getContentPane().add(btnCancelar);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(239, 41, 41));
		lblError.setFont(new Font("Dialog", Font.BOLD, 10));
		lblError.setBounds(57, 186, 338, 33);
		getContentPane().add(lblError);
		

	}
	
	protected void addInstitucionDepActionPerformed(ActionEvent arg0) {
		String nombre = this.textNombre.getText();
		String descripcion = this.textDescripcion.getText();
		String URL = this.textURL.getText();
		if (nombre.isEmpty()) {
			this.lblError.setText("Nombre no puede estar vacío");
		}else if (descripcion.isEmpty()) {
			this.lblError.setText("Descripción no puede estar vacío");			
		}else if (URL.isEmpty()) {
			this.lblError.setText("URL no puede estar vacío");
		}else{
			try {
				this.icon.addInstitucionDep(this.textNombre.getText(),this.textDescripcion.getText(),this.textURL.getText());
	            JOptionPane.showMessageDialog(this, "Agregada con exito la institución: " + nombre, "Agregar Institución deportiva",
	                    JOptionPane.INFORMATION_MESSAGE);
	            dispose();
			}catch(InstitucionDepRepetidaEx ex){
				this.lblError.setText(ex.getMessage());
			}
		}
	}
	
	protected void internalFrameClosedEvent(InternalFrameEvent e) {
		this.textNombre.setText(null);
		this.textDescripcion.setText(null);
		this.textURL.setText(null);
		this.lblError.setText(null);
	}
}
