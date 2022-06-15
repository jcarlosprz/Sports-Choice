package controlador;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import modelo.Modelo;
import vistas._10_Configuracion;
import vistas._1_Bienvenido_a_SportsChoice;
import vistas._2_Registrarse;
import vistas._7_Mis_Eventos;

public class Controlador {
	private Modelo miModelo;

	private JFrame[] pantallas;

//	private String userPerfil;

	public void cambiarPantalla(int numero1, int numero2) {
		pantallas[numero1].setVisible(false);
		pantallas[numero2].setVisible(true);

//		if(numero2 == 7) {
//			
//			miModelo.tuPerfil(userPerfil);
//		}
	}

	public void setPantallas(JFrame[] pantallas) {
		this.pantallas = pantallas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void login() {
		String usr = ((_1_Bienvenido_a_SportsChoice) pantallas[0]).getUsr();
		String pwd = ((_1_Bienvenido_a_SportsChoice) pantallas[0]).getPwd();
		miModelo.login(usr, pwd);

	}

	public void guardar() {
		String[] datosConexion = { ((_10_Configuracion) pantallas[1]).getTxtUrlConexion().getText(),
				((_10_Configuracion) pantallas[1]).getTxtUsuarioConexion().getText(),
				((_10_Configuracion) pantallas[1]).getTxtPasswordConexion().getText() };
		miModelo.guardar(datosConexion, ((_10_Configuracion) pantallas[1]).getKeys());

	}

	public void DatosRegistro() {

		String usr = ((_2_Registrarse) pantallas[3]).getNombreUsuario();
		String nombre = ((_2_Registrarse) pantallas[3]).getNombre();
		String apellidos = ((_2_Registrarse) pantallas[3]).getApellidos();
		String telefono = ((_2_Registrarse) pantallas[3]).getTelefono();
		String email = ((_2_Registrarse) pantallas[3]).getEmail();
		String poblacion = ((_2_Registrarse) pantallas[3]).getPoblacion();
		Date date = ((_2_Registrarse) pantallas[3]).getFechaNacimiento();
		String pwd = ((_2_Registrarse) pantallas[3]).getContrasena();
		String confirmarpwd = ((_2_Registrarse) pantallas[3]).getConfirmarContrasena();

		if (miModelo.Registro(usr, nombre, apellidos, telefono, email, poblacion, date, pwd, confirmarpwd) == true) {
			cambiarPantalla(3, 0);
		}

	}

	public void DatosEventosRegistro() {

		int codigo_evento = ((_7_Mis_Eventos) pantallas[3]).getNombreUsuario();
		Date date = ((_7_Mis_Eventos) pantallas[3]).getNombre();
		String hora = ((_7_Mis_Eventos) pantallas[3]).getApellidos();
		String polideportivo = ((_7_Mis_Eventos) pantallas[3]).getTelefono();
		String nivel = ((_7_Mis_Eventos) pantallas[3]).getEmail();
		int codigo_deporte = ((_7_Mis_Eventos) pantallas[3]).getPoblacion();
		

		if (miModelo.RegistroEvento(codigo_evento, date, hora, polideportivo, nivel, codigo_deporte) == true) {
			cambiarPantalla(10, 8);
		}

	}

	public JFrame getPantallas(int indice) {
		return pantallas[indice];
	}

}
