import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class Lanzadera {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadera window = new Lanzadera();
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
	public Lanzadera() {
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
		panel.setBounds(82, 11, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnBienvenido = new JButton("BIENVENIDO");
		btnBienvenido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_1_Bienvenido_a_SportsChoice pantalla = new _1_Bienvenido_a_SportsChoice();
				pantalla.Bienvenido();
			}
		});
		btnBienvenido.setFont(new Font("Dubai", Font.BOLD, 15));
		btnBienvenido.setBackground(new Color(176, 196, 222));
		btnBienvenido.setBounds(95, 103, 162, 56);
		panel.add(btnBienvenido);
		
		JButton btnNewButton_1 = new JButton("REGISTRARSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_2_Registrarse pantalla = new _2_Registrarse();
				pantalla.Registrarse();
			}
		});
		btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setBounds(293, 103, 162, 56);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html>RECUPERAR<br>\r\nCONTRASE\u00D1A</html>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_3_Recuperar_Contraseña pantalla = new _3_Recuperar_Contraseña();
				pantalla.Recuperar();
				
			}
		});
		btnNewButton_2.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(176, 196, 222));
		btnNewButton_2.setBounds(489, 103, 162, 56);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("NUEVA_CONTRASE\u00D1A");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_4_Nueva_Contraseña pantalla = new _4_Nueva_Contraseña();
				pantalla.Nueva();
			}
		});
		btnNewButton_3.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(176, 196, 222));
		btnNewButton_3.setBounds(694, 103, 162, 56);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("HOLA + NOMBRE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_5_Hola_Nombre pantalla = new _5_Hola_Nombre();
				pantalla.Hola();
			}
		});
		btnNewButton_4.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(176, 196, 222));
		btnNewButton_4.setBounds(904, 103, 162, 56);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("TU PERFIL");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_6_Tu_perfil pantalla = new _6_Tu_perfil();
				pantalla.Perfil();
			}
		});
		btnNewButton_5.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5.setBackground(new Color(176, 196, 222));
		btnNewButton_5.setBounds(95, 226, 162, 56);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("MIS EVENTOS");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_7_Mis_Eventos pantalla = new _7_Mis_Eventos();
				pantalla.Eventos();
			}
		});
		btnNewButton_5_1.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_1.setBackground(new Color(176, 196, 222));
		btnNewButton_5_1.setBounds(293, 226, 162, 56);
		panel.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("FORO");
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_8_Foro pantalla = new _8_Foro();
				pantalla.Foro();
			}
		});
		btnNewButton_5_2.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_2.setBackground(new Color(176, 196, 222));
		btnNewButton_5_2.setBounds(489, 226, 162, 56);
		panel.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("EVENTOS DISPONIBLES");
		btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_9_Eventos_Disponibles pantalla = new _9_Eventos_Disponibles();
				pantalla.Eventos();
			}
		});
		btnNewButton_5_3.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_3.setBackground(new Color(176, 196, 222));
		btnNewButton_5_3.setBounds(694, 226, 162, 56);
		panel.add(btnNewButton_5_3);
		
		JButton btnNewButton_5_4 = new JButton("CREAR EVENTO");
		btnNewButton_5_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_91_Crear_Evento pantalla = new _91_Crear_Evento();
				pantalla.Crear();
			}
		});
		btnNewButton_5_4.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_4.setBackground(new Color(176, 196, 222));
		btnNewButton_5_4.setBounds(904, 226, 162, 56);
		panel.add(btnNewButton_5_4);


	}
}
