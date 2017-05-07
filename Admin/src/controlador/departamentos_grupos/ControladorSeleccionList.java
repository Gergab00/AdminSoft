/**
 * 
 */
package controlador.departamentos_grupos;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.ConsolaDepartamento;
import vista.ConsolaGrupos;

/**
 * @author Gerardo
 *
 */
public class ControladorSeleccionList implements ListSelectionListener {

	private ConsolaDepartamento consolaDeparamento = null;
	private ConsolaGrupos consolaGrupos = null;

	/**
	 * @param consolaDepartamento
	 * 
	 */
	public ControladorSeleccionList(ConsolaDepartamento consolaDepartamento) {
		// TODO Auto-generated constructor stub
		this.consolaDeparamento = consolaDepartamento;
	}

	public ControladorSeleccionList(ConsolaGrupos consolaGrupos) {
		this.consolaGrupos = consolaGrupos;
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
		// TODO Auto-generated method stub
		if (consolaDeparamento != null)
			cambioDepartamento();
		if (consolaGrupos != null)
			cambioGrupo();
	}

	private void cambioGrupo() {
		// TODO Auto-generated method stub
		String id = "";
		if (!consolaGrupos.getList().isSelectionEmpty()) {
			for (int i = 0; i < consolaGrupos.getList().getSelectedValue().toString().length(); i++) {
				if (!id.endsWith(" ")) {
					id = id + consolaGrupos.getList().getSelectedValue().toString().charAt(i);
					// System.out.println(st);
				} else {
					break;
				}
			}

			consolaGrupos.getCampoID().setEnabled(false);

			consolaGrupos.getCampoNombre().setEnabled(false);

			consolaGrupos.getCampoID().setText(id.replace(" ", ""));

			consolaGrupos.getCampoNombre().setText(consolaGrupos.getList().getSelectedValue().toString().replace(id, ""));

			consolaGrupos.getBtnEditar().setEnabled(true);

			consolaGrupos.getBtnEliminar().setEnabled(true);

			consolaGrupos.getBtnNuevo().setEnabled(true);

			consolaGrupos.getBtnGuardar().setEnabled(false);
		}
	}

	private void cambioDepartamento() {
		String id = "";
		if (!consolaDeparamento.getList().isSelectionEmpty()) {
			for (int i = 0; i < consolaDeparamento.getList().getSelectedValue().toString().length(); i++) {
				if (!id.endsWith(" ")) {
					id = id + consolaDeparamento.getList().getSelectedValue().toString().charAt(i);
					// System.out.println(st);
				} else {
					break;
				}
			}

			consolaDeparamento.getCampoID().setEnabled(false);

			consolaDeparamento.getCampoNombre().setEnabled(false);

			consolaDeparamento.getCampoID().setText(id.replace(" ", ""));

			consolaDeparamento.getCampoNombre()
					.setText(consolaDeparamento.getList().getSelectedValue().toString().replace(id, ""));

			consolaDeparamento.getBtnEditar().setEnabled(true);

			consolaDeparamento.getBtnEliminar().setEnabled(true);

			consolaDeparamento.getBtnNuevo().setEnabled(true);

			consolaDeparamento.getBtnGuardar().setEnabled(false);
		}
	}

}
