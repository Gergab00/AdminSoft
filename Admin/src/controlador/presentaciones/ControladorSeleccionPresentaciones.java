/**
 * 
 */
package controlador.presentaciones;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Presentaciones;
import vista.ConsolaPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccionPresentaciones extends Presentaciones implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaPresentaciones consola;

	/**
	 * @param consolaPresentaciones
	 * 
	 */
	public ControladorSeleccionPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		super();
		this.consola = consolaPresentaciones;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.
	 * ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//Esta sección toma las letras del campo de ID para poder hacer los movimientos necesarios en la base de datos 
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
			conexion();
			consola.getCampoID().setText(st);
			consola.getCampoID().setEditable(false);
			consola.getCampoNombre().setText(dameElementoPresentacion(st, null, DAME_PRESENTACION));
			consola.getCampoNombre().setEditable(false);
			consola.getCampoVolumen().setText(dameElementoPresentacion(st, null, DAME_VOLUMEN));
			consola.getCampoVolumen().setEditable(false);
			consola.getCampoUnidad().setText(dameElementoPresentacion(st, null, DAME_UNIDAD));
			consola.getCampoCostosIVA().setText(dameElementoPresentacion(st, null, DAME_PRECIO_S_IVA));
			consola.getCampoCostosIVA().setEditable(false);
			consola.getCampoIVA().setText(dameElementoPresentacion(st, null, DAME_IVA_VAL));
			consola.getCampoIVAPorc().setText(dameElementoPresentacion(st, null, DAME_IVA_PORC));
			consola.getCampoCostocIVA().setText(dameElementoPresentacion(st, null, DAME_PRECIO_C_IVA));
			consola.getCampoCostocIVA().setEditable(false);
			if (dameElementoPresentacion(st, null, DAME_TIENE_IVA).equals("true")) {
				consola.getRdbtnSi().setSelected(true);
			} else {
				consola.getRdbtnNo().setSelected(true);
			}
			consola.getRdbtnSi().setEnabled(false);
			consola.getRdbtnNo().setEnabled(false);
			consola.getBtnNuevo().setEnabled(true);
			consola.getBtnEditar().setEnabled(true);
			consola.getBtnEliminar().setEnabled(true);
			consola.getBtnGuardar().setEnabled(false);
			cerrarConexion();
		}
	}

}
