/**
 * 
 */
package controlador.productos;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Productos;
import vista.productos.ConsolaProductos;
import vista.productos.ConsolaVerInsumos;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccionProducto extends Productos implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaProductos consola = null;
	private ConsolaVerInsumos consolaVerInsumos = null;

	/**
	 * @param consola
	 * 
	 */
	public ControladorSeleccionProducto(ConsolaProductos consolaProductos) {
		this.consola = consolaProductos;

	}

	public ControladorSeleccionProducto(ConsolaVerInsumos consolaVerInsumos) {
		this.consolaVerInsumos = consolaVerInsumos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 * 
	 * @see Método diseñado para que al seleccionar un producto de la lista
	 * automaticamente se rellenen los campos necesarios
	 * 
	 * @see para poder editar o eliminar productos de la base de datos
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		conexion();
		if (consola != null) {
			// @see Esta sección toma las letras del campo de ID para poder hacer
			// los movimientos necesarios en la base de datos
			String st = "";
			if (!consola.getList().isSelectionEmpty()
					&& !consola.getList().getSelectedValue().toString().equals("No hay datos en la tabla!")) {
				for (int i = 0; i < consola.getList().getSelectedValue().toString().length(); i++) {

					char sqc = consola.getList().getSelectedValue().toString().charAt(i);

					if (sqc != ' ') {
						st = st + consola.getList().getSelectedValue().toString().charAt(i);
					}

					else {
						break;
					}

				}

				/*En base al ID se toma del array con el metodo dameProductos(), la información del producto para rellenar los campos en la IGU*/
				consola.getCampoID().setText(st);
				consola.getCampoID().setEditable(false);
				consola.getCampoNombre().setText(dameProducto(st, null, Productos.DAME_NOMPRODUCTO));
				consola.getCampoNombre().setEditable(false);
				consola.getComboBoxGrupo().setSelectedItem(dameProducto(st, null, DAME_GPO));
				consola.getComboBoxGrupo().setEditable(false);
				consola.getCampoPreciosIVA().setText(dameProducto(st, null, Productos.DAME_PRECIO_S_IVA));
				consola.getCampoPrecioActual().setText(dameProducto(st, null, Productos.DAME_PRECIO_S_IVA));
				consola.getCampoPreciosIVA().setEditable(false);

				if (dameProducto(st, null, DAME_TIENE_IVA).equals("true")) {
					consola.getRdbtnSi().setSelected(true);
					consola.getCampoIVAPorc().setText("16.00");
					consola.getCampoIVA().setText(dameProducto(st, null, Productos.DAME_IVA_VAL));
				} else {
					consola.getRdbtnNo().setSelected(true);
					consola.getCampoIVAPorc().setText("0.00");
					consola.getCampoIVA().setText("0.00");
				}
				consola.getRdbtnSi().setEnabled(false);
				consola.getRdbtnNo().setEnabled(false);
				consola.getCampoPreciocIVA().setText(dameProducto(st, null, Productos.DAME_PRECIO_C_IVA));
				consola.getCampoPreciocIVA().setEditable(false);
				consola.getBtnEditar().setEnabled(true);
				consola.getBtnEliminar().setEnabled(true);
				consola.getBtnGuardar().setEnabled(false);
				consola.getBtnNuevo().setEnabled(true);
			}
		}else{
			consolaVerInsumos.getBtnSeleccionar().setEnabled(true);

		}
		cerrarConexion();
	}
}
