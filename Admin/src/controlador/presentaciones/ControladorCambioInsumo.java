/**
 * 
 */
package controlador.presentaciones;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import modelo.Insumos;
import modelo.Presentaciones;
import vista.ConsolaPresentaciones;
import vista.ConsolaVerPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorCambioInsumo extends Insumos implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaVerPresentaciones consola2;
	private ConsolaPresentaciones consola;

	/**
	 * @param consolaVerPresentaciones 
	 * 
	 */
	public ControladorCambioInsumo(ConsolaVerPresentaciones consolaVerPresentaciones) {
		this.consola2 = consolaVerPresentaciones;
		this.consola = null;
		// TODO Auto-generated constructor stub
	}
	
	public ControladorCambioInsumo(ConsolaPresentaciones consolaPresentaciones) {
		this.consola = consolaPresentaciones;
		this.consola2 = null;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (consola2 != null) {
			if (consola2.getFrameVerPresentaciones().getName().equals("Ver Presentaciones")) {
				consola2.getCampoDepartamento().setText(
						dameInsumos(null, consola2.getComboBoxInsumo().getSelectedItem().toString(), DAME_DEPTO));
				consola2.getList().setListData(new DatosLista(consola2).dameDatos());
			} 
		}
		
		if (consola != null) {
			if (consola.getFrmPresentaciones().getName().equals("Presentaciones")) {
				Presentaciones.setEsEditar(false);
				consola.getCampoUnidad().setText(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(), DAME_UNIDAD));
				consola.getCampoCostosIVA().setText(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(), DAME_PRECIO_S_IVA));
				consola.getCampoCostocIVA().setText(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(), DAME_PRECIO_C_IVA));
				consola.getCampoIVA().setText(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(), DAME_IVA_VAL));
				consola.getCampoIVAPorc().setText(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(), DAME_IVA_PORC));
				consola.getList().setListData(new DatosLista(consola).dameDatos());
				if(dameInsumos(null, consola.getComboBoxInsumo().getSelectedItem().toString(),DAME_TIENE_IVA).equals("1")){
					consola.getRdbtnSi().setSelected(true);
				}else{
					consola.getRdbtnNo().setSelected(true);
				}
				consola.getCampoID().setText("");
				consola.getCampoID().setEditable(true);
				consola.getCampoNombre().setText("");
				consola.getCampoNombre().setEditable(true);
				consola.getCampoVolumen().setText("");
				consola.getCampoVolumen().setEditable(true);
				consola.getCampoCostosIVA().setEditable(true);
				consola.getCampoCostocIVA().setEditable(true);
				consola.getRdbtnSi().setEnabled(true);
				consola.getRdbtnNo().setEnabled(true);
				consola.getBtnEditar().setEnabled(false);
				consola.getBtnEliminar().setEnabled(false);
				consola.getBtnNuevo().setEnabled(false);
				consola.getBtnGuardar().setEnabled(true);

			} 
		}
	}

}
