import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class _9_Eventos_Disponibles {

	private JFrame frame;
	private JPanel panel;
	private JButton btnPregunta, btnHome, btnCrearEvento, btnUnirse;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblEventosDisponibles;

	public static void Eventos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					_9_Eventos_Disponibles window = new _9_Eventos_Disponibles();
					window.frame.setVisible(true);

			}
		});
	}

	public _9_Eventos_Disponibles() {
		initialize();
	}

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

		lblEventosDisponibles = new JLabel("EVENTOS DISPONIBLES:");
		lblEventosDisponibles.setFont(new Font("Dubai", Font.BOLD, 30));
		lblEventosDisponibles.setBounds(464, 10, 338, 54);
		panel.add(lblEventosDisponibles);

		btnCrearEvento = new JButton("CREA TU EVENTO");
		btnCrearEvento.setBorder(null);
		btnCrearEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearEvento.setBackground(new Color(176, 196, 222));
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearEvento.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearEvento.setBounds(779, 589, 162, 56);
		panel.add(btnCrearEvento);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_9_Eventos_Disponibles.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el bot�n sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(797, 10, 32, 52);
		panel.add(btnPregunta);

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setIcon(new ImageIcon(_9_Eventos_Disponibles.class.getResource("/images/home-icon.png")));
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
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Baloncesto", "Enrique Blas", "27/05/2022", "17:00", "Avanzado", "8" },
						{ "Padel", "Galapagar Sports", "20/08/2022", "18:00", "Principiante", "4" },
						{ "F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Medio", "11" },
						{ "Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Avanzado", "2" },
						{ "Padel", "Enrique Blas", "12/09/2022", "19:00", "Principiante", "4" },
						{ "F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Avanzado", "8" },
						{ "F\u00FAtbol", "El Torre\u00F3n", "03/08/2022", "16:00", "Medio", "12" },
						{ "Tenis", "Principe Felipe", "28/08/2022", "17:00", "Avanzado", "4" },
						{ "Baloncesto", "Gal-full Stadium", "10/08/2022", "16:00", "Medio", "12" },
						{ "Baloncesto", "Enrique Blas", "03/05/2022", "19:00", "Medio", "12" },
						{ "Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Principiante", "4" }, },
				new String[] { "Deporte", "Polideportivo", "Fecha", "Hora", "Nivel", "N\u00BA Usuarios" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(37);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		table.getColumnModel().getColumn(5).setPreferredWidth(68);
		scrollPane.setViewportView(table);

		btnUnirse = new JButton("UNIRSE");
		btnUnirse.setBorder(null);
		btnUnirse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUnirse.setEnabled(false);
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnirse.setFont(new Font("Dubai", Font.BOLD, 15));
		btnUnirse.setBounds(577, 589, 162, 56);
		btnUnirse.setBackground(new Color(176, 196, 222));
		panel.add(btnUnirse);

	}
}
