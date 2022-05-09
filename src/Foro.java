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
import javax.swing.JSplitPane;

public class Foro {

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Foro window = new Foro();
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
	public Foro() {
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

		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton.setBounds(789, 587, 162, 56);
		panel.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(313, 48, 640, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		table.setRowHeight(100);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Usuario 1: Buen partido"},
				{"Usuario 2: El usuario 1 hace trampas se inventa las reglas "},
				{"Usuario 3: No vuelvo a jugar con los usuario 1 y 2 solo saben discutir "},
				{"Usuario 4: El usuario 3 me ha perdido mi raqueta"},
			
			},
			new String[] {
				"Foro"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(615);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(313, 422, 638, 122);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Escribe aqui: ");
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNewLabel.setBounds(313, 394, 167, 26);
		panel.add(lblNewLabel);


	}
}
