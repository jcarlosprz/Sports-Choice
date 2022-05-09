import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class _5_Hola_Nombre {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblRecuperarContraseña;
	private JButton btnBaloncesto;
	private JButton btnFutbol;
	private JButton btnPadel;
	private JButton btnTenis;
	private JButton btnMisEventos;
	private JButton btnMiPerfil;
	private JButton btnLogOut;

	/**
	 * Launch the application.
	 */
	public static void Hola() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_5_Hola_Nombre window = new _5_Hola_Nombre();
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
	public _5_Hola_Nombre() {
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
		panel.setBounds(75, 0, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblRecuperarContraseña = new JLabel("HOLA + \"NOMBRE\"");
		lblRecuperarContraseña.setFont(new Font("Dubai", Font.BOLD, 45));
		lblRecuperarContraseña.setBounds(442, 23, 589, 60);
		panel.add(lblRecuperarContraseña);
		
		btnBaloncesto = new JButton("");
		btnBaloncesto.setBorder(null);
		btnBaloncesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaloncesto.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/BASKET_PEDRO.png")));
		btnBaloncesto.setBounds(433, 121, 180, 180);
		panel.add(btnBaloncesto);
		btnBaloncesto.setBackground(new Color(0,0,0,0));
		btnBaloncesto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBaloncesto.setOpaque(false);
		
		btnFutbol = new JButton("");
		btnFutbol.setBorder(null);
		btnFutbol.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/Football (1).png")));
		btnFutbol.setOpaque(false);
		btnFutbol.setBackground(new Color(0, 0, 0, 0));
		btnFutbol.setBounds(653, 121, 180, 180);
		btnFutbol.setBackground(new Color(0,0,0,0));
		btnFutbol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFutbol.setOpaque(false);
		panel.add(btnFutbol);
		
		
		btnPadel = new JButton("");
		btnPadel.setBorder(null);
		btnPadel.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/padel (4).png")));
		btnPadel.setOpaque(false);
		btnPadel.setBackground(new Color(0, 0, 0, 0));
		btnPadel.setBounds(433, 340, 180, 180);
		btnPadel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPadel.setOpaque(false);
		panel.add(btnPadel);
		
		btnTenis = new JButton("");
		btnTenis.setBorder(null);
		btnTenis.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/tennis_ball (2).png")));
		btnTenis.setOpaque(false);
		btnTenis.setBounds(653, 340, 180, 180);
		btnTenis.setBackground(new Color(0,0,0,0));
		btnTenis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTenis.setOpaque(false);
		panel.add(btnTenis);
		
		JLabel lblNewLabel = new JLabel("BALONCESTO");
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNewLabel.setBounds(480, 311, 105, 19);
		panel.add(lblNewLabel);
		
		JLabel lblFtbol = new JLabel("F\u00DATBOL");
		lblFtbol.setFont(new Font("Dubai", Font.BOLD, 15));
		lblFtbol.setBounds(717, 311, 64, 19);
		panel.add(lblFtbol);
		
		JLabel lblPadel = new JLabel("PADEL");
		lblPadel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblPadel.setBounds(513, 530, 55, 19);
		panel.add(lblPadel);
		
		JLabel lblTenis = new JLabel("TENIS");
		lblTenis.setFont(new Font("Dubai", Font.BOLD, 15));
		lblTenis.setBounds(717, 530, 55, 19);
		panel.add(lblTenis);
		
		JLabel lblquDeporteTe = new JLabel("\u00BFQu\u00E9 deporte te gustar\u00EDa practicar?");
		lblquDeporteTe.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 23));
		lblquDeporteTe.setBounds(452, 72, 367, 40);
		panel.add(lblquDeporteTe);
		
		btnMisEventos = new JButton("MIS EVENTOS");
		btnMisEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMisEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMisEventos.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMisEventos.setBackground(new Color(176, 196, 222));
		btnMisEventos.setBounds(480, 592, 142, 59);
		panel.add(btnMisEventos);
		
		btnMiPerfil = new JButton("MI PERFIL");
		btnMiPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiPerfil.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMiPerfil.setBackground(new Color(176, 196, 222));
		btnMiPerfil.setBounds(653, 592, 142, 59);
		panel.add(btnMiPerfil);
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogOut.setBackground(new Color(250, 128, 114));
		btnLogOut.setBounds(38, 611, 105, 40);
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnLogOut);
	}
}
