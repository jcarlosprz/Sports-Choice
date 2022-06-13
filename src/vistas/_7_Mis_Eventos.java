package vistas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

import java.awt.Dimension;

public class _7_Mis_Eventos extends JFrame {

	private JPanel panel;
	private JButton btnPregunta, btnHome, btnAbandonar, btnIrAlForo;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblMisEventos;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;

	public _7_Mis_Eventos() {
		setTitle("MIS EVENTOS");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblMisEventos = new JLabel("MIS EVENTOS");
		lblMisEventos.setFont(new Font("Dubai", Font.BOLD, 30));
		lblMisEventos.setBounds(327, 8, 192, 54);
		panel.add(lblMisEventos);

		btnAbandonar = new JButton("ABANDONAR");
		btnAbandonar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.BorrarFilaTablaMisEventos();
			}
		});
		btnAbandonar.setBorder(null);
		btnAbandonar.setEnabled(false);
		btnAbandonar.setBackground(new Color(176, 196, 222));
		btnAbandonar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		btnAbandonar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnAbandonar.setBounds(457, 591, 162, 56);
		panel.add(btnAbandonar);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/pregunta-32x32.png")));
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(528, 8, 32, 52);
		panel.add(btnPregunta);

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(8, 6);
			}
		});
		btnHome.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(700, 38, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(106, 93, 640, 476);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRow() == -1) {
					btnIrAlForo.setEnabled(false);
					btnAbandonar.setEnabled(false);
				} else {
					btnIrAlForo.setEnabled(true);
					btnAbandonar.setEnabled(true);
				}
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(miModelo.getTablaMisEventos());
			}
		});
	
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setToolTipText("");
		table.setFocusTraversalKeysEnabled(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		btnIrAlForo = new JButton("IR AL FORO");
		btnIrAlForo.setBorder(null);
		btnIrAlForo.setEnabled(false);
		btnIrAlForo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIrAlForo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(8, 9);
			}
		});
		btnIrAlForo.setFont(new Font("Dubai", Font.BOLD, 15));
		btnIrAlForo.setBounds(240, 591, 162, 56);
		btnIrAlForo.setBackground(new Color(176, 196, 222));
		panel.add(btnIrAlForo);
		
		lblFondo = new JLabel("");
		lblFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnAbandonar.setEnabled(false);
				btnIrAlForo.setEnabled(false);
				table.clearSelection();
			}
		});
		lblFondo.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-93, 0, 939, 683);
		panel.add(lblFondo);
	}
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
