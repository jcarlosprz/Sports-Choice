import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {

	private _1_Bienvenido_a_SportsChoice bienvenida;
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
	private String bd = "proyectoIntegrador";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	private String usr;
	private String pwdusr;
	private String rol;

	private String estado;

	// Constructor que crea la conexion
	public Modelo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
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

	public String Consulta(String query, String usr, String nombreColumna) {
		String aux = "";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				aux = rset.getString(nombreColumna);
				System.out.println("While");
				System.out.println(aux);
			}
			rset.close();
			pstmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}
		return aux;
	}

	public void login(String usr, String pwd) {
		this.usr = Consulta("SELECT * FROM users WHERE usr=?", usr, "usr");
		this.pwdusr = Consulta("SELECT * FROM users WHERE usr=?", usr, "pwd");
		this.rol = Consulta("SELECT * FROM users WHERE usr=?", usr, "rol");
		System.out.println("Atributos: " + this.usr + " " + this.pwdusr);
		System.out.println("Locales: " + usr + " " + pwd);

		if (this.usr.equals(usr) && this.pwdusr.equals(pwd) && !this.usr.equals("") && !this.pwdusr.equals("")) {
			resultado = "Correcto";
			fallos = 0;
			bienvenida.actualizar(rol);
		} else {
			fallos++;
			if (fallos == 3) {
				resultado = "Cerrar";
				bienvenida.actualizar(rol);
			} else {
				if (usr.equals("") && pwd.equals("")) {
					resultado = "Vacio";
					bienvenida.actualizar(rol);
				} else {
				resultado = "Incorrecto";
				bienvenida.actualizar(rol);
				}
			}
		}
	}
}