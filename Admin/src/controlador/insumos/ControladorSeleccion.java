/**
 * 
 */
package controlador.insumos;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Insumos;
import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccion extends Insumos implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaInsumo consola;

	/**
	 * @param consolaInsumo 
	 * 
	 */
	public ControladorSeleccion(ConsolaInsumo consolaInsumo) {
		consola = consolaInsumo;
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
			String st = "";
			if (!consola.getList().isSelectionEmpty()) {
				for (int i = 0; i < consola.getList().getSelectedValue().toString().length(); i++) {

					char sqc = consola.getList().getSelectedValue().toString().charAt(i);

					if (sqc != ' ') {
						st = st + consola.getList().getSelectedValue().toString().charAt(i);
					}

					else {
						break;
					}

				}
				consola.getCampoID().setText(st);
				consola.getCampoNombre().setText(dameInsumos(st, null, DAME_INSUMO));
				consola.getComboBoxDepartamento().setSelectedItem(dameInsumos(st, null, DAME_DEPTO));
				consola.getComboBoxUnidad().setSelectedItem(dameInsumos(st, null, DAME_UNIDAD));
				consola.getCampoCostosIVA().setText(dameInsumos(st, null, DAME_PRECIO_S_IVA));
				if (dameInsumos(st, null, DAME_TIENE_IVA).equals("true")) {
					consola.getRdbtnSi().setSelected(true);
				} else {
					consola.getRdbtnNo().setSelected(true);
				}
				consola.getCampoCostocIVA().setText(dameInsumos(st, null, DAME_PRECIO_C_IVA));
				consola.getCampoIVAPorc().setText(dameInsumos(st, null, DAME_IVA_PORC));
				consola.getCampoIVA().setText(dameInsumos(st, null, DAME_IVA_VAL));
				consola.getBtnNuevo().setEnabled(true);
				consola.getBtnEditar().setEnabled(true);
				consola.getBtnEliminar().setEnabled(true);
				consola.getBtnGuardar().setEnabled(false);
				consola.getCampoID().setEnabled(false);
				consola.getCampoNombre().setEnabled(false);
				consola.getComboBoxDepartamento().setEnabled(false);
				consola.getComboBoxUnidad().setEnabled(false);
				consola.getCampoCostosIVA().setEnabled(false);
				consola.getRdbtnSi().setEnabled(false);
				consola.getRdbtnNo().setEnabled(false);
				consola.getCampoCostocIVA().setEnabled(false);
				consola.getBtnVerPresentaciones().setEnabled(true);
				consola.getBtnAgregarPresentacin().setEnabled(true);
				consola.getMntmActualizarCosto().setEnabled(true);
			}
	}

}
