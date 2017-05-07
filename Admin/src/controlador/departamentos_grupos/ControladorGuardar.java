/**
 * 
 */
package controlador.departamentos_grupos;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import vista.ConsolaDepartamento;
import vista.ConsolaGrupos;

/**
 * @author Gerardo
 *
 */
public class ControladorGuardar implements InterfaceDepartamentosGrupos {

	/**
	 * 
	 */
	private ConsolaDepartamento consolaDepartamentos = null;
	private ConsolaGrupos consolaGrupos = null;

	/**
	 * @param consolaDepartamento
	 * 
	 */
	public ControladorGuardar(ConsolaDepartamento consolaDepartamento) {
		this.consolaDepartamentos = consolaDepartamento;		
	}

	public ControladorGuardar(ConsolaGrupos consolaGrupos) {
		this.consolaGrupos = consolaGrupos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(consolaDepartamentos != null)this.guardarDepartamentos();
		if(consolaGrupos != null)this.guardarGrupos();
	}

	@SuppressWarnings("unchecked")
	private void guardarGrupos() {
		if (!consolaGrupos.getCampoID().getText().isEmpty() && !consolaGrupos.getCampoNombre().getText().isEmpty()) {
			if (!consolaGrupos.getCampoID().getText().contains(" ")) {
				if (!consolaGrupos.getCampoID().getText().contains("\'") && !consolaGrupos.getCampoID().getText().contains("\"")
						&& !consolaGrupos.getCampoNombre().getText().contains("\'")
						&& !consolaGrupos.getCampoNombre().getText().contains("\"")) {
					if (!consolaGrupos.getBtnNuevo().isEnabled()) {
						crearGrupos(consolaGrupos.getCampoID().getText(), consolaGrupos.getCampoNombre().getText());
					} else {
						modificarGrupo(getID(GPO), consolaGrupos.getCampoID().getText(),consolaGrupos.getCampoNombre().getText());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Haz ingresado caracteres no validos(\',\").", "Error.",
							JOptionPane.ERROR_MESSAGE);
					consolaGrupos.getCampoID().setText("");
					consolaGrupos.getCampoNombre().setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "El ID no debe de contener espacios.", "Error.",
						JOptionPane.ERROR_MESSAGE);
				consolaGrupos.getCampoID().setText("");
				consolaGrupos.getCampoNombre().setText("");
			}

		} else {
			JOptionPane.showMessageDialog(null, "No ingresaste suficientes datos.", "Error.",
					JOptionPane.ERROR_MESSAGE);
		}
		consolaGrupos.getCampoID().setEnabled(false);
		consolaGrupos.getCampoNombre().setEnabled(false);
		consolaGrupos.getBtnEliminar().setEnabled(true);
		consolaGrupos.getBtnEditar().setEnabled(true);
		consolaGrupos.getBtnNuevo().setEnabled(true);
		consolaGrupos.getBtnGuardar().setEnabled(false);
		consolaGrupos.getCampoID().setText("");
		consolaGrupos.getCampoNombre().setText("");
		consolaGrupos.getList().setListData(new DatosLista().getVector(InterfaceDepartamentosGrupos.GPO));
	}

	@SuppressWarnings("unchecked")
	private void guardarDepartamentos() {
		if (!consolaDepartamentos.getCampoID().getText().isEmpty() && !consolaDepartamentos.getCampoNombre().getText().isEmpty()) {
			if (!consolaDepartamentos.getCampoID().getText().contains(" ")) {
				if (!consolaDepartamentos.getCampoID().getText().contains("\'") && !consolaDepartamentos.getCampoID().getText().contains("\"")
						&& !consolaDepartamentos.getCampoNombre().getText().contains("\'")
						&& !consolaDepartamentos.getCampoNombre().getText().contains("\"")) {
					if (!consolaDepartamentos.getBtnNuevo().isEnabled()) {
						crearDepartamento(consolaDepartamentos.getCampoID().getText(), consolaDepartamentos.getCampoNombre().getText());
					} else {
						modificarDepartamento(getID(DEPTO), consolaDepartamentos.getCampoID().getText(),
								consolaDepartamentos.getCampoNombre().getText());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Haz ingresado caracteres no validos(\',\").", "Error.",
							JOptionPane.ERROR_MESSAGE);
					consolaDepartamentos.getCampoID().setText("");
					consolaDepartamentos.getCampoNombre().setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "El ID no debe de contener espacios.", "Error.",
						JOptionPane.ERROR_MESSAGE);
				consolaDepartamentos.getCampoID().setText("");
				consolaDepartamentos.getCampoNombre().setText("");
			}

		} else {
			JOptionPane.showMessageDialog(null, "No ingresaste suficientes datos.", "Error.",
					JOptionPane.ERROR_MESSAGE);
			consolaDepartamentos.getCampoID().setText("");
			consolaDepartamentos.getCampoNombre().setText("");
		}
		consolaDepartamentos.getCampoID().setEnabled(false);
		consolaDepartamentos.getCampoNombre().setEnabled(false);
		consolaDepartamentos.getBtnEliminar().setEnabled(true);
		consolaDepartamentos.getBtnEditar().setEnabled(true);
		consolaDepartamentos.getBtnNuevo().setEnabled(true);
		consolaDepartamentos.getBtnGuardar().setEnabled(false);
		consolaDepartamentos.getList().setListData(new DatosLista().getVector(InterfaceDepartamentosGrupos.DEPTO));
	}

}
