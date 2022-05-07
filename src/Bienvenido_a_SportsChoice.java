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


public class Bienvenido_a_SportsChoice {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNombreUsuario;
	private JTextField txtUsuario;
	private JLabel labelSubtitulo;
	private JLabel labelBienvenido;
	private JLabel labelBienvenido_1;
	private JLabel lblNombreUsuario_1;
	private JTextField txtContraseña;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnRecordarme;
	private JButton btnRegistrarse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido_a_SportsChoice window = new Bienvenido_a_SportsChoice();
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
	public Bienvenido_a_SportsChoice() {
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
		panel.setBounds(0, 0, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 16));
		lblNewLabel.setBounds(619, 375, 172, 22);
		panel.add(lblNewLabel);
		
		labelBienvenido = new JLabel("BIENVENIDO A");
		labelBienvenido.setFont(new Font("Dubai", Font.BOLD, 52));
		labelBienvenido.setBounds(454, 48, 358, 44);
		panel.add(labelBienvenido);
		
		labelBienvenido_1 = new JLabel("SPORTS-CHOICE");
		labelBienvenido_1.setFont(new Font("Dubai", Font.BOLD, 52));
		labelBienvenido_1.setBounds(434, 89, 398, 59);
		panel.add(labelBienvenido_1);
		
		labelSubtitulo = new JLabel("Tu app para practicar deporte y hacer nuevos amigos");
		labelSubtitulo.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 20));
		labelSubtitulo.setBounds(390, 143, 490, 40);
		panel.add(labelSubtitulo);
		
		lblNombreUsuario = new JLabel("Nombre usuario:");
		lblNombreUsuario.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNombreUsuario.setBounds(363, 260, 120, 44);
		panel.add(lblNombreUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(475, 263, 316, 40);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		lblNombreUsuario_1 = new JLabel("Contrase\u00F1a:");
		lblNombreUsuario_1.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNombreUsuario_1.setBounds(363, 327, 120, 44);
		panel.add(lblNombreUsuario_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(475, 330, 316, 40);
		panel.add(txtContraseña);
		
		rdbtnRecordarme = new JRadioButton("Recordarme");
		rdbtnRecordarme.setFont(new Font("Dubai", Font.PLAIN, 16));
		rdbtnRecordarme.setBounds(475, 376, 142, 21);
		panel.add(rdbtnRecordarme);
		rdbtnRecordarme.setBackground(new Color(0,0,0,0));
		rdbtnRecordarme.setOpaque(false);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(653, 428, 142, 59);
		panel.add(btnNewButton);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarse.setBackground(new Color(176, 196, 222));
		btnRegistrarse.setFont(new Font("Dubai", Font.BOLD, 15));
		btnRegistrarse.setBounds(471, 428, 142, 59);
		panel.add(btnRegistrarse);
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\U-tad\\git\\prog---tarea-1---aplicacion-swing-pi-ratatui\\img\\Imagen_deportesss_tuneada.png"));
		lblFondo.setBounds(363, 47, 801, 626);
		panel.add(lblFondo);
	}
}
