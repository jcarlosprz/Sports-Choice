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

public class _4_Nueva_Contraseña {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNuevaContraseñaTitulo, lblNuevaContraseña, lblRepetirContraseña, lblConsejoTitulo, lblConsejo1,
			lblConsejo2, lblConsejo3;
	private JTextField txtNuevaContraseña, txtRepetirContraseña;
	private JButton btnFlecha, btnActualizar;

	public static void Nueva() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_4_Nueva_Contraseña window = new _4_Nueva_Contraseña();
				window.frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public _4_Nueva_Contraseña() {
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

		lblNuevaContraseñaTitulo = new JLabel("NUEVA CONTRASE\u00D1A");
		lblNuevaContraseñaTitulo.setFont(new Font("Dubai", Font.BOLD, 30));
		lblNuevaContraseñaTitulo.setBounds(479, 17, 308, 60);
		panel.add(lblNuevaContraseñaTitulo);

		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBorder(null);
		btnActualizar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(176, 196, 222));
		btnActualizar.setBounds(723, 589, 162, 56);
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnActualizar);

		txtNuevaContraseña = new JTextField();
		txtNuevaContraseña.setBorder(null);
		txtNuevaContraseña.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNuevaContraseña.setColumns(10);
		txtNuevaContraseña.setBounds(478, 145, 407, 40);
		panel.add(txtNuevaContraseña);

		lblNuevaContraseña = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContraseña.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblNuevaContraseña.setBounds(336, 144, 122, 44);
		panel.add(lblNuevaContraseña);

		txtRepetirContraseña = new JTextField();
		txtRepetirContraseña.setBorder(null);
		txtRepetirContraseña.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtRepetirContraseña.setColumns(10);
		txtRepetirContraseña.setBounds(478, 232, 407, 40);
		panel.add(txtRepetirContraseña);

		lblRepetirContraseña = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContraseña.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblRepetirContraseña.setBounds(336, 231, 128, 44);
		panel.add(lblRepetirContraseña);

		lblConsejoTitulo = new JLabel("Consejo:");
		lblConsejoTitulo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblConsejoTitulo.setBounds(397, 319, 67, 44);
		panel.add(lblConsejoTitulo);

		lblConsejo1 = new JLabel("La contrase\u00F1a debe contener al menos 6 caracteres.");
		lblConsejo1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo1.setBounds(479, 331, 432, 21);
		panel.add(lblConsejo1);

		lblConsejo3 = new JLabel("y min\u00FAsculas, n\u00FAmeros y s\u00EDmbolos como ! \" ? $ %. ");
		lblConsejo3.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo3.setBounds(479, 375, 432, 21);
		panel.add(lblConsejo3);

		lblConsejo2 = new JLabel("Para hacerla m\u00E1s fuerte se recomienda utilizar may\u00FAsculas ");
		lblConsejo2.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo2.setBounds(479, 352, 465, 21);
		panel.add(lblConsejo2);

		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFlecha.setIcon(new ImageIcon(_4_Nueva_Contraseña.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(317, 589, 106, 56);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnFlecha);
	}
}
