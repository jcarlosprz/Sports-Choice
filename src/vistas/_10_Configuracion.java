package vistas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class _10_Configuracion extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel contentPane;
	private JLabel lblResultado;
	private JButton btnModificar;
	private JButton btnEscribe3;
	private JLabel lblInfo;
	private JLabel lblUsuarioConexion;
	private JLabel lblPasswordConexion;
	private JLabel lblUrlConexion;
	private JTextField txtUsuarioConexion;
	private JTextField txtPasswordConexion;
	private JTextField txtUrlConexion;

	public _10_Configuracion() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtUsuarioConexion.setText(miModelo.getConfig().getProperty("username"));
				txtPasswordConexion.setText(miModelo.getConfig().getProperty("pwd"));
				txtUrlConexion.setText(miModelo.getConfig().getProperty("url"));
			}
		});
		setTitle("Configuración de conexión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(204, 191, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miModelo.guardar(getUrl(), getUrl());
			}
		});
		contentPane.add(btnGuardar);

		lblResultado = new JLabel("");
		lblResultado.setBounds(20, 241, 299, 14);
		lblResultado.setForeground(Color.RED);
		contentPane.add(lblResultado);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(303, 191, 89, 23);
		contentPane.add(btnModificar);

		lblInfo = new JLabel("Configuración actual:");
		lblInfo.setBounds(20, 11, 288, 23);
		contentPane.add(lblInfo);

		lblUsuarioConexion = new JLabel("User:");
		lblUsuarioConexion.setBounds(40, 75, 73, 14);
		contentPane.add(lblUsuarioConexion);

		lblPasswordConexion = new JLabel("Password:");
		lblPasswordConexion.setBounds(40, 105, 73, 14);
		contentPane.add(lblPasswordConexion);

		lblUrlConexion = new JLabel("URL Conexión:");
		lblUrlConexion.setBounds(40, 136, 89, 14);
		contentPane.add(lblUrlConexion);

		txtUsuarioConexion = new JTextField();
		txtUsuarioConexion.setBounds(145, 71, 247, 20);
		contentPane.add(txtUsuarioConexion);
		txtUsuarioConexion.setColumns(10);

		txtPasswordConexion = new JTextField();
		txtPasswordConexion.setColumns(10);
		txtPasswordConexion.setBounds(145, 102, 247, 20);
		contentPane.add(txtPasswordConexion);

		txtUrlConexion = new JTextField();
		txtUrlConexion.setColumns(10);
		txtUrlConexion.setBounds(145, 133, 247, 20);
		contentPane.add(txtUrlConexion);
	}

	public void setMiControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }

    public void setMiModelo(Modelo miModelo) {
        this.miModelo = miModelo;
    }

    public void actualizar () {
        lblInfo.setText(miModelo.getRespuesta());
    }

    public String getUrl (){
        return txtUrlConexion.getText();
    }

    public String getUsername (){
        return txtUsuarioConexion.getText();
    }

    public String getPwd (){
        return txtPasswordConexion.getText();
    }

    public JTextField getTxtUsuarioConexion() {
        return txtUsuarioConexion;
    }


    public JTextField getTxtPasswordConexion() {
        return txtPasswordConexion;
    }

    public JTextField getTxtUrlConexion() {
        return txtUrlConexion;
    }

    public String[] getKeys() {
        return keys;
    }
		
}
