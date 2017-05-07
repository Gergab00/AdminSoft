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
public class ControladorNuevoProducto implements ActionListener {

	private ConsolaProductos consolaProductos;

	/**
	 * 
	 */
	public ControladorNuevoProducto(ConsolaProductos consolaProductos) {
		this.consolaProductos = consolaProductos;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		consolaProductos.getCampoID().setEditable(true);
		consolaProductos.getCampoID().setText("");
		consolaProductos.getComboBoxGrupo().setEnabled(true);
		consolaProductos.getCampoNombre().setEditable(true);
		consolaProductos.getCampoNombre().setText("");
		consolaProductos.getCampoPreciosIVA().setEditable(true);
		consolaProductos.getCampoPreciosIVA().setText("0.00");
		consolaProductos.getCampoPreciocIVA().setEditable(true);
		consolaProductos.getCampoPreciocIVA().setText("0.00");
		consolaProductos.getRdbtnNo().setEnabled(true);
		consolaProductos.getRdbtnNo().setSelected(true);
		consolaProductos.getRdbtnSi().setEnabled(true);
		consolaProductos.getBtnNuevo().setEnabled(false);
		consolaProductos.getBtnGuardar().setEnabled(true);
		consolaProductos.getBtnEditar().setEnabled(false);
		consolaProductos.getBtnEliminar().setEnabled(false);

	}

}
