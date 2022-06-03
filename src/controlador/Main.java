package controlador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
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

public class Main {

	public static void main(String[] args) {

		Controlador miControlador = new Controlador();

		Modelo miModelo = new Modelo();
		_1_Bienvenido_a_SportsChoice bienvenida = new _1_Bienvenido_a_SportsChoice();
		_10_Configuracion configuracion = new _10_Configuracion();
		_2_Bienvenido_admin bienvenidaAdmin = new _2_Bienvenido_admin();
		_2_Registrarse registrarse = new _2_Registrarse();
		_3_Recuperar_Contrasena recuperarContrasena = new _3_Recuperar_Contrasena();
		_4_Nueva_Contrasena nuevaContrasena = new _4_Nueva_Contrasena();
		_5_Hola_Nombre holaNombre = new _5_Hola_Nombre();
		_6_Tu_perfil tuPerfil = new _6_Tu_perfil();
		_7_Mis_Eventos misEventos = new _7_Mis_Eventos();
		_8_Foro foro = new _8_Foro();
		_9_Eventos_Disponibles eventosDisponibles = new _9_Eventos_Disponibles();
		_91_Crear_Evento crearEvento = new _91_Crear_Evento();

		JFrame[] pantallas = { bienvenida, configuracion, bienvenidaAdmin, registrarse, recuperarContrasena, nuevaContrasena,
				holaNombre, tuPerfil, misEventos, foro, eventosDisponibles, crearEvento };
		
		miControlador.setModelo(miModelo);
		miControlador.setPantallas(pantallas);
		miModelo.setBienvenida(bienvenida);
		miModelo.setConfiguracion(configuracion);
		miModelo.setBienvenidaAdmin(bienvenidaAdmin);
		miModelo.setRegistrarse(registrarse);
		miModelo.setRecuperarContrasena(recuperarContrasena);
		miModelo.setNuevaContrasena(nuevaContrasena);
		miModelo.setHolaNombre(holaNombre);
		miModelo.setTuPerfil(tuPerfil);
		miModelo.setMisEventos(misEventos);
		miModelo.setForo(foro);
		miModelo.setEventosDisponibles(eventosDisponibles);
		miModelo.setCrearEvento(crearEvento);
		
		bienvenida.setMiControlador(miControlador);
		configuracion.setMiControlador(miControlador);
		bienvenidaAdmin.setMiControlador(miControlador);
		registrarse.setMiControlador(miControlador);
		recuperarContrasena.setMiControlador(miControlador);
		nuevaContrasena.setMiControlador(miControlador);
		holaNombre.setMiControlador(miControlador);
		tuPerfil.setMiControlador(miControlador);
		misEventos.setMiControlador(miControlador);
		foro.setMiControlador(miControlador);
		eventosDisponibles.setMiControlador(miControlador);
		crearEvento.setMiControlador(miControlador);

		bienvenida.setMiModelo(miModelo);
		configuracion.setMiModelo(miModelo);
		bienvenidaAdmin.setMiModelo(miModelo);
		registrarse.setMiModelo(miModelo);
		recuperarContrasena.setMiModelo(miModelo);
		nuevaContrasena.setMiModelo(miModelo);
		holaNombre.setMiModelo(miModelo);
		tuPerfil.setMiModelo(miModelo);
		misEventos.setMiModelo(miModelo);
		foro.setMiModelo(miModelo);
		eventosDisponibles.setMiModelo(miModelo);
		crearEvento.setMiModelo(miModelo);

		bienvenida.setVisible(true);

	}

}