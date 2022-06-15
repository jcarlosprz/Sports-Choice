package modelo;

import java.awt.Component;
import java.awt.ScrollPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import vistas._1_Bienvenido_a_SportsChoice;
import vistas._10_Configuracion;
import vistas._2_Bienvenido_admin;
import vistas._2_Registrarse;
import vistas._3_Recuperar_Contrasena;
import vistas._4_Nueva_Contrasena;
import vistas._5_Hola_Nombre;
import vistas._6_Tu_perfil;
import vistas._7_Mis_Eventos;
import vistas._8_Foro;
import vistas._91_Crear_Evento;
import vistas._9_Eventos_Disponibles;

public class Modelo {

	private _1_Bienvenido_a_SportsChoice bienvenida;
	private _10_Configuracion configuracion;
	private _2_Bienvenido_admin bienvenidaAdmin;
	private _2_Registrarse registrarse;
	private _3_Recuperar_Contrasena recuperarContrasena;
	private _4_Nueva_Contrasena nuevaContrasena;
	private _5_Hola_Nombre holaNombre;
	private _6_Tu_perfil tuPerfil;
	private _7_Mis_Eventos misEventos;
	private _8_Foro foro;
	private _9_Eventos_Disponibles eventosDisponibles;
	private _91_Crear_Evento crearEvento;

	private String resultado;
	private int fallos;

	// Atributos de la clase
	private String bd; // bd = "proyectoIntegrador"
	private String username; // login = "root"
	private String pwd; // pwd = ""
	private String url; // url = url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	private String usr;
	private String pwdusr;
	private String rol;
	private String estado;
	// Nombre saludo usuario
	private String holaNombreUsuario;
	private DefaultTableModel tablaAdmin;
	private DefaultTableModel tablaMisEventos;
	private DefaultTableModel tablaEventosBaloncesto;
	private DefaultTableModel tablaForo;
	private String sqlTablaAdmin = "Select usr, nombre, apellidos, email, estado from users WHERE rol='usuario'";
	private String sqlTablaMisEventos = "Select eventos.codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte inner join users_eventos on eventos.codigo_evento = users_eventos.codigo_evento where users_eventos.usr = ?;";

	private String sqlTablaEventosFutbol = "Select nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 1;";
	private String sqlTablaEventosBaloncesto = "Select nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 2;";
	private String sqlTablaEventosTenis = "Select nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 3;";
	private String sqlTablaEventosPadel = "Select nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 4;";
	private String sqlForo = "Select users.usr, mensaje from mensaje inner join users on mensaje.usr = users.usr inner join eventos on codigo_evento=eventos.codigo_evento where codigo_foro=codigo_evento;";

	private String usrPerfil;
	private String nombrePerfil;
	private String apellidoPerfil;
	private String telefonoPerfil;
	private String emailPerfil;
	private String poblacionPerfil;

	private Date fechaPerfil;

	public void tuPerfil() {
		String sqlPerfil = "select usr, nombre, apellidos, telefono, email,  fecha_nacimiento, poblacion from users where usr = ? ";

		try {
			PreparedStatement pstmt = conexion.prepareStatement(sqlPerfil);
			pstmt.setString(1, usr);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			usrPerfil = rset.getString(1);
			nombrePerfil = rset.getString(2);
			apellidoPerfil = rset.getString(3);
			telefonoPerfil = rset.getString(4);
			emailPerfil = rset.getString(5);
			fechaPerfil = rset.getDate(6);
			Date prueba = fechaPerfil;
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dia = new String();
			dia = formatter.format(getFechaNacimiento());
			poblacionPerfil = rset.getString(7);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		tuPerfil.actualizarsePerfil();
	}

	private Properties config;
	private File miFichero;
	private InputStream entrada;
	private OutputStream salida;
	private String respuesta;
	private final String FILE = "config.ini";

	public Modelo() {
		config = new Properties();
		try {
			miFichero = new File(FILE);
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				config.load(entrada);
			} else {
				System.err.println("Fichero no encontrado");
				System.exit(1);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Constructor que crea la conexion
	public void Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"),
					config.getProperty("pwd"));
			System.out.println(" - Conexion con MySQL establecida -\n");
		} catch (ClassNotFoundException e) {
			System.out.println(" -> Driver JDBC no encontrado \n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(" -> Error de Conexión a la BD \n");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(" -> Error general de conexión \n");
			e.printStackTrace();
		}
	}

	public void setBienvenida(_1_Bienvenido_a_SportsChoice bienvenida) {
		this.bienvenida = bienvenida;
	}

	public void setConfiguracion(_10_Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public void setBienvenidaAdmin(_2_Bienvenido_admin bienvenidaAdmin) {
		this.bienvenidaAdmin = bienvenidaAdmin;
	}

	public void setRegistrarse(_2_Registrarse registrarse) {
		this.registrarse = registrarse;
	}

	public void setRecuperarContrasena(_3_Recuperar_Contrasena recuperarContrasena) {
		this.recuperarContrasena = recuperarContrasena;
	}

	public void setNuevaContrasena(_4_Nueva_Contrasena nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}

	public void setHolaNombre(_5_Hola_Nombre holaNombre) {
		this.holaNombre = holaNombre;
	}

	public void setTuPerfil(_6_Tu_perfil tuPerfil) {
		this.tuPerfil = tuPerfil;
	}

	public void setMisEventos(_7_Mis_Eventos misEventos) {
		this.misEventos = misEventos;
	}

	public void setForo(_8_Foro foro) {
		this.foro = foro;
	}

	public void setEventosDisponibles(_9_Eventos_Disponibles eventosDisponibles) {
		this.eventosDisponibles = eventosDisponibles;
	}

	public void setCrearEvento(_91_Crear_Evento crearEvento) {
		this.crearEvento = crearEvento;
	}

	public String getResultado() {
		return this.resultado;
	}

	public String getRol() {
		return rol;
	}

	public String getEstado() {
		return estado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	private String LoginSQL(String query, String usr, String nombreColumna) {
		String aux = "";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				aux = rset.getString(nombreColumna);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return aux;
	}

	public void login(String usr, String pwd) {
		Conexion();
		this.usr = LoginSQL("SELECT usr FROM users WHERE usr=?", usr, "usr");
		this.pwdusr = LoginSQL("SELECT pwd FROM users WHERE usr=?", usr, "pwd");
		this.rol = LoginSQL("SELECT rol FROM users WHERE usr=?", usr, "rol");
		this.estado = LoginSQL("SELECT estado FROM users WHERE usr=?", usr, "estado");
		// Instrucción que devuelve el nombre del usuario que sirve para la pantalla
		// "Hola_Nombre"
		this.holaNombreUsuario = LoginSQL("SELECT nombre FROM users WHERE usr=?", usr, "nombre");
		if (this.estado.equals("inactivo")) {
			fallos++;
			if (fallos == 3) {
				resultado = "Cerrar";
				bienvenida.actualizar();
			} else {
				bienvenida.inactivoError();
			}
		} else {
			if (this.usr.equals(usr) && this.pwdusr.equals(pwd)) {
				resultado = "Correcto";
				fallos = 0;
				bienvenida.actualizar();
				TablaAdmin();
				TablaMisEventos();
				TablaForo();
			} else {
				fallos++;
				if (fallos == 3) {
					resultado = "Cerrar";
					bienvenida.actualizar();
				} else {
					resultado = "Incorrecto";
					bienvenida.actualizar();
				}
			}
		}
	}

	// Método Registro
	public boolean Registro(String usr, String nombre, String apellidos, String telefono, String email,
			String poblacion, Date date, String pwd, String confirmarpwd) {

		String RegistroSql = "INSERT INTO users(usr, nombre, apellidos, telefono, email, poblacion, fecha_nacimiento, rol, pwd, estado, codigo_recuperacion) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			String fecha_nacimiento = "";
			if (date != null) {
				fecha_nacimiento = DateFormat.getDateInstance().format(date);

				if (!usr.equals("") && !nombre.equals("") && !apellidos.equals("") && !telefono.equals("")
						&& !email.equals("") && !poblacion.equals("") && !fecha_nacimiento.equals("") && !pwd.equals("")
						&& !confirmarpwd.equals("") && pwd.equals(confirmarpwd)) {

					Conexion();
					pstmt = conexion.prepareStatement(RegistroSql);
					pstmt.setString(1, usr);
					pstmt.setString(2, nombre);
					pstmt.setString(3, apellidos);
					pstmt.setString(4, telefono);
					pstmt.setString(5, email);
					pstmt.setString(6, poblacion);
					pstmt.setString(7, fecha_nacimiento);
					pstmt.setString(8, "usuario");
					pstmt.setString(9, pwd);
					pstmt.setString(10, "activo");
					pstmt.setString(11, null);
					pstmt.executeUpdate();
					System.out.println("CUENTA CREADA");
					return true;
				} else if (!usr.equals("") && !nombre.equals("") && !apellidos.equals("") && !telefono.equals("")
						&& !email.equals("") && !poblacion.equals("") && !fecha_nacimiento.equals("") && !pwd.equals("")
						&& !confirmarpwd.equals("") && !pwd.equals(confirmarpwd)) {
					registrarse.errorLabelPasswordsDistintas();
				}
			} else {
				registrarse.errorLabelCamposVacios();
			}
		} catch (SQLException e) {
			registrarse.errorUsuarioExistente();
		}
		return false;

	}

	private void TablaAdmin() {
		tablaAdmin = new DefaultTableModel();
		int numColumnas = getNumColumnas(sqlTablaAdmin);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaAdmin);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaAdmin.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaAdmin.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void TablaMisEventos() {
		tablaMisEventos = new DefaultTableModel();
		int numColumnas = getNumColumnas2(sqlTablaMisEventos, usr);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaMisEventos);

			pstmt.setString(1, usr);
			System.out.println("METODO: " + usr);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaMisEventos.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaMisEventos.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método Registrar Evento
	public boolean RegistroEvento(int codigo_evento, Date date, String hora, String polideportivo, String nivel,
			int codigo_deporte) {

		String RegistroEventosSql = "INSERT INTO eventos(codigo_evento, fecha, hora, polideportivo, nivel,codigo_deporte) values(?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			String fecha = "";
			if (date != null) {
				fecha = DateFormat.getDateInstance().format(date);

				if (!(codigo_evento==0) && !fecha.equals("") && !hora.equals("") && !polideportivo.equals("")
						&& !nivel.equals("") && !(codigo_deporte==0)) {

					Conexion();
					pstmt = conexion.prepareStatement(RegistroEventosSql);
					pstmt.setInt(1, codigo_evento);
					pstmt.setString(2, fecha);
					pstmt.setString(3, hora);
					pstmt.setString(4, polideportivo);
					pstmt.setString(5, nivel);
					pstmt.setInt(6, codigo_deporte);
					pstmt.executeUpdate();
					System.out.println("EVENTO CREADO");
					return true;
				} else {
					registrarse.errorLabelCamposVacios();
				}
			}
		} catch (SQLException e) {
			registrarse.errorUsuarioExistente();
		}
		return false;

	}
	
	// Método Borrar Evento
		public boolean BorrarEvento(int codigo_evento, Date date, String hora, String polideportivo, String nivel,
				int codigo_deporte) {

			String BorrarEventosSql = "Delete * from eventos where eventos.codigo_evento = ?;";
			PreparedStatement pstmt;
			try {
				String fecha = "";
				if (date != null) {
					fecha = DateFormat.getDateInstance().format(date);

					if (!(codigo_evento==0) && !fecha.equals("") && !hora.equals("") && !polideportivo.equals("")
							&& !nivel.equals("") && !(codigo_deporte==0)) {

						Conexion();
						pstmt = conexion.prepareStatement(BorrarEventosSql);
						pstmt.setInt(1, codigo_evento);
						pstmt.setString(2, fecha);
						pstmt.setString(3, hora);
						pstmt.setString(4, polideportivo);
						pstmt.setString(5, nivel);
						pstmt.setInt(6, codigo_deporte);
						pstmt.executeUpdate();
						System.out.println("EVENTO BORRADO");
						return true;
					} else {
						registrarse.errorLabelCamposVacios();
					}
				}
			} catch (SQLException e) {
				registrarse.errorUsuarioExistente();
			}
			return false;

		}

	public void TablaEventosBaloncesto() {
		tablaEventosBaloncesto = new DefaultTableModel();

		int numColumnas = getNumColumnas(sqlTablaEventosBaloncesto);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaEventosBaloncesto);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaEventosBaloncesto.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaEventosBaloncesto.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void TablaEventosFutbol() {
		tablaEventosBaloncesto = new DefaultTableModel();

		int numColumnas = getNumColumnas(sqlTablaEventosFutbol);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaEventosFutbol);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaEventosBaloncesto.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaEventosBaloncesto.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void TablaEventosPadel() {
		tablaEventosBaloncesto = new DefaultTableModel();

		int numColumnas = getNumColumnas(sqlTablaEventosPadel);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaEventosPadel);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaEventosBaloncesto.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaEventosBaloncesto.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void TablaEventosTenis() {
		tablaEventosBaloncesto = new DefaultTableModel();

		int numColumnas = getNumColumnas(sqlTablaEventosTenis);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaEventosTenis);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaEventosBaloncesto.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaEventosBaloncesto.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void TablaForo() {
		tablaForo = new DefaultTableModel();

		int numColumnas = getNumColumnas(sqlForo);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlForo);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				tablaForo.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				tablaForo.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getNumColumnas(String sql) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getNumColumnas2(String sql, String usr) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			pstmt.setString(1, usr);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getNumFilas(String sql) {
		int numFilas = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				numFilas++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public DefaultTableModel getTablaAdmin() {
		return tablaAdmin;
	}

	public DefaultTableModel getTablaMisEventos() {
		return tablaMisEventos;
	}

	public DefaultTableModel getTablaEventosBaloncesto() {
		return tablaEventosBaloncesto;
	}

	public String getSqlTablaEventosFutbol() {
		return sqlTablaEventosFutbol;
	}

	public String getSqlTablaEventosTenis() {
		return sqlTablaEventosTenis;
	}

	public String getSqlTablaEventosPadel() {
		return sqlTablaEventosPadel;
	}

	public DefaultTableModel getTablaForo() {
		return tablaForo;
	}

	public void guardar(String[] datosConexion, String[] keys) {

		try {
			for (int i = 0; i < keys.length; i++) {
				config.setProperty(keys[i], datosConexion[i]);
				salida = new FileOutputStream(miFichero);
				config.store(salida, "Ultima operacion: Guardado");
				respuesta = "Guardado";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		configuracion.actualizar();
	}

	public void guardarObjetoAdmin() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(bienvenidaAdmin.getScrollPane());
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				exportarTablas misTablas = new exportarTablas(tablaAdmin);
				oos.writeObject(misTablas);
				bienvenidaAdmin.getLblConfirmacion().setText("Archivo guardado con éxito");
				fos.close();
				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarObjetoAdmin() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File fichero = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(fichero);
				ObjectInputStream ois = new ObjectInputStream(fis);
				exportarTablas misTablas = (exportarTablas) ois.readObject(); // readObject crea el objeto. No hace
																				// falta ponerle new
				bienvenidaAdmin.getLblConfirmacion().setText("Archivo cargado con éxito");
				igualarTablas((DefaultTableModel) misTablas.getTabla());
				bienvenidaAdmin.getTable().setModel(misTablas.getTabla());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void igualarTablas(DefaultTableModel defaultTableModel) {
		tablaAdmin = defaultTableModel;
		tablaForo = defaultTableModel;
	}

	public void guardarObjetoForo() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showSaveDialog(foro.getScrollPane());
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				exportarTablas misTablas = new exportarTablas(tablaForo);
				oos.writeObject(misTablas);
				foro.getLblConfirmacion().setText("Archivo guardado con éxito");
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarObjetoForo() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showOpenDialog(foro.getContentPane());
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File fichero = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(fichero);
				ObjectInputStream ois = new ObjectInputStream(fis);
				exportarTablas misTablas = (exportarTablas) ois.readObject(); // readObject crea el objeto. No hace
																				// falta new // falta ponerle new
				foro.getLblConfirmacion().setText("Archivo cargado con éxito");
				igualarTablas((DefaultTableModel) misTablas.getTabla());
				foro.getTable().setModel(misTablas.getTabla());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public String getUsrPerfil() {
		return usrPerfil;
	}

	public String getNombre() {
		return nombrePerfil;
	}

	public String getApellido() {
		return apellidoPerfil;
	}

	public String getTelefono() {
		return telefonoPerfil;
	}

	public String getEmail() {
		return emailPerfil;
	}

	public String getPoblacion() {
		return poblacionPerfil;
	}

	public Date getFechaNacimiento() {
		return fechaPerfil;
	}

	public void setTablaAdmin(DefaultTableModel tablaAdmin) {
		this.tablaAdmin = tablaAdmin;
	}

	public String getHolaNombreUsuario() {
		return holaNombreUsuario;
	}

}