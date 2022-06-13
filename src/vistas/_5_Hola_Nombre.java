package vistas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class _5_Hola_Nombre extends JFrame {

	private JPanel panel;
	private JButton btnBaloncesto, btnFutbol, btnPadel, btnTenis, btnMisEventos, btnMiPerfil, btnLogOut;
	private JLabel lblHolaNombre, lblBaloncesto, lblFutbol, lblPadel, lblTenis, lblPregunta, lblFondo;
	
	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblHola;
	


	public _5_Hola_Nombre() {
		setTitle("HOLA + NOMBRE");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		
		lblHolaNombre = new JLabel();
		lblHolaNombre.setFont(new Font("Dubai", Font.BOLD, 45));
		lblHolaNombre.setBounds(407, 22, 297, 60);
		panel.add(lblHolaNombre);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lblHolaNombre.setText(miModelo.getHolaNombreUsuario());
			}
		});
		
		
		lblHola = new JLabel();
		lblHola.setText("Hola");
		lblHola.setFont(new Font("Dubai", Font.BOLD, 45));
		lblHola.setBounds(299, 22, 105, 60);
		panel.add(lblHola);
		
		
		btnBaloncesto = new JButton("");
		btnBaloncesto.setBorder(null);
		btnBaloncesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 10);
				miModelo.TablaEventosBaloncesto();
			}
		});
		btnBaloncesto.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/Basket_resized.png")));
		btnBaloncesto.setBounds(226, 136, 180, 180);
		panel.add(btnBaloncesto);
		btnBaloncesto.setBackground(new Color(0, 0, 0, 0));
		btnBaloncesto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBaloncesto.setOpaque(false);

		btnFutbol = new JButton("");
		btnFutbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 10);
				miModelo.TablaEventosFutbol();
			}
		});
		btnFutbol.setBorder(null);
		btnFutbol.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/Futbol_resized.png")));
		btnFutbol.setOpaque(false);
		btnFutbol.setBackground(new Color(0, 0, 0, 0));
		btnFutbol.setBounds(452, 136, 180, 180);
		btnFutbol.setBackground(new Color(0, 0, 0, 0));
		btnFutbol.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFutbol.setOpaque(false);
		panel.add(btnFutbol);

		btnPadel = new JButton("");
		btnPadel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 10);
				miModelo.TablaEventosPadel();
			}
		});
		btnPadel.setBorder(null);
		btnPadel.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/padel_resized.png")));
		btnPadel.setOpaque(false);
		btnPadel.setBackground(new Color(0, 0, 0, 0));
		btnPadel.setBounds(226, 340, 180, 180);
		btnPadel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPadel.setOpaque(false);
		panel.add(btnPadel);

		btnTenis = new JButton("");
		btnTenis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 10);
				miModelo.TablaEventosTenis();
			}
		});
		btnTenis.setBorder(null);
		btnTenis.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/tennis_ball_resized.png")));
		btnTenis.setOpaque(false);
		btnTenis.setBounds(452, 340, 180, 180);
		btnTenis.setBackground(new Color(0, 0, 0, 0));
		btnTenis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTenis.setOpaque(false);
		panel.add(btnTenis);

		lblBaloncesto = new JLabel("BALONCESTO");
		lblBaloncesto.setFont(new Font("Dubai", Font.BOLD, 15));
		lblBaloncesto.setBounds(272, 297, 105, 19);
		panel.add(lblBaloncesto);

		lblFutbol = new JLabel("F\u00DATBOL");
		lblFutbol.setFont(new Font("Dubai", Font.BOLD, 15));
		lblFutbol.setBounds(516, 297, 64, 19);
		panel.add(lblFutbol);

		lblPadel = new JLabel("PADEL");
		lblPadel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblPadel.setBounds(299, 501, 55, 19);
		panel.add(lblPadel);

		lblTenis = new JLabel("TENIS");
		lblTenis.setFont(new Font("Dubai", Font.BOLD, 15));
		lblTenis.setBounds(525, 501, 55, 19);
		panel.add(lblTenis);

		lblPregunta = new JLabel("\u00BFQu\u00E9 deporte te gustar\u00EDa practicar?");
		lblPregunta.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 23));
		lblPregunta.setBounds(246, 71, 367, 40);
		panel.add(lblPregunta);

		btnMisEventos = new JButton("MIS EVENTOS");
		btnMisEventos.setBorder(null);
		btnMisEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMisEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 8);

			}
		});
		btnMisEventos.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMisEventos.setBackground(new Color(176, 196, 222));
		btnMisEventos.setBounds(264, 602, 142, 59);
		panel.add(btnMisEventos);

		btnMiPerfil = new JButton("MI PERFIL");
		btnMiPerfil.setBorder(null);
		btnMiPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 7);
				//
				//
				//
				//
				//
			
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				miModelo.tuPerfil();
			}
		});
		
		
		btnMiPerfil.setFont(new Font("Dubai", Font.BOLD, 15));
		btnMiPerfil.setBackground(new Color(176, 196, 222));
		btnMiPerfil.setBounds(471, 602, 142, 59);
		panel.add(btnMiPerfil);

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(6, 0);
			}
		});
		btnLogOut.setBorder(null);
		btnLogOut.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogOut.setBackground(new Color(250, 128, 114));
		btnLogOut.setBounds(36, 621, 105, 40);
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnLogOut);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_5_Hola_Nombre.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-104, 0, 939, 683);
		panel.add(lblFondo);

	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
