/**
 * 
 */
package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class ControladorAgregarFila implements ActionListener {

	private ConsolaProductos consola;

	/**
	 * @param consolaProductos 
	 * 
	 */
	public ControladorAgregarFila(ConsolaProductos consolaProductos) {
		this.consola = consolaProductos;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vector <Object> data = new Vector<Object>();
		data.add("");
		data.add(consola.getBtnPrueba());
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		data.add("");
		consola.getMiModelo().addRow(data);
		if (!consola.getBtnMenos().isEnabled())consola.getBtnMenos().setEnabled(true); 		
	}

}
