import java.util.Iterator;

import javax.swing.JFrame;

public class Controlador {
	private Modelo miModelo;
	private _1_Bienvenido_a_SportsChoice bienvenida = new _1_Bienvenido_a_SportsChoice();
	private _2_Bienvenido_admin bienvenidaAdmin = new _2_Bienvenido_admin();
	private _2_Registrarse registrarse = new _2_Registrarse();
	private _3_Recuperar_Contrasena recuperarContrasena = new _3_Recuperar_Contrasena();
	private _4_Nueva_Contrasena nuevaContrasena = new _4_Nueva_Contrasena();
	private _5_Hola_Nombre holaNombre = new _5_Hola_Nombre();
	private _6_Tu_perfil tuPerfil = new _6_Tu_perfil();
	private _7_Mis_Eventos misEventos = new _7_Mis_Eventos();
	private _8_Foro foro = new _8_Foro();
	private _9_Eventos_Disponibles eventosDisponibles = new _9_Eventos_Disponibles();
	private _91_Crear_Evento crearEvento = new _91_Crear_Evento();

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
