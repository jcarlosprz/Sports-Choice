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

public class Pantalla_Botones {

	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Botones window = new Pantalla_Botones();
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
	public Pantalla_Botones() {
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
		
		JButton btnNewButton = new JButton("CREA TU EVENTO");
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setBounds(95, 103, 162, 56);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CREA TU EVENTO");
		btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setBounds(293, 103, 162, 56);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CREA TU EVENTO");
		btnNewButton_2.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(176, 196, 222));
		btnNewButton_2.setBounds(489, 103, 162, 56);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CREA TU EVENTO");
		btnNewButton_3.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(176, 196, 222));
		btnNewButton_3.setBounds(694, 103, 162, 56);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CREA TU EVENTO");
		btnNewButton_4.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_4.setBackground(new Color(176, 196, 222));
		btnNewButton_4.setBounds(904, 103, 162, 56);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CREA TU EVENTO");
		btnNewButton_5.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5.setBackground(new Color(176, 196, 222));
		btnNewButton_5.setBounds(95, 226, 162, 56);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("CREA TU EVENTO");
		btnNewButton_5_1.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_1.setBackground(new Color(176, 196, 222));
		btnNewButton_5_1.setBounds(293, 226, 162, 56);
		panel.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("CREA TU EVENTO");
		btnNewButton_5_2.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_2.setBackground(new Color(176, 196, 222));
		btnNewButton_5_2.setBounds(489, 226, 162, 56);
		panel.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("CREA TU EVENTO");
		btnNewButton_5_3.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_3.setBackground(new Color(176, 196, 222));
		btnNewButton_5_3.setBounds(694, 226, 162, 56);
		panel.add(btnNewButton_5_3);
		
		JButton btnNewButton_5_4 = new JButton("CREA TU EVENTO");
		btnNewButton_5_4.setFont(new Font("Dubai", Font.BOLD, 15));
		btnNewButton_5_4.setBackground(new Color(176, 196, 222));
		btnNewButton_5_4.setBounds(904, 226, 162, 56);
		panel.add(btnNewButton_5_4);


	}
}
