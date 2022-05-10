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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class _8_Foro {

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextField txtEscribeAqui;
	private JTable table;
	private JLabel lblEscribeAqui;
	private JButton btnFlecha, btnEnviar;

	public static void Foro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				_8_Foro window = new _8_Foro();
				window.frame.setVisible(true);
			}
		});
	}

	public _8_Foro() {
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

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBorder(null);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnFlecha = new JButton("");
		btnFlecha.setBorder(null);
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFlecha.setIcon(new ImageIcon(_8_Foro.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(205, 589, 106, 56);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnFlecha);
		btnEnviar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnEnviar.setBounds(885, 589, 142, 63);
		panel.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(223, 48, 806, 322);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Dubai", Font.PLAIN, 15));

		table.setRowHeight(100);
		table.setModel(new DefaultTableModel(new Object[][] { { "<html>Usuario 1:<br> Buen partido </html>" },
				{ "<html>Usuario 2:<br> El usuario 1 hace trampas se inventa las reglas </html> " },
				{ "<html>Usuario 3:<br> No vuelvo a jugar con los usuario 1 y 2 solo saben discutir </html>" },
				{ "<html>Usuario 4:<br> El usuario 3 me ha perdido mi raqueta </html>" },

		}, new String[] { "Foro" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(615);
		scrollPane.setViewportView(table);

		txtEscribeAqui = new JTextField();
		txtEscribeAqui.setBounds(223, 431, 806, 122);
		panel.add(txtEscribeAqui);
		txtEscribeAqui.setColumns(10);

		lblEscribeAqui = new JLabel("Escribe aqui: ");
		lblEscribeAqui.setFont(new Font("Dubai", Font.BOLD, 15));
		lblEscribeAqui.setBounds(223, 405, 167, 26);
		panel.add(lblEscribeAqui);

	}
}
