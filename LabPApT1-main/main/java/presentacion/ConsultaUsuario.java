package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import interfaces.IControladorUsuario;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;

import datatypes.DtUsuario;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ConsultaUsuario extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	private IControladorUsuario icon;
	private JList<String> listaUsuarios = new JList<String>();
	private String nickSelected;
	private JTextArea textAreaInformacion = new JTextArea();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario(IControladorUsuario icon) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
			}
		});
		//
		this.icon = icon;
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setTitle("Consultar por un usuario");
		//
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(12, 12, 70, 15);
		getContentPane().add(lblUsuarios);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 43, 116, 138);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(listaUsuarios);
		listaUsuarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				nickSelectedAcionPerformed(arg0);
			}
		});
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedFromListActionPerformed(arg0);
			}
		});
		btnSeleccionar.setBounds(12, 193, 116, 25);
		getContentPane().add(btnSeleccionar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(163, 44, 248, 137);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textAreaInformacion);
		textAreaInformacion.setVisible(false);
		textAreaInformacion.setEditable(false);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarTextAreaActionPerformed(arg0);
			}
		});
		btnLimpiar.setBounds(293, 193, 117, 25);
		getContentPane().add(btnLimpiar);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(161, 12, 90, 15);
		getContentPane().add(lblDescripcion);

		

	}
	
	public void inicializarLista() {
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		String[] a = icon.mostrarUsuarios();
		for (String s : a) {
			modelo.addElement(s);
		}
		listaUsuarios.setModel(modelo);
	}	
	public void nickSelectedAcionPerformed(ListSelectionEvent e){
		nickSelected = listaUsuarios.getSelectedValue();
	}
	public void selectedFromListActionPerformed (ActionEvent arg0){
		nickSelected = listaUsuarios.getSelectedValue();
		if(listaUsuarios.getSelectedValue() != null) {
			this.textAreaInformacion.setVisible(true);
			DtUsuario dtu = icon.consultaUsuario(nickSelected);
			this.textAreaInformacion.setText(dtu.toString());		
		}
		
	}
	public void limpiarTextAreaActionPerformed(ActionEvent arg0){
		this.textAreaInformacion.setText("");
		JOptionPane.showMessageDialog(this.textAreaInformacion, "Area de texto Limpiada con exito","Limpiar Area",JOptionPane.INFORMATION_MESSAGE);
	}
}
