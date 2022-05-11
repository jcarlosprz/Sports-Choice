import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class _3_Recuperar_Contrasena {

	private JFrame frmRecuperarContrasena;
	private JPanel panel;
	private JTextField txtEmail,txtCodigo;
	private JLabel lblRecuperarContrasena, lblIntroduceEmail;
	private JButton btnFlecha, btnFlecha_1;


	public static void Recuperar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					_3_Recuperar_Contrasena window = new _3_Recuperar_Contrasena();
					window.frmRecuperarContrasena.setVisible(true);
			}
		});
	}
	public _3_Recuperar_Contrasena() {
		initialize();
	}

	private void initialize() {
		frmRecuperarContrasena = new JFrame();
		frmRecuperarContrasena.setTitle("RECUPERAR CONTRASENA");
		frmRecuperarContrasena.setResizable(false);
		frmRecuperarContrasena.setBounds(140, 50, 850, 720);
		frmRecuperarContrasena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecuperarContrasena.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		frmRecuperarContrasena.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		lblIntroduceEmail = new JLabel(
				"Introduce tu email y te enviaremos el codigo para crear una nueva contraseña:");
		lblIntroduceEmail.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceEmail.setBounds(175, 131, 549, 26);
		panel.add(lblIntroduceEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(175, 167, 336, 40);
		panel.add(txtEmail);

		JLabel lblIntroduceElCdigo = new JLabel("Introduce el codigo recibido:");
		lblIntroduceElCdigo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblIntroduceElCdigo.setBounds(175, 237, 549, 26);
		panel.add(lblIntroduceElCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBorder(null);
		txtCodigo.setToolTipText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(175, 273, 336, 40);
		panel.add(txtCodigo);

		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.setBorder(null);
		btnValidar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnValidar.setBackground(new Color(176, 196, 222));
		btnValidar.setBounds(536, 589, 162, 56);
		btnValidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnValidar);
		
		btnFlecha_1 = new JButton("");
		btnFlecha_1.setOpaque(false);
		btnFlecha_1.setContentAreaFilled(false);
		btnFlecha_1.setBorderPainted(false);
		btnFlecha_1.setBounds(308, 571, 106, 56);
		panel.add(btnFlecha_1);
		
		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprobar.setBorder(null);
		btnComprobar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnComprobar.setBackground(new Color(176, 196, 222));
		btnComprobar.setBounds(536, 167, 162, 40);
		btnComprobar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnComprobar);
	}
}