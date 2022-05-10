import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _5_Hola_Nombre {

	private JFrame frame;
	private JPanel panel;
	private JButton btnBaloncesto, btnFutbol, btnPadel, btnTenis, btnMisEventos, btnMiPerfil, btnLogOut;
	private JLabel lblHolaNombre, lblBaloncesto, lblFutbol, lblPadel, lblTenis, lblPregunta;

	public static void Hola() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_5_Hola_Nombre window = new _5_Hola_Nombre();
				window.frame.setVisible(true);
			}
		});
	}

	public _5_Hola_Nombre() {
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

		lblHolaNombre = new JLabel("HOLA + \"NOMBRE\"");
		lblHolaNombre.setFont(new Font("Dubai", Font.BOLD, 45));
		lblHolaNombre.setBounds(442, 23, 589, 60);
		panel.add(lblHolaNombre);

		btnBaloncesto = new JButton("");
		btnBaloncesto.setBorder(null);
		btnBaloncesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaloncesto.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/BASKET_PEDRO.png")));
		btnBaloncesto.setBounds(433, 121, 180, 180);
		panel.add(btnBaloncesto);
		btnBaloncesto.setBackground(new Color(0, 0, 0, 0));
		btnBaloncesto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBaloncesto.setOpaque(false);

		btnFutbol = new JButton("");
		btnFutbol.setBorder(null);
		btnFutbol.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/FootballResized.png")));
		btnFutbol.setOpaque(false);
		btnFutbol.setBackground(new Color(0, 0, 0, 0));
		btnFutbol.setBounds(653, 121, 180, 180);
		btnFutbol.setBackground(new Color(0, 0, 0, 0));
		btnFutbol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFutbol.setOpaque(false);
		panel.add(btnFutbol);

		btnPadel = new JButton("");
		btnPadel.setBorder(null);
		btnPadel.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/padel_resized.png")));
		btnPadel.setOpaque(false);
		btnPadel.setBackground(new Color(0, 0, 0, 0));
		btnPadel.setBounds(442, 340, 180, 180);
		btnPadel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPadel.setOpaque(false);
		panel.add(btnPadel);

		btnTenis = new JButton("");
		btnTenis.setBorder(null);
		btnTenis.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/tennis_ball_resized.png")));
		btnTenis.setOpaque(false);
		btnTenis.setBounds(653, 340, 180, 180);
		btnTenis.setBackground(new Color(0, 0, 0, 0));
		btnTenis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTenis.setOpaque(false);
		panel.add(btnTenis);

		lblBaloncesto = new JLabel("BALONCESTO");
		lblBaloncesto.setFont(new Font("Dubai", Font.BOLD, 15));
		lblBaloncesto.setBounds(483, 282, 105, 19);
		panel.add(lblBaloncesto);

		lblFutbol = new JLabel("F\u00DATBOL");
		lblFutbol.setFont(new Font("Dubai", Font.BOLD, 15));
		lblFutbol.setBounds(717, 282, 64, 19);
		panel.add(lblFutbol);

		lblPadel = new JLabel("PADEL");
		lblPadel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblPadel.setBounds(514, 501, 55, 19);
		panel.add(lblPadel);

		lblTenis = new JLabel("TENIS");
		lblTenis.setFont(new Font("Dubai", Font.BOLD, 15));
		lblTenis.setBounds(717, 501, 55, 19);
		panel.add(lblTenis);

		lblPregunta = new JLabel("\u00BFQu\u00E9 deporte te gustar\u00EDa practicar?");
		lblPregunta.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 23));
		lblPregunta.setBounds(452, 72, 367, 40);
		panel.add(lblPregunta);

		btnMisEventos = new JButton("MIS EVENTOS");
		btnMisEventos.setBorder(null);
		btnMisEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMisEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMisEventos.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMisEventos.setBackground(new Color(176, 196, 222));
		btnMisEventos.setBounds(452, 592, 142, 59);
		panel.add(btnMisEventos);

		btnMiPerfil = new JButton("MI PERFIL");
		btnMiPerfil.setBorder(null);
		btnMiPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiPerfil.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMiPerfil.setBackground(new Color(176, 196, 222));
		btnMiPerfil.setBounds(677, 592, 142, 59);
		panel.add(btnMiPerfil);

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBorder(null);
		btnLogOut.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogOut.setBackground(new Color(250, 128, 114));
		btnLogOut.setBounds(38, 611, 105, 40);
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnLogOut);
	}
}
