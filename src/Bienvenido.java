import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Color;

public class Bienvenido {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido window = new Bienvenido();
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
	public Bienvenido() {
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
		panel.setBounds(0, 0, 1266, 683);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelBienvenido_1 = new JLabel("BIENVENIDO A");
		labelBienvenido_1.setFont(new Font("Dubai", Font.BOLD, 52));
		labelBienvenido_1.setBounds(454, 35, 358, 44);
		panel.add(labelBienvenido_1);
		
		JLabel labelBienvenido_1_1 = new JLabel("SPORTS-CHOICE");
		labelBienvenido_1_1.setFont(new Font("Dubai", Font.BOLD, 52));
		labelBienvenido_1_1.setBounds(434, 80, 398, 59);
		panel.add(labelBienvenido_1_1);
		
		JLabel labelSubtitulo = new JLabel("Tu app para practicar deporte y hacer nuevos amigos");
		labelSubtitulo.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 20));
		labelSubtitulo.setBounds(392, 135, 490, 40);
		panel.add(labelSubtitulo);
	}
}
