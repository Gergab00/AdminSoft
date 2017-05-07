/**
 * 
 */
package controlador.presentaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Presentaciones;
import vista.ConsolaPresentaciones;

/**
 * @author Gerardo
 *
 */
public class ControladorEditarPresentaciones extends Presentaciones implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaPresentaciones consola;

	/**
	 * @param consolaPresentaciones 
	 * 
	 */
	public ControladorEditarPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		super();
		this.consola = consolaPresentaciones;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		consola.getCampoID().setEditable(true);
		consola.getCampoNombre().setEditable(true);
		consola.getCampoVolumen().setEditable(true);
		consola.getCampoCostosIVA().setEditable(true);
		consola.getRdbtnSi().setEnabled(true);
		consola.getRdbtnNo().setEnabled(true);
		consola.getCampoCostocIVA().setEditable(true);
		consola.getBtnGuardar().setEnabled(true);
		consola.getBtnNuevo().setEnabled(true);
		consola.getBtnEditar().setEnabled(false);
		consola.getBtnEliminar().setEnabled(false);
		
		setSt_id(consola.getCampoID().getText());
		setSt_nompres(consola.getCampoNombre().getText());
		setSt_insumo_padre(consola.getComboBoxInsumo().getSelectedItem().toString());
		setSt_volumen(consola.getCampoVolumen().getText());
		setSt_unidad(consola.getCampoUnidad().getText());
		setSt_precio_s_iva(consola.getCampoCostosIVA().getText());
		setTiene_iva(consola.getRdbtnSi().isSelected());
		setIva_porc(consola.getCampoIVAPorc().getText());
		setIva_val(consola.getCampoIVA().getText());
		setSt_precio_c_iva(consola.getCampoCostocIVA().getText());
		setEsEditar(true);
	}

}
