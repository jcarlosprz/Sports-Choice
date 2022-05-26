import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _2_Bienvenido_admin extends JFrame {

	private JPanel panel;
	private JButton btnDesbloquear;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblBienvenidoAdmin;

	private Controlador miControlador;
	private Modelo miModelo;
	private JButton btnLogOut;
	private JButton btnBloquear;

	public _2_Bienvenido_admin() {
		setTitle("BIENVENIDO ADMINISTRADOR");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblBienvenidoAdmin = new JLabel("BIENVENIDO ADMINISTRADOR");
		lblBienvenidoAdmin.setFont(new Font("Dubai", Font.BOLD, 30));
		lblBienvenidoAdmin.setBounds(207, 11, 471, 54);
		panel.add(lblBienvenidoAdmin);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(46, 71, 743, 490);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(table.getSelectedRow() == -1) {
					btnBloquear.setEnabled(false);
					btnDesbloquear.setEnabled(false);
				} else {
					btnBloquear.setEnabled(true);
					btnDesbloquear.setEnabled(true);
				}
			}
		});
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setShowVerticalLines(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] { { "JPS", "Jaime", "P\u00E9rez S\u00E1nchez", "japesa@hotmail.com" },
						{ "DGP", "Daniel", "Gonz\u00E1lez P\u00E9rez", "dangonper@hotmail.com" },
						{ "JPR", "Jos\u00E9", "Pascual Rodr\u00EDguez", "joparo@gmail.com" },
						{ "IMG", "In\u00E9s", "Mart\u00EDnez Guti\u00E9rrez", "inmargut@gmail.com" },
						{ "RRM", "Rodrigo", "Rodr\u00EDguez Moreno", "rodromo@gmail.com" },
						{ "MSE", "Mar\u00EDa", "Salda\u00F1a Espinosa", "masalesp@yahoo.es" },
						{ "MBC", "Manuel", "Berbis Campos", "manberca@gmail.com" },
						{ "PFO", "Pedro", "Flores Ortiz", "peflortiz@yahoo.es" },
						{ "SBP", "Susana", "Ben\u00EDte Prado", "subepra@gmail.com" },
						{ "CAE", "Clara", "Alonso Espina", "clalonespi@yahoo.es" },
						{ "NSF", "Nacho", "S\u00E1nchez Fern\u00E1ndez", "nasafer@hotmail.com" }, },
				new String[] { "Nickname", "Nombre", "Apellidos", "E-mail" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110); // Nickname
		table.getColumnModel().getColumn(1).setPreferredWidth(120); // Nombre
		table.getColumnModel().getColumn(2).setPreferredWidth(160); // Apellidos
		table.getColumnModel().getColumn(3).setPreferredWidth(330); // Email
		scrollPane.setViewportView(table);

		btnDesbloquear = new JButton("DESBLOQUEAR");
		btnDesbloquear.setEnabled(false);
		btnDesbloquear.setBorder(null);
		btnDesbloquear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDesbloquear.setFont(new Font("Dubai", Font.BOLD, 15));
		btnDesbloquear.setBounds(627, 589, 162, 56);
		btnDesbloquear.setBackground(new Color(176, 196, 222));
		panel.add(btnDesbloquear);

		btnBloquear = new JButton("BLOQUEAR");
		btnBloquear.setEnabled(false);
		btnBloquear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBloquear.setFont(new Font("Dubai", Font.BOLD, 15));
		btnBloquear.setBorder(null);
		btnBloquear.setBackground(new Color(176, 196, 222));
		btnBloquear.setBounds(433, 589, 162, 56);
		panel.add(btnBloquear);

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setFont(new Font("Dubai", Font.BOLD, 15));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(250, 128, 114));
		btnLogOut.setBounds(46, 590, 163, 54);
		panel.add(btnLogOut);

		JLabel lblFondo = new JLabel("");
		
		lblFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnBloquear.setEnabled(false);
				btnDesbloquear.setEnabled(false);
				table.clearSelection();
			}
		});
		
		lblFondo.setIcon(new ImageIcon(_2_Bienvenido_admin.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-104, 0, 939, 683);
		panel.add(lblFondo);

		
		
		
		

		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				table.setModel(miModelo.getTabla());
			}
		});
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
