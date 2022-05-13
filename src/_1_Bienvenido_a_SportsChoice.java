import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _1_Bienvenido_a_SportsChoice extends JFrame {

	private JPanel panel;
	private JLabel lblNombreUsuario, lblSubtitulo, lblBienvenido, lblSportsChoice, lblContrasena,
			lblOlvidasteContrasena, lblFondo;
	private JTextField txtUsuario, txtContrasena;
	private JRadioButton rdbtnRecordarme;
	private JButton btnRegistrarse, btnAyuda, btnLogin;

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

		lblOlvidasteContrasena = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		lblOlvidasteContrasena.setForeground(new Color(0, 0, 204));
		lblOlvidasteContrasena.setFont(new Font("Dubai", Font.PLAIN, 16));
		lblOlvidasteContrasena.setBounds(411, 375, 172, 22);
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
		lblNombreUsuario.setBounds(156, 260, 120, 44);
		panel.add(lblNombreUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(267, 263, 316, 40);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Dubai", Font.BOLD, 15));
		lblContrasena.setBounds(156, 327, 120, 44);
		panel.add(lblContrasena);

		txtContrasena = new JTextField();
		txtContrasena.setBorder(null);
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(267, 330, 316, 40);
		panel.add(txtContrasena);

		rdbtnRecordarme = new JRadioButton("Recordarme");
		rdbtnRecordarme.setFont(new Font("Dubai", Font.PLAIN, 16));
		rdbtnRecordarme.setBounds(267, 376, 142, 21);
		panel.add(rdbtnRecordarme);
		rdbtnRecordarme.setBackground(new Color(0, 0, 0, 0));
		rdbtnRecordarme.setOpaque(false);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(176, 196, 222));
		btnLogin.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(441, 428, 142, 59);
		panel.add(btnLogin);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBorder(null);
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBackground(new Color(176, 196, 222));
		btnRegistrarse.setFont(new Font("Dubai", Font.BOLD, 15));
		btnRegistrarse.setBounds(267, 428, 142, 59);
		panel.add(btnRegistrarse);
		lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/Imagen_deportesss_tuneada.png")));
		lblFondo.setBounds(156, 48, 801, 626);
		panel.add(lblFondo);

		btnAyuda = new JButton("");
		btnAyuda.setIcon(new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/pregunta-32x32.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(255, 204, 153));
		btnAyuda.setBounds(951, 613, 32, 32);
		btnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnAyuda);
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
