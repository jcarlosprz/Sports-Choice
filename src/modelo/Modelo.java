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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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

	private String bd; // bd = "proyectoIntegrador"
	private String username; // login = "root"
	private String pwd; // pwd = ""
	private String url; // url = url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	private String usr;
	private String pwdusr;
	private String rol;
	private String estado;
	private String holaNombreUsuario;

	private Properties config;
	private File miFichero;
	private InputStream entrada;
	private OutputStream salida;
	private String respuesta;
	private final String FILE = "config.ini";

	private DefaultTableModel tablaAdmin;
	private DefaultTableModel tablaMisEventos;
	private DefaultTableModel tablaEventosBaloncesto;
	private DefaultTableModel tablaForo;
	private String sqlTablaAdmin = "Select usr, nombre, apellidos, email, estado from users WHERE rol='usuario'";

	private String sqlTablaMisEventos = "Select eventos.codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte inner join users_eventos on eventos.codigo_evento = users_eventos.codigo_evento where users_eventos.usr = ?;";
	private String sqlTablaEventosFutbol = "Select codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 1;";
	private String sqlTablaEventosBaloncesto = "Select codigo_evento,nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 2;";
	private String sqlTablaEventosTenis = "Select codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 3;";
	private String sqlTablaEventosPadel = "Select codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte where deportes.codigo_deporte = 4;";
	private String sqlForo = "Select users.usr, mensaje from mensaje inner join users on mensaje.usr = users.usr where codigo_foro = ?;";
	private String codigo_evento;

	private String sqlBloqueaUsuario = "update users set estado ='inactivo' where usr=?;";
	private String sqlDesbloqueaUsuario = "update users set estado = 'activo' where usr=?;";
	private String usrPerfil;
	private String nombrePerfil;
	private String apellidoPerfil;
	private String telefonoPerfil;
	private String emailPerfil;
	private String poblacionPerfil;
	private String resultado;
	private int fallos;
	private String numeroRandom;

	private String fechaPerfil;
	private String opcionDeporte = "";
	private int opcionDeporteId;

	/**
	 * Método tuPerfil: Posee un select que recoge los valores de la base de datos y
	 * llama a otro metodo (actualizarsePerfil) para actualizar el perfil.
	 */
	public void tuPerfil() {
		String sqlPerfil = "select usr, nombre, apellidos, telefono, email, fecha_nacimiento, poblacion from users where usr = ? ";
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
			fechaPerfil = rset.getString(6);
			poblacionPerfil = rset.getString(7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tuPerfil.actualizarsePerfil();
	}

	/**
	 * Método updatePerfil: se pasan los valores de los campos. El update actualiza
	 * los valores de dichos campos.
	 */
	public void updatePerfil(String nombrePerfil, String apellidoPerfil, String telefonoPerfil, String emailPerfil,
			String poblacionPerfil) {
		String update = "Update users set nombre = ?, apellidos = ?, telefono = ?, email = ?,  poblacion = ? where usr = ? ";

		try {
			PreparedStatement pstmt = conexion.prepareStatement(update);
			pstmt.setString(1, nombrePerfil);
			pstmt.setString(2, apellidoPerfil);
			pstmt.setString(3, telefonoPerfil);
			pstmt.setString(4, emailPerfil);
			pstmt.setString(5, poblacionPerfil);
			pstmt.setString(6, usr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método deletePerfil: Borra el usuario de la BBDD.
	 */
	public void deletePerfil() {
		String delete = "Delete from users where usr = ? ";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(delete);

			pstmt.setString(1, usr);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método Modelo: Establece las bases de la conexión a la BBDD.
	 */
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

	/**
	 * Método Conexion: Crea la conexión a la BBDD cogiendo las propieddes y el
	 * driver.
	 */
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

	/**
	 * Método LoginSQL: Método que establece Login con SQL.
	 */
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

	/**
	 * Método login: Establece el login dentro de la apliación tras comprobar que el
	 * usuario tiene el estado activo, que el usuario concuerda con su password y
	 * revisa si se está accediendo como un usuario o como un administrador para
	 * mostrar una vista u otra.
	 */
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

	/**
	 * Método Registro: Realiza un insert en la BBDD introduciendo así al usuario.
	 * Además, dependiendo del camino que tome, llamará a un método, u otro, de la
	 * clase registrarse para mostrar un label de información para el usuario.
	 */
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

	/**
	 * Método TablaAdmin: Método que saca columnas y filas y las añade para
	 * mostrarlas en la tabla de administrador.
	 */
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

	/**
	 * Método TablaMisEventos: Método que saca columnas y filas y las añade para
	 * mostrarlas en la tabla de miseventos.
	 */
	private void TablaMisEventos() {
		tablaMisEventos = new DefaultTableModel();
		int numColumnas = getNumColumnas2(sqlTablaMisEventos, usr);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaMisEventos);
			pstmt.setString(1, usr);
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

	/**
	 * Método TablaEventosBaloncesto: Método que saca columnas y filas y las añade
	 * para mostrarlas en la tabla de los eventos de baloncesto.
	 */
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

	/**
	 * Método TablaEventosFutbol: Método que saca columnas y filas y las añade para
	 * mostrarlas en la tabla de los eventos de futbol.
	 */
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

	/**
	 * Método TablaEventosPadel: Método que saca columnas y filas y las añade para
	 * mostrarlas en la tabla de los eventos de padel.
	 */
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

	/**
	 * Método TablaEventosTenis: Método que saca columnas y filas y las añade para
	 * mostrarlas en la tabla de los eventos de tenis.
	 */
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

	/**
	 * Método que te permite unirte a un evento haciendo un insert en la tabla
	 * user_eventos
	 */

	public void UnirseEvento(String codigo_evento_sel) {
		String RegistroSql = "INSERT INTO users_eventos(usr,codigo_evento) values(?,?);";
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(RegistroSql);
			pstmt.setString(1, usr);
			pstmt.setString(2, codigo_evento_sel);
			pstmt.executeUpdate();

			System.out.println("TE HAS UNIDO AL EVENTO");
		} catch (SQLException e) {

		}
	}

	/**
	 * Método bloquearUsuario: permite acceder a la base de datos para hacer que el
	 * estado de un usuario pase de activo a inactivo. Toma como parámetro una
	 * variable de la clase JTable y hace uso de un objeto PreparedStatement para
	 * acceder a la base de datos de forma segura y modificar el registro indicado
	 * por medio de la query almacenada en el atributo sqlBloqueaUsuario.
	 */
	public void bloquearUsuario(JTable tableAdmin) {

		String usuario = (String) tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 0);
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlBloqueaUsuario);
			pstmt.setString(1, usuario);
			pstmt.executeUpdate();
			System.out.println(pstmt);
			System.out.println(usuario + " ha sido bloqueado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tablaAdmin.setValueAt("inactivo", tableAdmin.getSelectedRow(), 4);
	}

	/**
	 * 
	 * Método desbloquearUsuario: permite acceder a la base de datos para hacer que
	 * el estado de un usuario pase de inactivo a activo. Toma como parámetro una
	 * variable de la clase JTable y hace uso de un objeto PreparedStatement para
	 * acceder a la base de datos de forma segura y modificar el registro indicado
	 * por medio de la query almacenada en el atributo sqlDesbloqueaUsuario.
	 */

	public void desbloquearUsuario(JTable tableAdmin) {
		String usuario = (String) tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 0);
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlDesbloqueaUsuario);
			pstmt.setString(1, usuario);
			pstmt.executeUpdate();
			System.out.println(pstmt);
			System.out.println(usuario + " ha sido desbloqueado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tablaAdmin.setValueAt("activo", tableAdmin.getSelectedRow(), 4);
	}

	/**
	 * Método habilitarBoton: permite habilitar los botones btnBloquear y
	 * btnDesbloquear de la pantalla _2_Bienvenido_admin en función del estado del
	 * usuario (activo o inactivo). Si el estado de un usuario es inactivo, al
	 * seleccionar en la tabla la fila correspondiente a ese usuario se habilitará
	 * el botón "desbloquear". Si, por el contrario, el estado de un usuario es
	 * activo, al seleccionar dicha fila, se habilitará el botón "bloquear".
	 */

	public void habilitaBoton(JButton button1, JButton button2, JTable table) {
		String condicion = (String) tablaAdmin.getValueAt(table.getSelectedRow(), 4);
		if (condicion.equals("activo")) {
			button1.setEnabled(true);
			button2.setEnabled(false);
		} else {
			button2.setEnabled(true);
			button1.setEnabled(false);
		}
	}

	/**
	 * Método getNumColumnas: Recoge el número de columnas pasandole por parámetro
	 * un String.
	 */
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

	/**
	 * Método getNumColumnas2: Recoge el número de columnas pasandole por parámetro
	 * dos Strings.
	 */
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

	/**
	 * Método getNumFilas: Recoge el número de columnas pasandole por parámetro un
	 * String.
	 */
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

	/**
	 * Método guardar: Método que guarda datos de conexión.
	 */
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

	/**
	 * Método guardarObjetoAdmin: Método que guarda de la vista _2_Bienvenido_admin
	 * el fichero correspondiente con los datos de la BBDD mostrados en la tabla.
	 */
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

	/**
	 * Método cargarObjetoAdmin: Método que carga de la vista _2_Bienvenido_admin el
	 * fichero correspondiente con los datos de la BBDD previamente almacenados (una
	 * especie de back up).
	 */
	public void cargarObjetoAdmin() {
		File rutaProyecto = new File(System.getProperty("user.dir"));
		JFileChooser fc = new JFileChooser(rutaProyecto);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			try {
				File fichero = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(fichero);
				ObjectInputStream ois = new ObjectInputStream(fis);
				exportarTablas misTablas = (exportarTablas) ois.readObject();
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

	/**
	 * Método igualarTablas: Iguala la tablaAdmin y la tablaForo con mismo
	 * defaultTableModel.
	 */
	public void igualarTablas(DefaultTableModel defaultTableModel) {
		tablaAdmin = defaultTableModel;
		tablaForo = defaultTableModel;
	}

	/**
	 * Método guardarObjetoForo: Método que guarda de la vista _8_Foro el fichero
	 * correspondiente con los datos de la BBDD mostrados en la tabla.
	 */
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

	/**
	 * Método cargarObjetoForo: Método que carga de la vista _8_Foro el fichero
	 * correspondiente con los datos de la BBDD previamente almacenados (una especie
	 * de back up).
	 */
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

	/**
	 * Método recuperarContrasena: Método que permite inicializar los pasos para
	 * recuperar la contraseña. Dentro del método se llama a otros métodos y vistas
	 * para mostrar labels con información para el usuario.
	 */
	public void recuperarContrasena() {
		Conexion();
		String sqlEmailExistente = "Select email from users where email = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sqlEmailExistente);
			String textoEmail = recuperarContrasena.getTxtEmail();
			if (textoEmail.equals("")) {
				recuperarContrasena.errorCampoVacio();
			} else {
				pstmt.setString(1, textoEmail);
				ResultSet rset = pstmt.executeQuery();
				if (!rset.next()) {
					recuperarContrasena.errorUsuarioNoExistente();
				} else {
					if (textoEmail.equals(rset.getString(1))) {
						updateCodigo();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método updateCodigo: Método que actualiza el código en la base de datos del
	 * usuario.
	 */
	public String updateCodigo() {
		String sqlActualizarCodigo = "update users set codigo_recuperacion = ? where email = ?";
		String numeroAleatorio = generadorNumero();
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sqlActualizarCodigo);
			pstmt.setString(1, numeroAleatorio);
			pstmt.setString(2, recuperarContrasena.getTxtEmail());
			pstmt.executeUpdate();
			recuperarContrasena.numeroRandom(numeroAleatorio);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numeroAleatorio;
	}

	/**
	 * Método generadorNumero: Metodo que genera un número aleatorio de 6 números y
	 * lo convierte a String quitando los decimales.
	 */
	public String generadorNumero() {
		double sixDigits = 100000 + Math.random() * 900000;
		numeroRandom = String.valueOf(sixDigits);
		numeroRandom = numeroRandom.substring(0, 6);
		return numeroRandom;
	}

	/**
	 * Método comparacionCodigos: Metodo que comprueba si el código generado y
	 * guardado en el campo código del usuario es el mismo que el introducido por el
	 * usuario en el TXTCodigo.
	 */
	public void comparacionCodigos() {
		String sqlEmailExistente = "Select codigo_recuperacion from users where codigo_recuperacion = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sqlEmailExistente);
			String codigo = recuperarContrasena.getTxtCodigo();
			pstmt.setString(1, codigo);
			ResultSet rset = pstmt.executeQuery();
			if (!rset.next()) {
				recuperarContrasena.NoConcuerdanCodigos();
			} else {
				if (codigo.equals(rset.getString(1))) {
					recuperarContrasena.concuerdanCodigos();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método actualizarContrasena: Metodo que lanza diversos mensajes a labels con
	 * información para el usuario. Si ambas conytraseñas introducidas concuerdan y
	 * son iguales o mayores a 6 caracteres entonces se guardaran y actualizaran en
	 * la BBDD.
	 */
	public void actualizarContrasena() {
		String sqlActualizarContrasena = "update users set pwd = ? where email = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sqlActualizarContrasena);
			pstmt.setString(1, nuevaContrasena.getTxtNuevaContrasena());
			pstmt.setString(2, recuperarContrasena.getTxtEmail());
			if (nuevaContrasena.getTxtNuevaContrasena().equals(nuevaContrasena.getTxtRepetirContrasena())) {
				if (nuevaContrasena.getTxtNuevaContrasena().length() >= 6) {
					pstmt.executeUpdate();
					nuevaContrasena.concuerdanContrasenas();
				} else {
					nuevaContrasena.longitudMenorSeis();
				}
			} else {
				nuevaContrasena.noConcuerdanContrasenas();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método crearevento: Metodo que inserta un evento en la BBDD.
	 */
	public void crearEvento() {
		String InsertarEvento = "INSERT INTO eventos(fecha, hora, polideportivo, nivel, codigo_deporte) values(?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			if (!crearEvento.getCbxPolideportivo().equals("") && !crearEvento.getCalendar().equals(null)
					&& !crearEvento.getCbxPolideportivo().equals("")
					&& !crearEvento.getListNivel().isSelectionEmpty()) {
				pstmt = conexion.prepareStatement(InsertarEvento);
				pstmt.setString(1, DateFormat.getDateInstance().format(crearEvento.getCalendar()));
				pstmt.setString(2, crearEvento.getSpinnerHora() + ":" + crearEvento.getSpinnerMinutos());
				pstmt.setString(3, crearEvento.getCbxPolideportivo());
				pstmt.setString(4, crearEvento.getListNivel().getSelectedValue().toString());
				pstmt.setInt(5, getOpcionDeporteId());
				pstmt.executeUpdate();
				crearUserEvento();
				crearEvento.aceptado();
				getTablaMisEventos();
			} else {
				crearEvento.errorCamposVacios();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método crearUserEvneto: Metodo que mete al usuario en el evento creado.
	 */
	public void crearUserEvento() {
		String queryCodigoUser = "Select codigo_evento from eventos order by codigo_evento desc limit 1";
		try {
			PreparedStatement pstmt;
			pstmt = conexion.prepareStatement(queryCodigoUser);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			String codigo_user = rset.getString(1);
			String InsertarEvento = "INSERT INTO users_eventos(usr, codigo_evento) values(?,?)";
			PreparedStatement pstmt2;
			pstmt2 = conexion.prepareStatement(InsertarEvento);
			pstmt2.setString(1, usr);
			pstmt2.setString(2, codigo_user);
			pstmt2.executeUpdate();
			getTablaMisEventos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que te permite abandonar a un evento haciendo un delete en la tabla
	 * user_eventos
	 */
	public void AbandonarEvento(String codigo_evento_sel) {
		String RegistroSql = "DELETE from users_eventos where codigo_evento=?;";
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(RegistroSql);
			pstmt.setString(1, codigo_evento_sel);
			pstmt.executeUpdate();
		} catch (SQLException e) {

		}
	}

	/**
	 * Este método carga los valores del foro según lo que selecciones en la tabla
	 * de MisEventos
	 */
	public void TablaForo(String codigo_evento) {
		tablaForo = new DefaultTableModel();
		this.codigo_evento = codigo_evento;
		int numColumnas = getNumColumnas2(sqlForo, codigo_evento);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlForo);
			pstmt.setString(1, codigo_evento);
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

	/**
	 * El método EnviarMensaje hace un insert del mensaje en la base de datos y lo
	 * guarda.
	 */
	public void EnviarMensaje(String mensaje) {
		String RegistroSql = "INSERT INTO mensaje(mensaje,codigo_foro,usr) values(?,?,?);";
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(RegistroSql);
			pstmt.setString(1, mensaje);
			pstmt.setString(2, codigo_evento);
			pstmt.setString(3, usr);
			pstmt.executeUpdate();
		} catch (SQLException e) {

		}
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

	public String getFechaNacimiento() {
		return fechaPerfil;
	}

	public void setTablaAdmin(DefaultTableModel tablaAdmin) {
		this.tablaAdmin = tablaAdmin;
	}

	public String getHolaNombreUsuario() {
		return holaNombreUsuario;
	}

	public String getNumeroRandom() {
		return numeroRandom;
	}

	public String getOpcionDeporte() {
		return opcionDeporte;
	}

	public void setOpcionDeporte(String opcionDeporte) {
		this.opcionDeporte = opcionDeporte;
	}

	public int getOpcionDeporteId() {
		return opcionDeporteId;
	}

	public void setOpcionDeporteId(int opcionDeporteId) {
		this.opcionDeporteId = opcionDeporteId;
	}
}