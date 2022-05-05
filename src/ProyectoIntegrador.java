import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ProyectoIntegrador {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoIntegrador window = new ProyectoIntegrador();
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
	public ProyectoIntegrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 754, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "name_7143046108939");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenidos a");
		lblNewLabel.setBounds(251, 27, 123, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sport Choice");
		lblNewLabel_1.setBounds(251, 55, 94, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tu App para practicar deporte y conocer nuevos amigos");
		lblNewLabel_2.setBounds(155, 94, 356, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre Usuario");
		lblNewLabel_3.setBounds(155, 139, 113, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(155, 167, 94, 16);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(300, 134, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 167, 130, 26);
		panel.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("Recordarme");
		lblNewLabel_5.setBounds(145, 209, 123, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("¿Olvidaste la contraseña?");
		lblNewLabel_6.setBounds(313, 209, 168, 16);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(132, 277, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBounds(324, 277, 117, 29);
		panel.add(btnNewButton_1);
	}
}
