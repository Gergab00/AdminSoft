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
public class ControladorNuevo extends Insumos implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaInsumo consola;

	/**
	 * @param consolaInsumo 
	 * 
	 */
	public ControladorNuevo(ConsolaInsumo consolaInsumo) {
		// TODO Auto-generated constructor stub
		consola = consolaInsumo;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		consola.getCampoID().setText("");
		consola.getCampoID().setEnabled(true);
		consola.getCampoNombre().setText("");
		consola.getCampoNombre().setEnabled(true);
		consola.getComboBoxDepartamento().setEnabled(true);
		consola.getComboBoxUnidad().setEnabled(true);
		consola.getCampoCostosIVA().setText("0.00");
		consola.getCampoCostosIVA().setEnabled(true);
		consola.getRdbtnSi().setEnabled(true);
		consola.getRdbtnNo().setEnabled(true);
		consola.getRdbtnNo().setSelected(true);
		consola.getCampoCostocIVA().setText("0.00");
		consola.getCampoCostocIVA().setEnabled(true);
		consola.getCampoIVA().setText("0.00");
		consola.getCampoIVAPorc().setText("0.00");
		consola.getBtnGuardar().setEnabled(true);
		consola.getBtnNuevo().setEnabled(false);
		consola.getBtnEditar().setEnabled(false);
		consola.getBtnEliminar().setEnabled(false);
		consola.getList().clearSelection();
		consola.getMntmActualizarCosto().setEnabled(false);

	}

}
