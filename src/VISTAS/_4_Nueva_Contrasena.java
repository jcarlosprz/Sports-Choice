package VISTAS;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;

import Controlador.Controlador;
import Modelo.Modelo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _4_Nueva_Contrasena extends JFrame {

	private JPanel panel;
	private JLabel lblNuevaContrasenaTitulo, lblNuevaContrasena, lblRepetirContrasena, lblConsejoTitulo, lblConsejo1,
			lblConsejo2, lblConsejo3;
	private JTextField txtNuevaContrasena, txtRepetirContrasena;
	private JButton btnFlecha, btnActualizar;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;
	
	public _4_Nueva_Contrasena() {
		setTitle("NUEVA CONTRASENA");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNuevaContrasenaTitulo = new JLabel("NUEVA CONTRASE\u00D1A");
		lblNuevaContrasenaTitulo.setFont(new Font("Dubai", Font.BOLD, 30));
		lblNuevaContrasenaTitulo.setBounds(279, 10, 308, 60);
		panel.add(lblNuevaContrasenaTitulo);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(4, 0);
			}
		});
		btnActualizar.setBorder(null);
		btnActualizar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(176, 196, 222));
		btnActualizar.setBounds(532, 589, 162, 56);
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnActualizar);

		txtNuevaContrasena = new JTextField();
		txtNuevaContrasena.setBorder(null);
		txtNuevaContrasena.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNuevaContrasena.setColumns(10);
		txtNuevaContrasena.setBounds(287, 145, 407, 40);
		panel.add(txtNuevaContrasena);

		lblNuevaContrasena = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasena.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblNuevaContrasena.setBounds(155, 144, 122, 44);
		panel.add(lblNuevaContrasena);

		txtRepetirContrasena = new JTextField();
		txtRepetirContrasena.setBorder(null);
		txtRepetirContrasena.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtRepetirContrasena.setColumns(10);
		txtRepetirContrasena.setBounds(287, 231, 407, 40);
		panel.add(txtRepetirContrasena);

		lblRepetirContrasena = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasena.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblRepetirContrasena.setBounds(149, 230, 128, 44);
		panel.add(lblRepetirContrasena);

		lblConsejoTitulo = new JLabel("Consejo:");
		lblConsejoTitulo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblConsejoTitulo.setBounds(210, 319, 67, 44);
		panel.add(lblConsejoTitulo);

		lblConsejo1 = new JLabel("La contrase\u00F1a debe contener al menos 6 caracteres.");
		lblConsejo1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo1.setBounds(287, 331, 432, 21);
		panel.add(lblConsejo1);

		lblConsejo3 = new JLabel("y min\u00FAsculas, n\u00FAmeros y s\u00EDmbolos como ! \" ? $ %. ");
		lblConsejo3.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo3.setBounds(291, 381, 432, 21);
		panel.add(lblConsejo3);

		lblConsejo2 = new JLabel("Para hacerla m\u00E1s fuerte se recomienda utilizar may\u00FAsculas ");
		lblConsejo2.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo2.setBounds(287, 356, 465, 21);
		panel.add(lblConsejo2);

		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(4, 3);
			}
		});
		btnFlecha.setIcon(new ImageIcon(_4_Nueva_Contrasena.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(133, 589, 106, 56);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnFlecha);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_4_Nueva_Contrasena.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-124, 0, 939, 693);
		panel.add(lblFondo);
	}
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
