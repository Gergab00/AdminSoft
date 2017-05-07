package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.productos.ConsolaProductos;

public class ControladorEliminarProducto implements ActionListener {

	private ConsolaProductos consolaProductos;

	public ControladorEliminarProducto(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		consolaProductos.getCampoID().setText("");
		consolaProductos.getCampoNombre().setText("");
		consolaProductos.getCampoPreciosIVA().setText("0.00");
		consolaProductos.getCampoPreciocIVA().setText("0.00");
		consolaProductos.getRdbtnNo().setSelected(true);
	}

}
