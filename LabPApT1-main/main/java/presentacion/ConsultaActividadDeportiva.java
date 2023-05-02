package presentacion;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import interfaces.IControladorActividadDeportiva;

import excepciones.NoExisteActividadDepEx;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConsultaActividadDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private IControladorActividadDeportiva icon;
	private JLabel lblInstitucion;
	private JTextArea textArea;
	private JComboBox<String> comInst;
	private JComboBox<String> comActDep;
	private JComboBox<String> comClase;
	private JScrollPane scrollPane;
	private JTextArea textArea2;
	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaActividadDeportiva frame = new ConsultaActividadDeportiva();
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
	public ConsultaActividadDeportiva(IControladorActividadDeportiva icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				//list.clearSelection();
			}
		});
		//
		this.icon = icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consultar una actividad deportiva");
		
		lblInstitucion = new JLabel("Institución:");
		lblInstitucion.setBounds(28, 25, 154, 15);
		getContentPane().add(lblInstitucion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(194, 52, 213, 86);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblInstitucion_1 = new JLabel("Información:");
		lblInstitucion_1.setBounds(194, 25, 104, 15);
		getContentPane().add(lblInstitucion_1);
		
		comInst = new JComboBox<String>();
		comInst.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxActividadesDep();
				cambiarComboBoxClase();
				if((String)comActDep.getSelectedItem() != null)
					try {
						textArea.setText(icon.ConsultaActividadDeportiva((String)comActDep.getSelectedItem()).toString());
					} catch (NoExisteActividadDepEx e1) {
						e1.printStackTrace();
					}
			}
		});
		comInst.setBounds(28, 54, 138, 22);
		getContentPane().add(comInst);
		
		JLabel lblActDep = new JLabel("Actividad Deportiva:");
		lblActDep.setBounds(28, 87, 154, 15);
		getContentPane().add(lblActDep);
		
		comActDep = new JComboBox<String>();
		comActDep.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiarComboBoxClase();
				if((String)comActDep.getSelectedItem() != null) {
					try {
						textArea.setText(icon.ConsultaActividadDeportiva((String)comActDep.getSelectedItem()).toString());
					} catch (NoExisteActividadDepEx e1) {
						e1.printStackTrace();
					}
				
				}
			}
		});
		comActDep.setBounds(28, 116, 138, 22);
		getContentPane().add(comActDep);
		
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setBounds(28, 155, 154, 15);
		getContentPane().add(lblClases);
		
		comClase = new JComboBox<String>();
		comClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if((String)comClase.getSelectedItem() != null)
					textArea2.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
			
			}
		});
		comClase.setBounds(28, 181, 138, 22);
		getContentPane().add(comClase);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 149, 213, 86);
		getContentPane().add(scrollPane);
		
		textArea2 = new JTextArea();
		textArea2.setEditable(false);
		scrollPane.setViewportView(textArea2);

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
		if((String)comActDep.getSelectedItem() != null)
			try {
				textArea.setText(icon.ConsultaActividadDeportiva((String)comActDep.getSelectedItem()).toString());
			} catch (NoExisteActividadDepEx e) {
				
				e.printStackTrace();
			}
	}
	
	public void cambiarComboBoxClase() {
		DefaultComboBoxModel<String> modelo3 = new DefaultComboBoxModel<String>();
		if((String)comActDep.getSelectedItem() != null) {
		ArrayList<String> clas = icon.listarClases((String)comActDep.getSelectedItem());
		for (String c : clas) {
			modelo3.addElement(c);
		}
		comClase.setModel(modelo3);
		if((String)comClase.getSelectedItem() != null)
		textArea2.setText(icon.getDtClase((String)comClase.getSelectedItem()).toString());
		}
	}
}
