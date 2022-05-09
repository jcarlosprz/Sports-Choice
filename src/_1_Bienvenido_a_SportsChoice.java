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

public class _1_Bienvenido_a_SportsChoice {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNombreUsuario, lblSubtitulo, lblBienvenido, lblSportsChoice, lblContraseña,
			lblOlvidasteContraseña, lblFondo;
	private JTextField txtUsuario, txtContraseña;
	private JRadioButton rdbtnRecordarme;
	private JButton btnRegistrarse, btnAyuda, btnLogin;

	/**
	 * Launch the application.
	 */
	public static void Bienvenido() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_1_Bienvenido_a_SportsChoice window = new _1_Bienvenido_a_SportsChoice();
				window.frame.setVisible(true);
			}
		});
	}

	public _1_Bienvenido_a_SportsChoice() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(140, 50, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblOlvidasteContraseña = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		lblOlvidasteContraseña.setForeground(new Color(0, 0, 204));
		lblOlvidasteContraseña.setFont(new Font("Dubai", Font.PLAIN, 16));
		lblOlvidasteContraseña.setBounds(619, 375, 172, 22);
		panel.add(lblOlvidasteContraseña);

		lblBienvenido = new JLabel("BIENVENIDO A");
		lblBienvenido.setFont(new Font("Dubai", Font.BOLD, 52));
		lblBienvenido.setBounds(454, 48, 358, 44);
		panel.add(lblBienvenido);

		lblSportsChoice = new JLabel("SPORTS-CHOICE");
		lblSportsChoice.setFont(new Font("Dubai", Font.BOLD, 52));
		lblSportsChoice.setBounds(434, 89, 398, 59);
		panel.add(lblSportsChoice);

		lblSubtitulo = new JLabel("Tu app para practicar deporte y hacer nuevos amigos");
		lblSubtitulo.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 20));
		lblSubtitulo.setBounds(390, 143, 490, 40);
		panel.add(lblSubtitulo);

		lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNombreUsuario.setBounds(363, 260, 120, 44);
		panel.add(lblNombreUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(475, 263, 316, 40);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Dubai", Font.BOLD, 15));
		lblContraseña.setBounds(363, 327, 120, 44);
		panel.add(lblContraseña);

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(475, 330, 316, 40);
		panel.add(txtContraseña);

		rdbtnRecordarme = new JRadioButton("Recordarme");
		rdbtnRecordarme.setFont(new Font("Dubai", Font.PLAIN, 16));
		rdbtnRecordarme.setBounds(475, 376, 142, 21);
		panel.add(rdbtnRecordarme);
		rdbtnRecordarme.setBackground(new Color(0, 0, 0, 0));
		rdbtnRecordarme.setOpaque(false);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(176, 196, 222));
		btnLogin.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(653, 428, 142, 59);
		panel.add(btnLogin);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBackground(new Color(176, 196, 222));
		btnRegistrarse.setFont(new Font("Dubai", Font.BOLD, 15));
		btnRegistrarse.setBounds(471, 428, 142, 59);
		panel.add(btnRegistrarse);
		lblFondo = new JLabel("");
		lblFondo.setIcon(
				new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/Imagen_deportesss_tuneada.png")));
		lblFondo.setBounds(363, 47, 801, 626);
		panel.add(lblFondo);

		btnAyuda = new JButton("");
		btnAyuda.setIcon(new ImageIcon(_1_Bienvenido_a_SportsChoice.class.getResource("/images/pregunta-32x32.png")));
		btnAyuda.setOpaque(false);
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setBackground(new Color(255, 204, 153));
		btnAyuda.setBounds(951, 613, 32, 32);
		panel.add(btnAyuda);
	}
}
