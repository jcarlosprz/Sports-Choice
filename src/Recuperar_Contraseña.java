import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Recuperar_Contraseña {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblIntroduceEmail;
	private JTextField txtEmail;
	private JLabel lblRecuperarContraseña;
	private JTextField txtCódigo;
	private JButton btnFlecha;
	private JButton btnFlecha_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recuperar_Contraseña window = new Recuperar_Contraseña();
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
	public Recuperar_Contraseña() {
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
		
		btnFlecha = new JButton("");
		btnFlecha.setIcon(new ImageIcon(Recuperar_Contraseña.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(308, 589, 106, 56);
		panel.add(btnFlecha);

		lblRecuperarContraseña = new JLabel("RECUPERAR CONTRASE\u00D1A");
		lblRecuperarContraseña.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRecuperarContraseña.setBounds(445, 17, 376, 60);
		panel.add(lblRecuperarContraseña);

		lblIntroduceEmail = new JLabel(
				"Introduce tu email y te enviaremos el c\u00F3digo para crear una nueva contrase\u00F1a:");
		lblIntroduceEmail.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceEmail.setBounds(384, 136, 549, 26);
		panel.add(lblIntroduceEmail);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(384, 166, 487, 40);
		panel.add(txtEmail);

		JLabel lblIntroduceElCdigo = new JLabel("Introduce el c\u00F3digo recibido:");
		lblIntroduceElCdigo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceElCdigo.setBounds(384, 242, 549, 26);
		panel.add(lblIntroduceElCdigo);

		txtCódigo = new JTextField();
		txtCódigo.setToolTipText("");
		txtCódigo.setColumns(10);
		txtCódigo.setBounds(384, 272, 182, 40);
		panel.add(txtCódigo);

		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnValidar.setBackground(new Color(176, 196, 222));
		btnValidar.setBounds(779, 589, 162, 56);
		panel.add(btnValidar);
		
		btnFlecha_1 = new JButton("");
		btnFlecha_1.setOpaque(false);
		btnFlecha_1.setContentAreaFilled(false);
		btnFlecha_1.setBorderPainted(false);
		btnFlecha_1.setBounds(308, 571, 106, 56);
		panel.add(btnFlecha_1);
	}
}