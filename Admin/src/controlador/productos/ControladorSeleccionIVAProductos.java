/**
 * 
 */
package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccionIVAProductos implements ActionListener {

	private ConsolaProductos consolaProductos;

	/**
	 * @param consolaProductos 
	 * 
	 */
	public ControladorSeleccionIVAProductos(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (consolaProductos.getRdbtnSi().isSelected()) {

			consolaProductos.getCampoIVAPorc().setText("16.00");

			double precio = Double.parseDouble(consolaProductos.getCampoPreciosIVA().getText());

			double precio2 = precio;

			DecimalFormat d = new DecimalFormat("0.00");

			precio *= .16;

			consolaProductos.getCampoIVA().setText(d.format(precio));

			precio2 = precio2 + precio;

			consolaProductos.getCampoPreciocIVA().setText(d.format(precio2));

		}
		if (consolaProductos.getRdbtnNo().isSelected()) {

			consolaProductos.getCampoIVAPorc().setText("0.00");

			consolaProductos.getCampoIVA().setText("0.00");

			consolaProductos.getCampoPreciocIVA().setText(consolaProductos.getCampoPreciosIVA().getText());

		}

	}

}

