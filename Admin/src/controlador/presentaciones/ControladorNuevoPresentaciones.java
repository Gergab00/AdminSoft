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
public class ControladorNuevoPresentaciones extends Presentaciones implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaPresentaciones consola;

	/**
	 * @param consola 
	 * 
	 */
	public ControladorNuevoPresentaciones(ConsolaPresentaciones consolaPresentaciones) {
		this.consola = consolaPresentaciones;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		consola.getCampoID().setText("");
		consola.getCampoID().setEditable(true);
		consola.getCampoNombre().setText("");
		consola.getCampoNombre().setEditable(true);
		consola.getCampoVolumen().setText("");
		consola.getCampoVolumen().setEditable(true);
		consola.getCampoCostosIVA().setText("0.00");
		consola.getCampoCostosIVA().setEditable(true);
		consola.getCampoCostocIVA().setText("0.00");
		consola.getCampoCostocIVA().setEditable(true);
		consola.getCampoIVA().setText("0.00");
		consola.getRdbtnSi().setSelected(true);
		consola.getRdbtnNo().setEnabled(true);
		consola.getRdbtnSi().setEnabled(true);
		consola.getBtnEditar().setEnabled(false);
		consola.getBtnEliminar().setEnabled(false);
		consola.getBtnGuardar().setEnabled(true);
		setEsEditar(false);
	}

}
