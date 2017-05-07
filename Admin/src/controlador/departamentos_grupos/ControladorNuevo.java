/**
 * 
 */
package controlador.departamentos_grupos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ConsolaDepartamento;
import vista.ConsolaGrupos;

/**
 * @author Gerardo
 *
 */
public class ControladorNuevo implements ActionListener {

	private ConsolaDepartamento consolaDepartamento = null;
	private ConsolaGrupos consolaGrupos = null;

	/**
	 * @param consolaDepartamento 
	 * 
	 */
	public ControladorNuevo(ConsolaDepartamento consolaDepartamento) {
		this.consolaDepartamento = consolaDepartamento;
	}

	public ControladorNuevo(ConsolaGrupos consolaGrupos) {
		this.consolaGrupos  = consolaGrupos;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (consolaDepartamento != null) {
			consolaDepartamento.getBtnGuardar().setEnabled(true);
			consolaDepartamento.getCampoID().setText("");
			consolaDepartamento.getCampoID().setEnabled(true);
			consolaDepartamento.getCampoNombre().setText("");
			consolaDepartamento.getCampoNombre().setEnabled(true);
			consolaDepartamento.getBtnNuevo().setEnabled(false);
			consolaDepartamento.getBtnEditar().setEnabled(false);
			consolaDepartamento.getBtnEliminar().setEnabled(false);
		}
		
		if (consolaGrupos != null) {
			// TODO Auto-generated method stub
			consolaGrupos.getBtnGuardar().setEnabled(true);
			consolaGrupos.getCampoID().setText("");
			consolaGrupos.getCampoID().setEnabled(true);
			consolaGrupos.getCampoNombre().setText("");
			consolaGrupos.getCampoNombre().setEnabled(true);
			consolaGrupos.getBtnNuevo().setEnabled(false);
			consolaGrupos.getBtnEditar().setEnabled(false);
			consolaGrupos.getBtnEliminar().setEnabled(false);
		}
		
	}

}
