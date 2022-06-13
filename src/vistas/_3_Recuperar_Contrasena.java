package vistas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import controlador.Controlador;
import modelo.Modelo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _3_Recuperar_Contrasena extends JFrame {

	private JPanel panel;
	private JTextField txtEmail, txtCodigo;
	private JLabel lblRecuperarContrasena, lblIntroduceEmail;
	private JButton btnFlecha, btnFlecha_1;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;

	public _3_Recuperar_Contrasena() {
		setTitle("RECUPERAR CONTRASENA");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(4, 0);
			}
		});
		btnFlecha.setIcon(new ImageIcon(_3_Recuperar_Contrasena.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(149, 589, 106, 56);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnFlecha);

		lblRecuperarContrasena = new JLabel("RECUPERAR CONTRASE\u00D1A");
		lblRecuperarContrasena.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRecuperarContrasena.setBounds(229, 21, 376, 60);
		panel.add(lblRecuperarContrasena);

		lblIntroduceEmail = new JLabel("Introduce tu email y te enviaremos el codigo para crear una nueva contraseña:");
		lblIntroduceEmail.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceEmail.setBounds(175, 163, 549, 26);
		panel.add(lblIntroduceEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(175, 200, 336, 59);
		panel.add(txtEmail);

		JLabel lblIntroduceElCdigo = new JLabel("Introduce el código recibido:");
		lblIntroduceElCdigo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceElCdigo.setBounds(175, 324, 549, 26);
		panel.add(lblIntroduceElCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBorder(null);
		txtCodigo.setToolTipText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(175, 361, 336, 60);
		panel.add(txtCodigo);

		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(4, 5);
			}
		});
		btnValidar.setBorder(null);
		btnValidar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnValidar.setBackground(new Color(176, 196, 222));
		btnValidar.setBounds(536, 362, 162, 59);
		btnValidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnValidar);

		btnFlecha_1 = new JButton("");
		btnFlecha_1.setOpaque(false);
		btnFlecha_1.setContentAreaFilled(false);
		btnFlecha_1.setBorderPainted(false);
		btnFlecha_1.setBounds(308, 571, 106, 56);
		panel.add(btnFlecha_1);

		JButton btnComprobar = new JButton("ENVIAR");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprobar.setBorder(null);
		btnComprobar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnComprobar.setBackground(new Color(176, 196, 222));
		btnComprobar.setBounds(536, 200, 162, 59);
		btnComprobar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnComprobar);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_3_Recuperar_Contrasena.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-103, 0, 939, 683);
		panel.add(lblFondo);
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}