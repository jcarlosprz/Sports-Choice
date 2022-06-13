package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class _1_Bienvenido_a_SportsChoice extends JFrame {

	private JPanel panel;
	public JLabel lblNombreUsuario, lblSubtitulo, lblBienvenido, lblSportsChoice, lblContrasena, lblOlvidasteContrasena,
			lblFondo, lblRegistrarse, lblNoTienesCuenta, lblRespuesta;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnAyuda, btnLogin, btnConfiguracion;

	private Controlador miControlador;
	private Modelo miModelo;

	public _1_Bienvenido_a_SportsChoice() {
		setResizable(false);
		setTitle("BIENVENIDO");
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 856, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnConfiguracion = new JButton("");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(0, 1);
			}
		});
		btnConfiguracion
				.setIcon(new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/rueda (1).png")));
		btnConfiguracion.setBounds(591, 595, 32, 32);
		btnConfiguracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnConfiguracion);

		lblRespuesta = new JLabel("");
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRespuesta.setForeground(Color.RED);
		lblRespuesta.setBackground(Color.WHITE);
		lblRespuesta.setBounds(308, 400, 316, 27);
		panel.add(lblRespuesta);

		btnAyuda = new JButton("");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "" + "Bienvenido a Sports-Choice, una aplicación para conocer             \r\n"
						+ "gente nueva a la vez que practicas tus deportes favoritos.\r\n\n"
						+ "Para utilizar la aplicación solo necesitas un ordenador con\r\n"
						+ "navegación web y una cuenta asociada con tus datos.\r\n"
						+ "Sports-Choice se basa en un servicio web que gestiona \r\n"
						+ "las peticiones de multitud de usuarios para desarrollar \r\n"
						+ "tus actividades deportivas favoritas.\r\n\n"
						+ "Se trata de una aplicación visual e interactiva muy fácil \r\n"
						+ "de usar, con la que incluso los menos acostumbrados \r\n"
						+ "a las nuevas tecnologías podrán usarla sin ningún \r\n"
						+ "problema. Existen muchas aplicaciones fitness y \r\n"
						+ "deportivas, pero ninguna fue nunca tan social y divertida\r\n"
						+ "como Sports Choice. \r\n\n"
						+ "Tu app personalizada para practicar deporte cuando \r\n" 
						+ "y donde quieras. \r\n\n",
						"AYUDA SPORTS CHOICE", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAyuda.setIcon(new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/pregunta-32x32.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(255, 204, 153));
		btnAyuda.setBounds(551, 595, 32, 32);
		btnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnAyuda);

		lblNoTienesCuenta = new JLabel("\u00BFNo tienes una cuenta?");
		lblNoTienesCuenta.setForeground(Color.BLACK);
		lblNoTienesCuenta.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblNoTienesCuenta.setBounds(295, 552, 186, 22);
		panel.add(lblNoTienesCuenta);

		lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarPantalla(0, 3);
			}
		});
		lblRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrarse.setForeground(new Color(0, 0, 204));
		lblRegistrarse.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblRegistrarse.setBounds(468, 552, 100, 22);
		panel.add(lblRegistrarse);

		lblOlvidasteContrasena = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		lblOlvidasteContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarPantalla(0, 4);
			}
		});
		lblOlvidasteContrasena.setForeground(new Color(0, 0, 204));
		lblOlvidasteContrasena.setFont(new Font("Dubai", Font.PLAIN, 17));
		lblOlvidasteContrasena.setBounds(394, 375, 206, 22);
		lblOlvidasteContrasena.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(lblOlvidasteContrasena);

		lblBienvenido = new JLabel("BIENVENIDO A");
		lblBienvenido.setFont(new Font("Dubai", Font.BOLD, 52));
		lblBienvenido.setBounds(246, 48, 358, 44);
		panel.add(lblBienvenido);

		lblSportsChoice = new JLabel("SPORTS-CHOICE");
		lblSportsChoice.setFont(new Font("Dubai", Font.BOLD, 52));
		lblSportsChoice.setBounds(226, 89, 398, 59);
		panel.add(lblSportsChoice);

		lblSubtitulo = new JLabel("Tu app para practicar deporte y hacer nuevos amigos");
		lblSubtitulo.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 20));
		lblSubtitulo.setBounds(180, 143, 490, 40);
		panel.add(lblSubtitulo);

		lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNombreUsuario.setBounds(145, 259, 120, 44);
		panel.add(lblNombreUsuario);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtUsuario.getText().isEmpty() || String.valueOf(txtContrasena.getPassword()).isEmpty()) {
					btnLogin.setEnabled(false);
				} else {
					btnLogin.setEnabled(true);
				}
			}
		});
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(267, 263, 316, 40);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Dubai", Font.BOLD, 15));
		lblContrasena.setBounds(145, 326, 120, 44);
		panel.add(lblContrasena);

		txtContrasena = new JPasswordField();
		txtContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtUsuario.getText().isEmpty() || String.valueOf(txtContrasena.getPassword()).isEmpty()) {
					btnLogin.setEnabled(false);
				} else {
					btnLogin.setEnabled(true);
				}
			}

			// Permite que se pueda realizar el login pulsando la tecla enter.
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					miControlador.login();
				}
			}
		});
		txtContrasena.setBorder(null);
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(267, 330, 316, 40);
		panel.add(txtContrasena);

		btnLogin = new JButton("LOGIN");
		btnLogin.setEnabled(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(176, 196, 222));
		btnLogin.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				miControlador.login();
			}

		});

		btnLogin.setBounds(267, 438, 316, 59);
		panel.add(btnLogin);
		lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/Imagen_deportesss_tuneada.png")));
		lblFondo.setBounds(156, 48, 801, 626);
		panel.add(lblFondo);
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getUsr() {
		return txtUsuario.getText();
	}

	public String getPwd() {
		return String.valueOf(txtContrasena.getPassword());
	}

	public void inactivoError() {
		lblRespuesta.setText("Este usuario está bloqueado");
		txtContrasena.setText("");
		txtUsuario.setText("");
		btnLogin.setEnabled(false);
	}

	public void actualizar() {
		String resultado = miModelo.getResultado();
		String rol = miModelo.getRol();

		if (resultado.equals("Correcto")) {
			if (rol.equals("administrador")) {
				miControlador.cambiarPantalla(0, 2);
			} else {
				miControlador.cambiarPantalla(0, 6);
			}
		} else {
			if (resultado.equals("Incorrecto")) {
				lblRespuesta.setText("Usuario o contraseña incorrectos");
				txtContrasena.setText("");
				txtUsuario.setText("");
				btnLogin.setEnabled(false);
			} else {
				System.exit(0);
			}
		}
	}

}
