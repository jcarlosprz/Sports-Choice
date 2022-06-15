package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import controlador.Controlador;
import modelo.Modelo;

import java.awt.Dimension;

public class _9_Eventos_Disponibles extends JFrame {

	private JPanel panel;
	private JButton btnPregunta, btnHome, btnCrearEvento, btnUnirse;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblEventosDisponibles;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;

	public _9_Eventos_Disponibles() {
		setTitle("EVENTOS DISPONIBLES");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblEventosDisponibles = new JLabel("EVENTOS DISPONIBLES:");
		lblEventosDisponibles.setFont(new Font("Dubai", Font.BOLD, 30));
		lblEventosDisponibles.setBounds(254, 8, 338, 54);
		panel.add(lblEventosDisponibles);

		btnCrearEvento = new JButton("CREA TU EVENTO");
		btnCrearEvento.setBorder(null);
		btnCrearEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearEvento.setBackground(new Color(176, 196, 222));
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(10, 11);
			}
		});
		btnCrearEvento.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearEvento.setBounds(457, 591, 162, 56);
		panel.add(btnCrearEvento);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "" + "Desde esta ventana podrás ver los eventos \r\n"
						+ "disponibles para ti. \r\n\n"
						+ "Además, seleccionando uno de ellos, podrás \r\n"
						+ "pinchar el botón 'Unirse' que se encuentra \r\n"
						+ "en la parte inferior. De este modo podrás \r\n"
						+ "comenzar a practicar tu deporte favorito.\r\n\n"
						+ "También tienes el botón de 'Crear tu evento'\r\n"
						+ "en caso de que ninguno de los eventos\r\n"
						+ "disponibles encaje con lo que estás buscando.        \r\n\n", "AYUDA EVENTOS DISPONIBLES", JOptionPane.INFORMATION_MESSAGE);
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
		btnPregunta.setBounds(602, 8, 32, 52);
		panel.add(btnPregunta);

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(10, 6);
			}
		});
		btnHome.setIcon(new ImageIcon(_9_Eventos_Disponibles.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(700, 38, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(106, 93, 640, 476);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
					btnUnirse.setEnabled(false);
				} else {
					btnUnirse.setEnabled(true);
				}
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(miModelo.getTablaEventosBaloncesto());
			}
		});
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		btnUnirse = new JButton("UNIRSE");
		btnUnirse.setBorder(null);
		btnUnirse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUnirse.setEnabled(false);
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(10, 8);
			}
		});
		btnUnirse.setFont(new Font("Dubai", Font.BOLD, 15));
		btnUnirse.setBounds(240, 591, 162, 56);
		btnUnirse.setBackground(new Color(176, 196, 222));
		panel.add(btnUnirse);

		lblFondo = new JLabel("");

		lblFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnUnirse.setEnabled(false);
				table.clearSelection();
			}
		});

		lblFondo.setIcon(new ImageIcon(_9_Eventos_Disponibles.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-134, -10, 969, 693);
		panel.add(lblFondo);
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
