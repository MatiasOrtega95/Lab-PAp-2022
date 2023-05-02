package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import excepciones.NoExisteActividadDepEx;
import interfaces.IControladorActividadDeportiva;

public class ConsultaDictadoDeClase extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JLabel lblInstitucion;
	private JTextArea textArea;
	private JComboBox<String> comInst;
	private JComboBox<String> comActDep;
	private JComboBox<String> comClase;
	private JLabel lblError2;

	public ConsultaDictadoDeClase(IControladorActividadDeportiva icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				//list.clearSelection();
				lblError2.setText("");
			}
		});
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Dictado De Clase");
		setBounds(100, 100, 440, 379);
		getContentPane().setLayout(null);
		
		//INSTITUCION
		
		lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setBounds(30, 12, 86, 14);
		getContentPane().add(lblInstitucion);
		
		comInst = new JComboBox<String>();
		comInst.setBounds(223, 8, 162, 22);
		comInst.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxActividadesDep();
				cambiarComboBoxClase();
				if((String)comActDep.getSelectedItem() != null)
					try {
						textArea.setText(icon.RegistroDictadoDeClase((String)comActDep.getSelectedItem()).toString());
					} catch (NoExisteActividadDepEx e1) {
						
						e1.printStackTrace();
					}
			}
		});
		getContentPane().add(comInst);
		
		//ACTIVIDADES
		
		JLabel lblActDep = new JLabel("Actividad Deportiva:");
		lblActDep.setBounds(30, 43, 166, 14);
		getContentPane().add(lblActDep);
		
		comActDep = new JComboBox<String>();
		comActDep.setBounds(223, 39, 162, 22);
		comActDep.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxClase();
			}
		});
		getContentPane().add(comActDep);
		
		//CLASES
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setBounds(30, 66, 86, 14);
		getContentPane().add(lblClases);
		
		comClase = new JComboBox<String>();
		comClase.setBounds(223, 70, 162, 22);
		comClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if((String)comClase.getSelectedItem() != null)
					textArea.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
			
			}
		});
		getContentPane().add(comClase);
		
		//DATOS DE CLASE
		
		JLabel lblDatos = new JLabel("Datos");
		lblDatos.setBounds(30, 107, 46, 14);
		getContentPane().add(lblDatos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(223, 103, 162, 106);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		
		
		//CONTINUAR
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				lblError2.setText("");
				
			}
		});
		btnNewButton.setBounds(278, 299, 107, 23);
		getContentPane().add(btnNewButton);
		
		lblError2 = new JLabel("");
		lblError2.setForeground(new Color(255, 0, 0));
		lblError2.setBounds(30, 261, 46, 14);
		getContentPane().add(lblError2);
		
		
		
	}
	
	//COMBO BOX INSTITUCIONES
	
	public void inicializarComboBoxInstituciones() {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>();
		ArrayList<String> instituciones = icon.listarInstituciones();
		for (String s : instituciones) {
			modelo.addElement(s);
		}
		comInst.setModel(modelo);
	}
	
	//COMBO BOX ACTIVIDAD DEPORTIVA
	
	public void cambiarComboBoxActividadesDep() {
		DefaultComboBoxModel<String> modelo2 = new DefaultComboBoxModel<String>();
		ArrayList<String> actDeps = icon.listarActividadesDeportivas((String)comInst.getSelectedItem());
		for (String a : actDeps) {
			modelo2.addElement(a);
		}
		comActDep.setModel(modelo2);
		
		/*
		if((String)comActDep.getSelectedItem() != null)
			try {
				textArea.setText(icon.RegistroDictadoDeClase((String)comActDep.getSelectedItem()).toString());
			} catch (NoExisteActividadDepEx e) {
				e.printStackTrace();
			}
		 */
	}
	
	//COMBO BOX CLASE
	
	public void cambiarComboBoxClase() {
		DefaultComboBoxModel<String> modelo3 = new DefaultComboBoxModel<String>();
		if((String)comActDep.getSelectedItem() != null) {
		ArrayList<String> clas = icon.listarClases((String)comActDep.getSelectedItem());
		for (String c : clas) {
			modelo3.addElement(c);
		}
		comClase.setModel(modelo3);
		if((String)comClase.getSelectedItem() != null)
			textArea.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
		}
	}
}
