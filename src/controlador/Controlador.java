package controlador;

import java.util.Date;

import javax.swing.JFrame;

import modelo.Modelo;
import vistas._10_Configuracion;
import vistas._1_Bienvenido_a_SportsChoice;
import vistas._2_Registrarse;
import vistas._3_Recuperar_Contrasena;
import vistas._6_Tu_perfil;

public class Controlador {
	
	private Modelo miModelo;
	private JFrame[] pantallas;
	
	public void cambiarPantalla(int numero1, int numero2) {
		pantallas[numero1].setVisible(false);
		pantallas[numero2].setVisible(true);
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
	
	/**
	 * 
	 * Método para que un usuario se pueda registrar
	 * 
	 * */
	
	public void DatosRegistro() {	
		String usr=((_2_Registrarse) pantallas[3]).getNombreUsuario();
		String nombre=((_2_Registrarse) pantallas[3]).getNombre();
		String apellidos=((_2_Registrarse) pantallas[3]).getApellidos();
		String telefono=((_2_Registrarse) pantallas[3]).getTelefono();
		String email=((_2_Registrarse) pantallas[3]).getEmail();
		String poblacion=((_2_Registrarse) pantallas[3]).getPoblacion();
		Date date =((_2_Registrarse) pantallas[3]).getFechaNacimiento();
		String pwd=((_2_Registrarse) pantallas[3]).getContrasena();
		String confirmarpwd=((_2_Registrarse) pantallas[3]).getConfirmarContrasena();
		
		if (miModelo.Registro(usr, nombre, apellidos, telefono, email, poblacion, date, pwd, confirmarpwd) == true) {
			cambiarPantalla(3, 0);
		} 	
	}

	
	/**
	 * 
	 * Método para que un usuario pueda actualizar perfil
	 * 
	 * 
	 * */
	public void updatePerfil() {	
			String nombre = 	((_6_Tu_perfil) pantallas[7]).getTxtNombre();
			String apellidos = 	((_6_Tu_perfil) pantallas[7]).getTxtApellidos();
			String telefono =	((_6_Tu_perfil) pantallas[7]).getTxtTelefono();
			String email =	((_6_Tu_perfil) pantallas[7]).getTxtEmail();
			String poblacion =	((_6_Tu_perfil) pantallas[7]).getTxtPoblacion();
			System.out.println(nombre);
			System.out.println(apellidos);
			System.out.println(telefono);
			System.out.println(email);
			System.out.println(poblacion);
			miModelo.updatePerfil(nombre,apellidos, telefono, email, poblacion);			
	}
	
	public JFrame getPantallas(int indice) {
		return pantallas[indice];
	}
	
	public void setPantallas(JFrame[] pantallas) {
		this.pantallas = pantallas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
}
