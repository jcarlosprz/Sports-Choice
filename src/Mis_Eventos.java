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

public class Mis_Eventos {

	private JFrame frame;
	private JPanel panel;
	private JButton btnPregunta;
	private JButton btnHome;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mis_Eventos window = new Mis_Eventos();
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
	public Mis_Eventos() {
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

		JLabel lblTuPerfil = new JLabel("MIS EVENTOS");
		lblTuPerfil.setFont(new Font("Dubai", Font.BOLD, 30));
		lblTuPerfil.setBounds(528, 10, 192, 54);
		panel.add(lblTuPerfil);

		JButton btnNewButton = new JButton("ABANDONAR");
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton.setBounds(658, 589, 162, 56);
		panel.add(btnNewButton);

		btnPregunta = new JButton("");
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(Mis_Eventos.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el bot�n sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(724, 10, 32, 52);
		panel.add(btnPregunta);
		
		btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setIcon(new ImageIcon(Mis_Eventos.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(896, 10, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(313, 71, 640, 490);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setIntercellSpacing(new Dimension(15, 3));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Baloncesto", "Enrique Blas", "27/05/2022", "17:00", "Avanzado", "8"},
				{"Padel", "Galapagar Sports", "20/08/2022", "18:00", "Principiante", "4"},
				{"F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Medio", "11"},
				{"Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Avanzado", "2"},
				{"Padel", "Enrique Blas", "12/09/2022", "19:00", "Principiante", "4"},
				{"F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Avanzado", "8"},
				{"F\u00FAtbol", "El Torre\u00F3n", "03/08/2022", "16:00", "Medio", "12"},
				{"Tenis", "Principe Felipe", "28/08/2022", "17:00", "Avanzado", "4"},
				{"Baloncesto", "Gal-full Stadium", "10/08/2022", "16:00", "Medio", "12"},
				{"Baloncesto", "Enrique Blas", "03/05/2022", "19:00", "Medio", "12"},
				{"Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Principiante", null},
			},
			new String[] {
				"Deporte", "Polideportivo", "Fecha", "Hora", "Nivel", "N\u00BA Usuarios"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(37);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		table.getColumnModel().getColumn(5).setPreferredWidth(68);
		scrollPane.setViewportView(table);
		
		JButton btnIrAlForo = new JButton("IR AL FORO");
		btnIrAlForo.setEnabled(false);
		btnIrAlForo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIrAlForo.setFont(new Font("Dubai", Font.BOLD, 15));
		btnIrAlForo.setBounds(446, 589, 162, 56);
		btnIrAlForo.setBackground(new Color(176, 196, 222));
		panel.add(btnIrAlForo);


	}
}