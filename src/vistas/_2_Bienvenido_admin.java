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
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.Modelo;
import modelo.exportarTablas;

import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class _2_Bienvenido_admin extends JFrame {

	private JPanel panel;
	private JButton btnDesbloquear;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblBienvenidoAdmin;

	private Controlador miControlador;
	private Modelo miModelo;
	private JButton btnLogOut;
	private JButton btnBloquear;
	private JButton btnDownload;
	private JButton btnUpload;

	public _2_Bienvenido_admin() {
		setTitle("BIENVENIDO ADMINISTRADOR");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblBienvenidoAdmin = new JLabel("BIENVENIDO ADMINISTRADOR");
		lblBienvenidoAdmin.setFont(new Font("Dubai", Font.BOLD, 30));
		lblBienvenidoAdmin.setBounds(207, 11, 471, 54);
		panel.add(lblBienvenidoAdmin);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(46, 71, 743, 490);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
					btnBloquear.setEnabled(false);
					btnDesbloquear.setEnabled(false);
				} else {
					btnBloquear.setEnabled(true);
					btnDesbloquear.setEnabled(true);
				}
			}

		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(miModelo.getTablaAdmin());
			}
		});

		scrollPane.setViewportView(table);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setShowVerticalLines(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		btnDesbloquear = new JButton("DESBLOQUEAR");
		btnDesbloquear.setEnabled(false);
		btnDesbloquear.setBorder(null);
		btnDesbloquear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDesbloquear.setFont(new Font("Dubai", Font.BOLD, 15));
		btnDesbloquear.setBounds(627, 589, 162, 56);
		btnDesbloquear.setBackground(new Color(176, 196, 222));
		panel.add(btnDesbloquear);

		btnBloquear = new JButton("BLOQUEAR");
		btnBloquear.setEnabled(false);
		btnBloquear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBloquear.setFont(new Font("Dubai", Font.BOLD, 15));
		btnBloquear.setBorder(null);
		btnBloquear.setBackground(new Color(176, 196, 222));
		btnBloquear.setBounds(433, 589, 162, 56);
		panel.add(btnBloquear);

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(2, 0);
			}
		});
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(250, 128, 114));
		btnLogOut.setBounds(46, 590, 163, 54);
		panel.add(btnLogOut);

		btnDownload = new JButton("Download");
		btnDownload.setFont(new Font("Dubai", Font.BOLD, 12));
		btnDownload.setBorder(null);
		btnDownload.setBackground(new Color(176, 196, 222));
		btnDownload.setBounds(336, 590, 68, 56);
		btnDownload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnDownload);
		btnDownload.addActionListener(new ActionListener() {
            public void actionPerformed (final ActionEvent d) {
                miModelo.guardarObjeto();
            }});

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Dubai", Font.BOLD, 12));
		btnUpload.setBorder(null);
		btnUpload.setBackground(new Color(176, 196, 222));
		btnUpload.setBounds(246, 589, 68, 56);
		btnUpload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnUpload);
		btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed (final ActionEvent d) {
            	miModelo.cargarObjeto();
            }});
		

		JLabel lblFondo = new JLabel("");

		lblFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnBloquear.setEnabled(false);
				btnDesbloquear.setEnabled(false);
				table.clearSelection();
			}
		});

		lblFondo.setIcon(new ImageIcon(_2_Bienvenido_admin.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-104, 0, 939, 683);
		panel.add(lblFondo);
	}
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}

}
