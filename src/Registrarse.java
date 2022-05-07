import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;

public class Registrarse {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblInformacinPersonal;
	private JLabel lblNombreUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JTextField txtPoblacion;
	private JLabel lblPoblacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse window = new Registrarse();
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
	public Registrarse() {
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 10, 1266, 683);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRegistrarse.setBounds(520, 10, 303, 44);
		panel.add(lblRegistrarse);
		
		lblInformacinPersonal = new JLabel("Informaci\u00F3n Personal: \r\n");
		lblInformacinPersonal.setFont(new Font("Dubai", Font.BOLD, 20));
		lblInformacinPersonal.setBounds(326, 64, 194, 40);
		panel.add(lblInformacinPersonal);
		
		lblNombreUsuario = new JLabel("NOMBRE USUARIO EN APP:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(455, 105, 192, 26);
		panel.add(lblNombreUsuario);
		
		txtNombreUsuario = new JTextField();
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
		
		JLabel lblFechaNac = new JLabel("FECHA NACIMIENTO:");
		lblFechaNac.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblFechaNac.setBounds(455, 509, 192, 26);
		panel.add(lblFechaNac);
	}
}
