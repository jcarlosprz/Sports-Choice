import java.util.Iterator;

import javax.swing.JFrame;

public class Controlador {
	private Modelo miModelo;
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

	private JFrame[] pantallas = { bienvenida, bienvenidaAdmin, registrarse, recuperarContrasena, nuevaContrasena,
			holaNombre, tuPerfil, misEventos, foro, eventosDisponibles, crearEvento };

	public void cambiarPantalla(int numero1, int numero2) {
		pantallas[numero1].setVisible(false);
		pantallas[numero2].setVisible(true);
	}
	
	public void setPantallas() {
		pantallas[0] = bienvenida;
		pantallas[1] = bienvenidaAdmin;
		pantallas[2] = registrarse;
		pantallas[3] = recuperarContrasena;
		pantallas[4] = nuevaContrasena;
		pantallas[5] = holaNombre;
		pantallas[6] = tuPerfil;
		pantallas[7] = misEventos;
		pantallas[8] = foro;
		pantallas[9] = eventosDisponibles;
		pantallas[10] = crearEvento;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
}
