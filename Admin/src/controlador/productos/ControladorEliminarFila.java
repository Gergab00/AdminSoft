/**
 * 
 */
package controlador.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.productos.ConsolaProductos;

/**
 * @author Gerardo
 *
 */
public class ControladorEliminarFila implements ActionListener {

	private ConsolaProductos consola;

	/**
	 * @param consolaProductos 
	 * 
	 */
	public ControladorEliminarFila(ConsolaProductos consolaProductos) {
		this.consola = consolaProductos;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		consola.getMiModelo().removeRow(consola.getMiModelo().getRowCount()-1);
		if(consola.getMiModelo().getRowCount()==0)consola.getBtnMenos().setEnabled(false);
		
	}

}
