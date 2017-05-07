package controlador.departamentos_grupos;

import java.awt.event.ActionEvent;
import modelo.Conexion;
import modelo.Departamentos;
import modelo.Grupos;
import vista.ConsolaDepartamento;
import vista.ConsolaGrupos;

public class ControladorEditar implements InterfaceDepartamentosGrupos, Conexion {

	/**
	 * 
	 */
	private ConsolaDepartamento consolaDepartamento = null;
	private ConsolaGrupos consolaGrupos = null;

	public ControladorEditar(ConsolaDepartamento consolaDepartamento) {
		// TODO Auto-generated constructor stub
		this.consolaDepartamento = consolaDepartamento;
	}

	public ControladorEditar(ConsolaGrupos consolaGrupos) {
		this.consolaGrupos = consolaGrupos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (consolaDepartamento != null) {
			consolaDepartamento.getBtnEditar().setEnabled(false);
			consolaDepartamento.getBtnEliminar().setEnabled(false);
			consolaDepartamento.getBtnGuardar().setEnabled(true);
			Departamentos.setID(consolaDepartamento.getCampoID().getText());
			consolaDepartamento.getCampoID().setEnabled(true);
			consolaDepartamento.getCampoNombre().setEnabled(true);
		}else if (consolaGrupos != null){
			consolaGrupos.getBtnEditar().setEnabled(false);
			consolaGrupos.getBtnEliminar().setEnabled(false);
			consolaGrupos.getBtnGuardar().setEnabled(true);
			Grupos.setID(consolaGrupos.getCampoID().getText());
			consolaGrupos.getCampoID().setEnabled(true);
			consolaGrupos.getCampoNombre().setEnabled(true);
		}
		
	}

}
