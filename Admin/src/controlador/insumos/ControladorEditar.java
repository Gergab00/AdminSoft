/**
 * 
 */
package controlador.insumos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Insumos;
import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorEditar extends Insumos implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ConsolaInsumo consola;
	

	/**
	 * @param consolaInsumo 
	 * 
	 */
	public ControladorEditar(ConsolaInsumo consolaInsumo) {
		consola = consolaInsumo;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		consola.getCampoID().setEnabled(true);
		consola.getCampoNombre().setEnabled(true);
		consola.getComboBoxDepartamento().setEnabled(true);
		consola.getComboBoxUnidad().setEnabled(true);
		consola.getCampoCostosIVA().setEnabled(true);
		consola.getRdbtnSi().setEnabled(true);
		consola.getRdbtnNo().setEnabled(true);
		consola.getCampoCostocIVA().setEnabled(true);
		consola.getBtnGuardar().setEnabled(true);
		consola.getBtnNuevo().setEnabled(true);
		consola.getBtnEditar().setEnabled(false);
		consola.getBtnEliminar().setEnabled(false);
		consola.getMntmActualizarCosto().setEnabled(true);
		
		setSt_id(consola.getCampoID().getText());
		setSt_nominsumo(consola.getCampoNombre().getText());
		setSt_nomdepto(consola.getComboBoxDepartamento().getSelectedItem().toString());
		setSt_unidad(consola.getComboBoxUnidad().getSelectedItem().toString());
		setSt_precio_s_iva(consola.getCampoCostosIVA().getText());
		setTiene_iva(consola.getRdbtnSi().isSelected());
		setIva_porc(consola.getCampoIVAPorc().getText());
		setIva_val(consola.getCampoIVA().getText());
		setSt_precio_c_iva(consola.getCampoCostocIVA().getText());

/*		System.out.println(Insumos.getSt_id());
		System.out.println(Insumos.getSt_nominsumo());
		System.out.println(Insumos.getSt_nomdepto());
		System.out.println(Insumos.getSt_unidad());
		System.out.println(Insumos.getPrecio_c_iva());
		System.out.println(Insumos.isTiene_iva());*/
	}

}
