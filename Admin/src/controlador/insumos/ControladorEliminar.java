/**
 * 
 */
package controlador.insumos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Insumos;
import vista.ConsolaInsumo;

/**
 * @author Gerardo
 *
 */
public class ControladorEliminar extends Insumos implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConsolaInsumo consola;

	/**
	 * @param consolaInsumo
	 * 
	 */
	public ControladorEliminar(ConsolaInsumo consolaInsumo) {
		consola = consolaInsumo;
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (eliminarInsumo(consola.getCampoID().getText())) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el insumo", "Eliminando...",
					JOptionPane.INFORMATION_MESSAGE);
			if (eliminarPresentacionesDeInsumo(consola.getCampoNombre().getText())) {
				JOptionPane.showMessageDialog(null,
						"Se han eliminado correctamente todas las presentaciones del insumo", "Eliminando...",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar las presentaciones del insumo",
						"Eliminando...", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar el insumo", "Eliminando...",
					JOptionPane.WARNING_MESSAGE);
		}
		consola.getList().setListData(new DatosLista().dameDatos());
		consola.getCampoID().setText("");
		consola.getCampoID().setEnabled(false);
		consola.getCampoNombre().setText("");
		consola.getCampoNombre().setEnabled(false);
		consola.getComboBoxDepartamento().setEnabled(false);
		consola.getComboBoxUnidad().setEnabled(false);
		consola.getCampoCostosIVA().setText("0.00");
		consola.getCampoCostosIVA().setEnabled(false);
		consola.getRdbtnSi().setEnabled(false);
		consola.getRdbtnNo().setEnabled(false);
		consola.getRdbtnNo().setSelected(true);
		consola.getCampoCostocIVA().setText("0.00");
		consola.getCampoCostocIVA().setEnabled(false);
		consola.getCampoIVA().setText("0.00");
		consola.getCampoIVAPorc().setText("0.00");
		consola.getBtnGuardar().setEnabled(false);
		consola.getBtnNuevo().setEnabled(true);
		consola.getBtnEditar().setEnabled(false);
		consola.getBtnEliminar().setEnabled(false);
		consola.getMntmActualizarCosto().setEnabled(false);

	}

}
