package vistas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import controlador.Controlador;
import modelo.Modelo;

public class _2_Registrarse extends JFrame {

	private JPanel panel;
	private JLabel lblInformacionPersonal, lblNombreUsuario, lblNombre, lblApellidos, lblTelefono, lblEmail,
			lblPoblacion, lblRegistrarse, lblFechaNac, lblFondo, lblError;
	private JButton btnPregunta, btnFlecha, btnCrearCuenta;
	private JDateChooser dateChooserFechaNac;
	private JTextField txtNombreUsuario, txtTfno, txtNombre, txtContrasena, txtApellidos, txtConfirmarContrasena,
			txtPoblacion, txtEmail;
	private Controlador miControlador;
	private Modelo miModelo;
	

	public _2_Registrarse() {
		setTitle("REGISTRARSE");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				btnPregunta = new JButton("");
				btnPregunta.setContentAreaFilled(false);
				btnPregunta.setBorder(null);
				btnPregunta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "" + "No puedes dejar ningún campo vacío.      \r\n\n"
								+ "Presta atención al uso de mayúsculas \r\n"
								+ "y minúsculas \r\n\n",
								"AYUDA REGISTRO", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				btnPregunta.setBackground(new Color(255, 204, 153));
				btnPregunta.setIcon(new ImageIcon(_2_Registrarse.class.getResource("/images/pregunta-32x32.png")));
				btnPregunta.setOpaque(false);
				btnPregunta.setBorderPainted(false);
				btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
						btnPregunta.setForeground(new Color(0, 0, 0));
						btnPregunta.setBounds(380, 64, 32, 32);
						panel.add(btnPregunta);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblError.setForeground(Color.RED);
		lblError.setBounds(399, 531, 272, 31);
		panel.add(lblError);

		lblRegistrarse = new JLabel("REGISTRARSE");
		lblRegistrarse.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRegistrarse.setBounds(328, 11, 404, 44);
		panel.add(lblRegistrarse);

		lblInformacionPersonal = new JLabel("Informaci\u00F3n Personal: \r\n");
		lblInformacionPersonal.setFont(new Font("Dubai", Font.BOLD, 20));
		lblInformacionPersonal.setBounds(179, 65, 492, 31);
		panel.add(lblInformacionPersonal);

		lblNombreUsuario = new JLabel("NOMBRE USUARIO EN APP (Nickname):");
		lblNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombreUsuario.setBounds(179, 106, 278, 26);
		panel.add(lblNombreUsuario);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBorder(null);
		txtNombreUsuario.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(179, 130, 492, 40);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblNombre.setBounds(179, 178, 192, 26);
		panel.add(lblNombre);

		lblApellidos = new JLabel("APELLIDOS:");
		lblApellidos.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblApellidos.setBounds(446, 178, 192, 26);
		panel.add(lblApellidos);

		lblTelefono = new JLabel("CONTRASE\u00D1A:");
		lblTelefono.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblTelefono.setBounds(179, 248, 192, 26);
		panel.add(lblTelefono);

		lblEmail = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		lblEmail.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail.setBounds(446, 248, 192, 26);
		panel.add(lblEmail);

		lblPoblacion = new JLabel("TFNO");
		lblPoblacion.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion.setBounds(179, 318, 192, 26);
		panel.add(lblPoblacion);

		lblFechaNac = new JLabel("EMAIL:");
		lblFechaNac.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblFechaNac.setBounds(179, 458, 192, 26);
		panel.add(lblFechaNac);

		btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.setBorder(null);
		btnCrearCuenta.setBackground(new Color(176, 196, 222));
		btnCrearCuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.DatosRegistro();		
			}
		});
		btnCrearCuenta.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearCuenta.setBounds(509, 574, 162, 56);
		panel.add(btnCrearCuenta);

		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(2, 0);
			}
		});
		btnFlecha.setIcon(new ImageIcon(_2_Registrarse.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFlecha.setBounds(179, 574, 67, 56);
		panel.add(btnFlecha);

		dateChooserFechaNac = new JDateChooser();
		dateChooserFechaNac.setBorder(null);
		dateChooserFechaNac.setBounds(179, 410, 491, 40);
		panel.add(dateChooserFechaNac);

		txtTfno = new JTextField();
		txtTfno.setBorder(null);
		txtTfno.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtTfno.setColumns(10);
		txtTfno.setBounds(179, 340, 226, 40);
		panel.add(txtTfno);

		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNombre.setColumns(10);
		txtNombre.setBounds(179, 200, 226, 40);
		panel.add(txtNombre);

		txtContrasena = new JTextField();
		txtContrasena.setBorder(null);
		txtContrasena.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(179, 270, 226, 40);
		panel.add(txtContrasena);

		txtApellidos = new JTextField();
		txtApellidos.setBorder(null);
		txtApellidos.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(445, 200, 226, 40);
		panel.add(txtApellidos);

		txtConfirmarContrasena = new JTextField();
		txtConfirmarContrasena.setBorder(null);
		txtConfirmarContrasena.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtConfirmarContrasena.setColumns(10);
		txtConfirmarContrasena.setBounds(446, 270, 226, 40);
		panel.add(txtConfirmarContrasena);

		JLabel lblPoblacion_1 = new JLabel("POBLACI\u00D3N:");
		lblPoblacion_1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblPoblacion_1.setBounds(446, 318, 192, 26);
		panel.add(lblPoblacion_1);

		txtPoblacion = new JTextField();
		txtPoblacion.setBorder(null);
		txtPoblacion.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtPoblacion.setColumns(10);
		txtPoblacion.setBounds(446, 340, 226, 40);
		panel.add(txtPoblacion);

		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(179, 480, 492, 40);
		panel.add(txtEmail);

		JLabel lblEmail_1 = new JLabel("FECHA DE NACIMIENTO:");
		lblEmail_1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblEmail_1.setBounds(179, 385, 192, 26);
		panel.add(lblEmail_1);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_2_Registrarse.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-98, 0, 939, 683);
		panel.add(lblFondo);
	}
	
	// Label que saca por pantalla error al dejar campos vacíos.
	public void errorLabelCamposVacios() {
		lblError.setText("No puedes dejar campos vacíos");
	}
	
	// Label que saca por pantalla error al introducir contraseñas distintas.
	public void errorLabelPasswordsDistintas() {
		lblError.setText("Las contraseñas no coinciden");
	}
	
	// Label que saca por pantalla error al intentar registrar un usuario que ya existe.
	public void errorUsuarioExistente() {
		lblError.setText("El usuario introducido ya existe");
	}
	
/**Getters y Setters de los campos del formulario*/
	public String getNombreUsuario() {
		return txtNombreUsuario.getText();
	}
	
	public String getNombre() {
		return txtNombre.getText();
	}
	
	public String getApellidos() {
		return txtApellidos.getText();
	}
	
	public Date getFechaNacimiento() {
		return dateChooserFechaNac.getDate();
	}
	
	public String getTelefono() {
		return txtTfno.getText();
	}

	public String getContrasena() {
		return txtContrasena.getText();
	}
	public String getConfirmarContrasena() {
		return txtConfirmarContrasena.getText();
	}

	public String getPoblacion() {
		return txtPoblacion.getText();
	}
	
	public String getEmail() {
		return txtEmail.getText();
	}

	/**Getters y Setters del controlador y modelo*/
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	public JLabel getLblError() {
		return lblError;
	}
	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	

	
}
