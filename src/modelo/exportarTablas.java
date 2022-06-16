package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class exportarTablas implements Serializable {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tabla;

	public exportarTablas(DefaultTableModel tabla) {
		super();
		this.tabla = tabla;
	}

	public DefaultTableModel getTabla() {
		return tabla;
	}

	public void setTablaAdmin(DefaultTableModel tabla) {
		this.tabla = tabla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
