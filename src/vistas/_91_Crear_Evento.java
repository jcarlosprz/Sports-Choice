package vistas;

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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import controlador.Controlador;
import modelo.Modelo;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class _91_Crear_Evento extends JFrame {

	private Controlador miControlador;
	private Modelo miModelo;
	private JPanel panel;
	private JButton btnPregunta, btnCrearEvento;
	private JLabel lblHasSeleccionadoDeporte, lblSeleccionaTusPreferencias, lblHoraDosPuntos, lblUbicacion, lblHora,
			lblFecha, lblNivel, lblFondo, lblDeporteSeleccionado, lblMensaje;
	private JComboBox cbxPolideportivo;
	private JList listNivel;
	private JSpinner spinnerHora, spinnerMinutos;
	private JCalendar calendar;


	public _91_Crear_Evento() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lblDeporteSeleccionado.setText(miModelo.getOpcionDeporte());
			}
		});

		setTitle("CREAR EVENTO");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(11, 10);
			}
		});

		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setBounds(214, 488, 315, 40);
		panel.add(lblMensaje);
		btnFlecha.setIcon(new ImageIcon(_91_Crear_Evento.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBorder(null);
		btnFlecha.setBounds(54, 587, 106, 56);
		btnFlecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnFlecha);

		lblHasSeleccionadoDeporte = new JLabel("HAS SELECCIONADO: ");
		lblHasSeleccionadoDeporte.setFont(new Font("Dubai", Font.BOLD, 30));
		lblHasSeleccionadoDeporte.setBounds(214, 10, 298, 54);
		panel.add(lblHasSeleccionadoDeporte);

		btnCrearEvento = new JButton("CREA TU EVENTO");
		btnCrearEvento.setBorder(null);
		btnCrearEvento.setBackground(new Color(176, 196, 222));
		btnCrearEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.crearEvento();
			}
		});

		btnCrearEvento.setFont(new Font("Dubai", Font.BOLD, 15));
		btnCrearEvento.setBounds(603, 587, 162, 56);
		panel.add(btnCrearEvento);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"" + "Todos los campos son requeridos            \r\n"
								+ "Por favor, no te dejes ningún campo  \r\n" + "sin seleccionar.\r\n\n",
						"AYUDA EVENTOS DISPONIBLES", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_91_Crear_Evento.class.getResource("/images/pregunta-32x32.png")));
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(553, 55, 32, 52);
		panel.add(btnPregunta);

		lblSeleccionaTusPreferencias = new JLabel("Selecciona tus preferencias:");
		lblSeleccionaTusPreferencias.setFont(new Font("Dubai", Font.BOLD, 20));
		lblSeleccionaTusPreferencias.setBounds(306, 60, 250, 40);
		panel.add(lblSeleccionaTusPreferencias);

		cbxPolideportivo = new JComboBox();
		cbxPolideportivo.setBackground(Color.WHITE);
		cbxPolideportivo.setFont(new Font("Dubai", Font.PLAIN, 15));
		cbxPolideportivo.setModel(new DefaultComboBoxModel(new String[] { "", "Enrique Blas", "Galapagar Sports ",
				"Dehesa de Navalcarb\u00F3n", "El Abaj\u00F3n", "Principe Felipe" }));
		cbxPolideportivo.setBounds(65, 233, 207, 21);
		panel.add(cbxPolideportivo);

		listNivel = new JList();
		listNivel.setBorder(new LineBorder(new Color(0, 0, 0)));
		listNivel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNivel.setFont(new Font("Dubai", Font.PLAIN, 15));
		listNivel.setModel(new AbstractListModel() {
			String[] values = new String[] { "Principiante", "Medio", "Avanzado" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listNivel.setBounds(677, 233, 88, 88);
		panel.add(listNivel);

		spinnerHora = new JSpinner();
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora.setBounds(525, 233, 52, 22);
		panel.add(spinnerHora);

		spinnerMinutos = new JSpinner();
		spinnerMinutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinutos.setBounds(592, 233, 52, 22);
		panel.add(spinnerMinutos);

		lblHoraDosPuntos = new JLabel(":");
		lblHoraDosPuntos.setFont(new Font("Dubai", Font.BOLD, 15));
		lblHoraDosPuntos.setBounds(583, 232, 8, 22);
		panel.add(lblHoraDosPuntos);

		calendar = new JCalendar();
		calendar.setBounds(306, 233, 190, 190);
		panel.add(calendar);

		lblUbicacion = new JLabel("Ubicaci\u00F3n:");
		lblUbicacion.setFont(new Font("Dubai", Font.BOLD, 15));
		lblUbicacion.setBounds(65, 214, 104, 14);
		panel.add(lblUbicacion);

		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Dubai", Font.BOLD, 15));
		lblHora.setBounds(533, 214, 104, 14);
		panel.add(lblHora);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Dubai", Font.BOLD, 15));
		lblFecha.setBounds(306, 214, 104, 14);

		panel.add(lblFecha);
		lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("Dubai", Font.BOLD, 15));
		lblNivel.setBounds(677, 214, 104, 14);
		lblNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(lblNivel);

		lblDeporteSeleccionado = new JLabel();
		lblDeporteSeleccionado.setFont(new Font("Dubai", Font.BOLD, 30));
		lblDeporteSeleccionado.setBounds(524, 10, 242, 54);
		panel.add(lblDeporteSeleccionado);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_91_Crear_Evento.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-112, 0, 979, 723);
		panel.add(lblFondo);
	}


	// Label que saca por pantalla error al intentar registrar un usuario que ya existe.
	public void errorCamposVacios() {
		lblMensaje.setText("Te has dejado algún campo sin seleccionar");
	}

	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public String getCbxPolideportivo() {
		return cbxPolideportivo.getSelectedItem().toString();
	}

	// Devuelve la hora y se le añade un 0 delante si solo tiene un digito.
	public String getSpinnerHora() {
		String prueba = "";
		if (spinnerHora.getValue().toString().length() == 1) {
			prueba = "0" + spinnerHora.getValue().toString();
		}
		return prueba;
	}

	// Devuelve los minutos y se le añade un 0 delante si solo tiene un digito.
	public String getSpinnerMinutos() {
		String prueba = "";
		if (spinnerMinutos.getValue().toString().length() == 1) {
			prueba = "0" + spinnerMinutos.getValue().toString();
		}
		return prueba;
	}

	public Date getCalendar() {
		return calendar.getDate();
	}

	public JList getListNivel() {
		return listNivel;
	}

	public void aceptado() {

		miControlador.cambiarPantalla(11, 8);
	}

}
