package controlador;
import java.util.Iterator;

import javax.swing.JFrame;

import modelo.Modelo;
import vistas._10_Configuracion;
import vistas._1_Bienvenido_a_SportsChoice;
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

public class Controlador {
	private Modelo miModelo;
	
	private JFrame[] pantallas;

	public void cambiarPantalla(int numero1, int numero2) {
		pantallas[numero1].setVisible(false);
		pantallas[numero2].setVisible(true);
	}

	public void setPantallas(JFrame [] pantallas) {
		this.pantallas=pantallas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void login() {
		String usr = ((_1_Bienvenido_a_SportsChoice)pantallas[0]).getUsr();
		String pwd = ((_1_Bienvenido_a_SportsChoice)pantallas[0]).getPwd();
		miModelo.login(usr,pwd);

	}
	
	public void guardar(){
		miModelo.getUsername();
	}
	
//	public void borrar (){
//		miModelo.borrar(_10_Configuracion.getBillete());
//	}
//	
//	public void comprobar (){
//		miModelo.comprobar(_10_Configuracion.getBillete());
//	}
	

}
