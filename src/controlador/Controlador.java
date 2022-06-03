package controlador;

import javax.swing.JFrame;

import modelo.Modelo;
import vistas._10_Configuracion;
import vistas._1_Bienvenido_a_SportsChoice;

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
		String[] datos = {miModelo.getUsername(), miModelo.getPwd(), miModelo.getUrl()};
		miModelo.getUsername();
	}

}
