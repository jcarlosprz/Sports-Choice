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

public class _2_Registrarse {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblInformacionPersonal, lblNombreUsuario, lblNombre, lblApellidos, lblTelefono, lblEmail,
			lblPoblacion, lblRegistrarse, lblFechaNac;
	private JTextField txtNombreUsuario;
	private JButton btnPregunta, btnFlecha, btnCrearCuenta;
	private JDateChooser dateChooserFechaNac;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void Registrarse() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_2_Registrarse window = new _2_Registrarse();
				window.frame.setVisible(true);
			}
		});
	}

	public _2_Registrarse() {
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

		lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRegistrarse.setBounds(520, 10, 303, 44);
		panel.add(lblRegistrarse);

		lblInformacionPersonal = new JLabel("Informaci\u00F3n Personal: \r\n");
		lblInformacionPersonal.setFont(new Font("Dubai", Font.BOLD, 20));
		lblInformacionPersonal.setBounds(326, 64, 194, 31);
		panel.add(lblInformacionPersonal);

		lblNombreUsuario = new JLabel("NOMBRE USUARIO EN APP:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(389, 106, 192, 26);
		panel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(388, 130, 492, 40);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombre.setBounds(389, 170, 192, 26);
		panel.add(lblNombre);

		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblApellidos.setBounds(654, 170, 192, 26);
		panel.add(lblApellidos);

		lblTelefono = new JLabel("CONTRASE\u00D1A:");
		lblTelefono.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblTelefono.setBounds(389, 244, 192, 26);
		panel.add(lblTelefono);

		lblEmail = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		lblEmail.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail.setBounds(654, 244, 192, 26);
		panel.add(lblEmail);

		lblPoblacion = new JLabel("TFNO");
		lblPoblacion.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion.setBounds(389, 316, 192, 26);
		panel.add(lblPoblacion);

		lblFechaNac = new JLabel("EMAIL:");
		lblFechaNac.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblFechaNac.setBounds(389, 467, 192, 26);
		panel.add(lblFechaNac);

		btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.setBackground(new Color(176, 196, 222));
		btnCrearCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearCuenta.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearCuenta.setBounds(718, 574, 162, 56);
		panel.add(btnCrearCuenta);

		btnPregunta = new JButton("");
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_2_Registrarse.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el botón sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(530, 64, 32, 32);
		panel.add(btnPregunta);

		btnFlecha = new JButton("");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFlecha.setIcon(new ImageIcon(_2_Registrarse.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFlecha.setBounds(389, 574, 106, 56);
		panel.add(btnFlecha);

		dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBounds(389, 416, 491, 40);
		panel.add(dateChooserFechaNac);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(389, 341, 226, 40);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(389, 193, 226, 40);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(389, 265, 226, 40);
		panel.add(textField_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(654, 193, 226, 40);
		panel.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(654, 265, 226, 40);
		panel.add(textField_4);
		
		JLabel lblPoblacion_1 = new JLabel("POBLACI\u00D3N:");
		lblPoblacion_1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion_1.setBounds(654, 316, 192, 26);
		panel.add(lblPoblacion_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(654, 341, 226, 40);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dubai", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(388, 490, 492, 40);
		panel.add(textField_6);
		
		JLabel lblEmail_1 = new JLabel("FECHA DE NACIMIENTO:");
		lblEmail_1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail_1.setBounds(389, 392, 192, 26);
		panel.add(lblEmail_1);
	}
}
