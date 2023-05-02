package presentacion;

import javax.swing.JInternalFrame;

import interfaces.IControladorClase;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import datatypes.DtClase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RankingDictadoClases extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private IControladorClase icon;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingDictadoClases frame = new RankingDictadoClases();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RankingDictadoClases(IControladorClase icon) {
		this.icon = icon;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ranking de Dictado de Clases");
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setBounds(12, 12, 70, 15);
		getContentPane().add(lblRanking);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnVolver.setBounds(311, 231, 117, 25);
		getContentPane().add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 39, 406, 174);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		

	}
	
	public void llenarRanking() {
		List<DtClase> clases = icon.rankingClases();
		int i = 1;
		textArea.setText(null);
		for (DtClase dtc : clases) {
			textArea.append(i + "- " + dtc.toString() + "\n\n _____________________\n\n");
			i++;
		}
		
		//textArea.setText(icon.rankingClases().toString());
	}	
}
