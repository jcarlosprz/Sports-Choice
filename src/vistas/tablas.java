package vistas;
import java.io.Serializable;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class tablas implements Serializable {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel tablaAdmin;
	
	
	public tablas(DefaultTableModel tablaAdmin) {
		super();
		this.tablaAdmin = tablaAdmin;
	}

	public DefaultTableModel getTablaAdmin() {
		return tablaAdmin;
	}

	public void setTablaAdmin(DefaultTableModel tablaAdmin) {
		this.tablaAdmin = tablaAdmin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
