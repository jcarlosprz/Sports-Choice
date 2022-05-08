import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class Crear_Evento {

	private JFrame frame;
	private JPanel panel;
	private JButton btnPregunta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crear_Evento window = new Crear_Evento();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Crear_Evento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(140, 50, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTuPerfil = new JLabel("HAS SELECCIONADO: \"Deporte\"");
		lblTuPerfil.setFont(new Font("Dubai", Font.BOLD, 30));
		lblTuPerfil.setBounds(417, 10, 432, 54);
		panel.add(lblTuPerfil);

		JButton btnNewButton = new JButton("CREA TU EVENTO");
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton.setBounds(779, 589, 162, 56);
		panel.add(btnNewButton);

		btnPregunta = new JButton("");
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(Crear_Evento.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el botón sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(756, 62, 32, 52);
		panel.add(btnPregunta);
		
		JLabel lblSeleccionaTusPreferencias = new JLabel("Selecciona tus preferencias:");
		lblSeleccionaTusPreferencias.setFont(new Font("Dubai", Font.BOLD, 20));
		lblSeleccionaTusPreferencias.setBounds(508, 67, 250, 40);
		panel.add(lblSeleccionaTusPreferencias);
		
		JSpinner spinnerFechaDia = new JSpinner();
		spinnerFechaDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerFechaDia.setBounds(417, 281, 52, 22);
		panel.add(spinnerFechaDia);
		
		JComboBox cbxPolideportivo = new JComboBox();
		cbxPolideportivo.setModel(new DefaultComboBoxModel(new String[] {"-Polideportivo", "Enrique Blas", "Galapagar Sports ", "Dehesa de Navalcarb\u00F3n", "El Abaj\u00F3n", "Principe Felipe"}));
		cbxPolideportivo.setBounds(200, 281, 189, 21);
		panel.add(cbxPolideportivo);
		
		JSpinner spinnerFechaDia_1 = new JSpinner();
		spinnerFechaDia_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerFechaDia_1.setBounds(490, 282, 52, 22);
		panel.add(spinnerFechaDia_1);
		
		JSpinner spinnerFechaDia_2 = new JSpinner();
		spinnerFechaDia_2.setModel(new SpinnerNumberModel(2022, 2022, 2025, 1));
		spinnerFechaDia_2.setBounds(559, 281, 77, 22);
		panel.add(spinnerFechaDia_2);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNewLabel.setBounds(477, 282, 8, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNewLabel_1.setBounds(545, 282, 8, 22);
		panel.add(lblNewLabel_1);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Dubai", Font.PLAIN, 15));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Principiante", "Medio", "Avanzado"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(849, 258, 137, 88);
		panel.add(list);
		
		JSpinner spinnerFechaDia_1_1 = new JSpinner();
		spinnerFechaDia_1_1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerFechaDia_1_1.setBounds(670, 282, 52, 22);
		panel.add(spinnerFechaDia_1_1);
		
		JSpinner spinnerFechaDia_1_2 = new JSpinner();
		spinnerFechaDia_1_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerFechaDia_1_2.setBounds(736, 281, 52, 22);
		panel.add(spinnerFechaDia_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(727, 283, 8, 22);
		panel.add(lblNewLabel_1_1);


	}
}
