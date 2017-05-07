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
public class ControladorEliminar implements InterfaceDepartamentosGrupos {

	/**
	 * 
	 */
	private ConsolaDepartamento consolaDepartamentos;
	private ConsolaGrupos consolaGrupos;

	/**
	 * @param consolaDepartamento
	 * 
	 */
	public ControladorEliminar(ConsolaDepartamento consolaDepartamento) {
		// TODO Auto-generated constructor stub
		this.consolaDepartamentos = consolaDepartamento;
	}

	public ControladorEliminar(ConsolaGrupos consolaGrupos) {
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
		if(consolaDepartamentos != null)eliminarDepartamentos();
		if(consolaGrupos != null)eliminarGrupo();

	}

	@SuppressWarnings("unchecked")
	private void eliminarDepartamentos() {
		consolaDepartamentos.getCampoNombre().setText("");

		consolaDepartamentos.getBtnEditar().setEnabled(false);

		consolaDepartamentos.getBtnEliminar().setEnabled(false);

		if (deptos.eliminarDepartamento(consolaDepartamentos.getCampoID().getText())) {
			// System.out.println("Exito!");
			JOptionPane.showMessageDialog(null, "Elemento eliminado de forma exitosa.",
					"Elemento eliminado.", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "El elemento no se pudo eliminar.",
					"Elemento eliminado.", JOptionPane.ERROR_MESSAGE);
		}
		consolaDepartamentos.getCampoID().setText("");

		consolaDepartamentos.getList().setListData(new DatosLista().getVector(InterfaceDepartamentosGrupos.DEPTO));
	}
	
	@SuppressWarnings("unchecked")
	private void eliminarGrupo(){
		consolaGrupos.getCampoNombre().setText("");

		consolaGrupos.getBtnEditar().setEnabled(false);

		consolaGrupos.getBtnEliminar().setEnabled(false);
		if (gpos.eliminarGrupo(consolaGrupos.getCampoID().getText())) {
			// System.out.println("Exito!");
			JOptionPane.showMessageDialog(null, "Elemento eliminado de forma exitosa.",
					"Elemento eliminado.", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(null, "El elemento no se pudo eliminar.",
					"Elemento eliminado.", JOptionPane.ERROR_MESSAGE);
		}
		consolaGrupos.getCampoID().setText("");

		consolaGrupos.getList().setListData(new DatosLista().getVector(InterfaceDepartamentosGrupos.GPO));
	}

}
