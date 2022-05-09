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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;

public class _91_Crear_Evento {

	private JFrame frame;
	private JPanel panel;
	private JButton btnPregunta;

	/**
	 * Launch the application.
	 */
	public static void Crear() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_91_Crear_Evento window = new _91_Crear_Evento();
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
	public _91_Crear_Evento() {
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

		JButton btnCrearEvento = new JButton("CREA TU EVENTO");
		btnCrearEvento.setBackground(new Color(176, 196, 222));
		btnCrearEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearEvento.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearEvento.setBounds(779, 589, 162, 56);
		panel.add(btnCrearEvento);

		btnPregunta = new JButton("");
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_91_Crear_Evento.class.getResource("/images/pregunta-32x32.png")));
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
		
		JComboBox cbxPolideportivo = new JComboBox();
		cbxPolideportivo.setModel(new DefaultComboBoxModel(new String[] {"-Polideportivo", "Enrique Blas", "Galapagar Sports ", "Dehesa de Navalcarb\u00F3n", "El Abaj\u00F3n", "Principe Felipe"}));
		cbxPolideportivo.setBounds(201, 283, 189, 21);
		panel.add(cbxPolideportivo);
		
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
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(430, 207, 206, 176);
		panel.add(calendar);
		
		JLabel lblNewLabel = new JLabel("Ubicaci\u00F3n:");
		lblNewLabel.setBounds(201, 265, 104, 14);
		panel.add(lblNewLabel);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(670, 265, 104, 14);
		panel.add(lblHora);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(849, 241, 104, 14);
		panel.add(lblNivel);


	}
}
