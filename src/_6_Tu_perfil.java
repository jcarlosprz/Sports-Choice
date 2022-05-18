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

public class _6_Tu_perfil extends JFrame {

	private JPanel panel;
	private JLabel lblInformacionPersonal, lblNombreUsuario, lblNombre, lblApellidos, lblTelefono, lblEmail,
			lblPoblacion, lblPerfil, lblFechaNac, lblTuPerfil;
	private JTextField txtNombreUsuario, txtNombre, txtApellidos, txtTelefono, txtEmail, txtPoblacion;
	private JButton btnPregunta, btnPapelera, btnHome, btnGuardar;
	private JDateChooser dateChooserFechaNac;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;

	public _6_Tu_perfil() {
		setTitle("TU PERFIL");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblTuPerfil = new JLabel("TU PERFIL");
		lblTuPerfil.setFont(new Font("Dubai", Font.BOLD, 30));
		lblTuPerfil.setBounds(345, 11, 152, 44);
		panel.add(lblTuPerfil);

		lblInformacionPersonal = new JLabel("Informaci\u00F3n Personal: \r\n");
		lblInformacionPersonal.setFont(new Font("Dubai", Font.BOLD, 20));
		lblInformacionPersonal.setBounds(163, 65, 433, 31);
		panel.add(lblInformacionPersonal);

		lblNombreUsuario = new JLabel("NOMBRE USUARIO EN APP (Nickname):");
		lblNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(163, 105, 284, 26);
		panel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setEnabled(false);
		txtNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(163, 128, 525, 40);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombre.setBounds(163, 177, 192, 26);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(163, 200, 525, 40);
		panel.add(txtNombre);

		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblApellidos.setBounds(163, 247, 192, 26);
		panel.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBorder(null);
		txtApellidos.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(163, 267, 525, 40);
		panel.add(txtApellidos);

		lblTelefono = new JLabel("TEL\u00C9FONO:");
		lblTelefono.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblTelefono.setBounds(163, 317, 192, 26);
		panel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBorder(null);
		txtTelefono.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtTelefono.setBounds(163, 340, 525, 40);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail.setBounds(163, 387, 192, 26);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtEmail.setBounds(163, 410, 525, 40);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		lblPoblacion = new JLabel("POBLACI\u00D3N:");
		lblPoblacion.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion.setBounds(163, 525, 192, 26);
		panel.add(lblPoblacion);

		txtPoblacion = new JTextField();
		txtPoblacion.setBorder(null);
		txtPoblacion.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtPoblacion.setBounds(163, 550, 525, 40);
		panel.add(txtPoblacion);
		txtPoblacion.setColumns(10);

		lblFechaNac = new JLabel("FECHA NACIMIENTO:");
		lblFechaNac.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblFechaNac.setBounds(163, 457, 192, 26);
		panel.add(lblFechaNac);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(176, 196, 222));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 5);

			}
		});
		btnGuardar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnGuardar.setBounds(526, 611, 162, 56);
		panel.add(btnGuardar);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
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
		btnPregunta.setBounds(367, 60, 32, 32);
		panel.add(btnPregunta);

		lblPerfil = new JLabel("");
		lblPerfil.setBorder(null);
		lblPerfil.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/profile-icon.png")));
		lblPerfil.setBounds(496, 10, 45, 44);
		panel.add(lblPerfil);

		btnPapelera = new JButton("");
		btnPapelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 0);
			}
		});
		btnPapelera.setBorder(null);
		btnPapelera.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/papelera.png")));
		btnPapelera.setBounds(163, 611, 51, 56);
		panel.add(btnPapelera);

		btnPapelera.setOpaque(false);
		btnPapelera.setContentAreaFilled(false);
		btnPapelera.setBorderPainted(false);
		btnPapelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 5);
			}
		});
		btnHome.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(645, 65, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBorder(null);
		dateChooserFechaNac.setBounds(163, 480, 525, 40);
		panel.add(dateChooserFechaNac);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_6_Tu_perfil.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-99, 0, 939, 683);
		panel.add(lblFondo);
	}
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
