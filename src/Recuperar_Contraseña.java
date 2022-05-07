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
import com.toedter.calendar.JCalendar;

public class Recuperar_Contraseña {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblIntroduceEmail;
	private JTextField txtEmail;
	private JLabel lblRecuperarContraseña;

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
		
		lblRecuperarContraseña = new JLabel("RECUPERAR CONTRASE\u00D1A");
		lblRecuperarContraseña.setFont(new Font("Dubai", Font.BOLD, 52));
		lblRecuperarContraseña.setBounds(320, 48, 626, 60);
		panel.add(lblRecuperarContraseña);
		
		lblIntroduceEmail = new JLabel("Introduce tu email y te enviaremos el c\u00F3digo para crear una nueva contrase\u00F1a:");
		lblIntroduceEmail.setFont(new Font("Dubai", Font.BOLD, 16));
		lblIntroduceEmail.setBounds(384, 166, 498, 26);
		panel.add(lblIntroduceEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(384, 196, 487, 40);
		panel.add(txtEmail);
	}
}
