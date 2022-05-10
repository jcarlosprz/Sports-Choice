import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class _6_Tu_perfil {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblInformacionPersonal, lblNombreUsuario, lblNombre, lblApellidos, lblTelefono, lblEmail,
			lblPoblacion, lblPerfil, lblFechaNac, lblTuPerfil;
	private JTextField txtNombreUsuario, txtNombre, txtApellidos, txtTelefono, txtEmail, txtPoblacion;
	private JButton btnPregunta, btnPapelera, btnHome, btnGuardar;
	private JDateChooser dateChooserFechaNac;

	public static void Perfil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_6_Tu_perfil window = new _6_Tu_perfil();
				window.frame.setVisible(true);
			}
		});
	}

	public _6_Tu_perfil() {
		initialize();
	}

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

		lblTuPerfil = new JLabel("TU PERFIL");
		lblTuPerfil.setFont(new Font("Dubai", Font.BOLD, 30));
		lblTuPerfil.setBounds(520, 10, 152, 44);
		panel.add(lblTuPerfil);

		lblInformacionPersonal = new JLabel("Informaci\u00F3n Personal: \r\n");
		lblInformacionPersonal.setFont(new Font("Dubai", Font.BOLD, 20));
		lblInformacionPersonal.setBounds(326, 64, 194, 31);
		panel.add(lblInformacionPersonal);

		lblNombreUsuario = new JLabel("NOMBRE USUARIO EN APP:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(455, 105, 192, 26);
		panel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setEnabled(false);
		txtNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(455, 128, 392, 40);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombre.setBounds(455, 170, 192, 26);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(455, 193, 392, 40);
		panel.add(txtNombre);

		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblApellidos.setBounds(455, 235, 192, 26);
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(455, 258, 392, 40);
		panel.add(txtApellidos);

		lblTelefono = new JLabel("TEL\u00C9FONO:");
		lblTelefono.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblTelefono.setBounds(455, 300, 192, 26);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtTelefono.setBounds(455, 323, 392, 40);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail.setBounds(455, 365, 192, 26);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtEmail.setBounds(455, 388, 392, 40);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		lblPoblacion = new JLabel("POBLACI\u00D3N:");
		lblPoblacion.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion.setBounds(455, 430, 192, 26);
		panel.add(lblPoblacion);

		txtPoblacion = new JTextField();
		txtPoblacion.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtPoblacion.setBounds(455, 453, 392, 40);
		panel.add(txtPoblacion);
		txtPoblacion.setColumns(10);

		lblFechaNac = new JLabel("FECHA NACIMIENTO:");
		lblFechaNac.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblFechaNac.setBounds(455, 503, 192, 26);
		panel.add(lblFechaNac);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(176, 196, 222));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnGuardar.setBounds(779, 589, 162, 56);
		panel.add(btnGuardar);

		btnPregunta = new JButton("");
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el botón sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(530, 64, 32, 32);
		panel.add(btnPregunta);

		lblPerfil = new JLabel("");
		lblPerfil.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/profile-icon.png")));
		lblPerfil.setBounds(682, 10, 45, 44);
		panel.add(lblPerfil);

		btnPapelera = new JButton("");
		btnPapelera.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/papelera.png")));
		btnPapelera.setBounds(326, 572, 71, 74);
		panel.add(btnPapelera);

		btnPapelera.setOpaque(false);
		btnPapelera.setContentAreaFilled(false);
		btnPapelera.setBorderPainted(false);
		btnPapelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(896, 10, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBounds(455, 527, 392, 40);
		panel.add(dateChooserFechaNac);

	}
}
